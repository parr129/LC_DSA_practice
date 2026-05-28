class Solution {
    class Trie {
        Trie[] next = new Trie[26];
        int idx;
        int len = Integer.MAX_VALUE;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        Trie root = new Trie();

        for (int i = 0; i < wordsContainer.length; i++) {
            String s = wordsContainer[i];
            if (s.length() < root.len) {
                root.len = s.length();
                root.idx = i;
            }

            Trie node = root;
            for (int j = s.length() - 1; j >= 0; j--) {
                int c = s.charAt(j) - 'a';
                if (node.next[c] == null) node.next[c] = new Trie();
                node = node.next[c];

                if (s.length() < node.len) {
                    node.len = s.length();
                    node.idx = i;
                }
            }
        }

        int[] ans = new int[wordsQuery.length];

        for (int i = 0; i < wordsQuery.length; i++) {
            String s = wordsQuery[i];
            Trie node = root;

            for (int j = s.length() - 1; j >= 0; j--) {
                int c = s.charAt(j) - 'a';
                if (node.next[c] == null) break;
                node = node.next[c];
            }

            ans[i] = node.idx;
        }

        return ans;
    }
}