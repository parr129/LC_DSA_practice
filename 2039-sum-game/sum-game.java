class Solution {
    public boolean sumGame(String num) {
        int left = 0, right = 0, qLeft = 0, qRight = 0;
        
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            if (c == '?') {
                if (i < num.length() / 2) qLeft++;
                else qRight++;
            } else {
                if (i < num.length() / 2) left += c - '0';
                else right += c - '0';
            }
        }
        
        int diff = left - right;
        int qDiff = qLeft - qRight;
        
        if ((qLeft + qRight) % 2 != 0) return true;
        
        return diff + 9 * qDiff / 2 != 0;
    }
}