import java.util.*;

class LFUCache {
    class Node {
        int k, v, f = 1;
        Node p, n;
        Node(int key, int val) { k = key; v = val; }
    }

    class DLList {
        Node h, t;
        int size = 0;
        DLList() {
            h = new Node(0, 0);
            t = new Node(0, 0);
            h.n = t; t.p = h;
        }
        void add(Node node) {
            node.n = h.n; node.p = h;
            h.n.p = node; h.n = node;
            size++;
        }
        void remove(Node node) {
            node.p.n = node.n;
            node.n.p = node.p;
            size--;
        }
        Node popTail() {
            if (size > 0) {
                Node node = t.p;
                remove(node);
                return node;
            }
            return null;
        }
    }

    Map<Integer, Node> cache = new HashMap<>();
    Map<Integer, DLList> freq = new HashMap<>();
    int cap, min = 0;

    public LFUCache(int capacity) {
        cap = capacity;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) return -1;
        Node node = cache.get(key);
        update(node);
        return node.v;
    }

    public void put(int key, int value) {
        if (cap <= 0) return;
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.v = value;
            update(node);
        } else {
            if (cache.size() >= cap) {
                DLList list = freq.get(min);
                cache.remove(list.popTail().k);
            }
            Node node = new Node(key, value);
            cache.put(key, node);
            min = 1;
            freq.computeIfAbsent(1, k -> new DLList()).add(node);
        }
    }

    void update(Node node) {
        DLList oldList = freq.get(node.f);
        oldList.remove(node);
        if (node.f == min && oldList.size == 0) min++;
        node.f++;
        freq.computeIfAbsent(node.f, k -> new DLList()).add(node);
    }
}