class Solution {
    public void solveSudoku(char[][] b) {
        solve(b,0,0);
    }
    boolean solve(char[][] b,int i,int j){
        if(i==9) return true;
        int ni=j==8?i+1:i, nj=j==8?0:j+1;
        if(b[i][j]!='.') return solve(b,ni,nj);
        for(char c='1';c<='9';c++){
            if(ok(b,i,j,c)){
                b[i][j]=c;
                if(solve(b,ni,nj)) return true;
                b[i][j]='.';
            }
        }
        return false;
    }
    boolean ok(char[][] b,int r,int c,char v){
        for(int k=0;k<9;k++) if(b[r][k]==v||b[k][c]==v) return false;
        int sr=(r/3)*3, sc=(c/3)*3;
        for(int x=0;x<3;x++) for(int y=0;y<3;y++)
            if(b[sr+x][sc+y]==v) return false;
        return true;
    }
}
