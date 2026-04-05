class Solution {
    public boolean judgeCircle(String s) {
        int x=0,y=0;
        for(char c:s.toCharArray()){
            if(c=='U') y++;
            else if(c=='D') y--;
            else if(c=='L') x--;
            else x++;
        }
        return x==0&&y==0;
    }
}