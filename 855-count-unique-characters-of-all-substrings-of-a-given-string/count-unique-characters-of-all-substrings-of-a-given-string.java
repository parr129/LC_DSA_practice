class Solution {
    public int uniqueLetterString(String s){
        int[][] p=new int[26][2];
        for(int i=0;i<26;i++) p[i][0]=p[i][1]=-1;
        int r=0,n=s.length();
        for(int i=0;i<n;i++){
            int c=s.charAt(i)-'A';
            r+=(i-p[c][1])*(p[c][1]-p[c][0]);
            p[c][0]=p[c][1];
            p[c][1]=i;
        }
        for(int i=0;i<26;i++){
            r+=(n-p[i][1])*(p[i][1]-p[i][0]);
        }
        return r;
    }
}