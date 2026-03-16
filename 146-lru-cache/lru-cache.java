import java.util.*;

class LRUCache {
    class Node {
        int k,v;
        Node prev,next;
        Node(int k,int v){this.k=k;this.v=v;}
    }

    Map<Integer,Node> map=new HashMap<>();
    int cap;
    Node head=new Node(0,0),tail=new Node(0,0);

    public LRUCache(int capacity) {
        cap=capacity;
        head.next=tail;
        tail.prev=head;
    }

    void remove(Node n){
        n.prev.next=n.next;
        n.next.prev=n.prev;
    }

    void insert(Node n){
        n.next=head.next;
        n.prev=head;
        head.next.prev=n;
        head.next=n;
    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node n=map.get(key);
        remove(n);
        insert(n);
        return n.v;
    }

    public void put(int key,int value) {
        if(map.containsKey(key)) remove(map.get(key));
        Node n=new Node(key,value);
        map.put(key,n);
        insert(n);
        if(map.size()>cap){
            Node l=tail.prev;
            remove(l);
            map.remove(l.k);
        }
    }
}