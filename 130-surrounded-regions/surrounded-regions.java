class Solution {
    int n,m;
    char[][] b;
    void f(int i,int j){
        if(i<0||j<0||i>=n||j>=m||b[i][j]!='O') return;
        b[i][j]='T';
        f(i+1,j);f(i-1,j);f(i,j+1);f(i,j-1);
    }
    public void solve(char[][] a){
        b=a; n=a.length; m=a[0].length;
        for(int i=0;i<n;i++){
            if(b[i][0]=='O') f(i,0);
            if(b[i][m-1]=='O') f(i,m-1);
        }
        for(int j=0;j<m;j++){
            if(b[0][j]=='O') f(0,j);
            if(b[n-1][j]=='O') f(n-1,j);
        }
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                if(b[i][j]=='O') b[i][j]='X';
                else if(b[i][j]=='T') b[i][j]='O';
    }
}
