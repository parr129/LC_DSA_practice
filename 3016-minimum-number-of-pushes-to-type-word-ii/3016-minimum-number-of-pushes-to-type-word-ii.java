class Solution {
    public int minimumPushes(String word) {
        int[] freq = new int[26];
        for (char c : word.toCharArray()) freq[c - 'a']++;
        Arrays.sort(freq);
        int total = 0, idx = 0;
        for (int i = 25; i >= 0 && freq[i] > 0; i--, idx++) {
            total += (idx / 8 + 1) * freq[i];
        }
        return total;
    }
}