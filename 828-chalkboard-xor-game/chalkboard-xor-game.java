class Solution {
    public boolean xorGame(int[] a) {
        int n=a.length,x=0;
        if(n%2==0) return true;
        for(int v:a) x^=v;
        return x==0;
    }
}