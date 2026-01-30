class Solution {
    public int numIslands(char[][] g){
        int r=g.length,c=g[0].length,cnt=0;
        for(int i=0;i<r;i++) for(int j=0;j<c;j++)
            if(g[i][j]=='1'){
                cnt++;
                dfs(g,i,j,r,c);
            }
        return cnt;
    }
    void dfs(char[][] g,int i,int j,int r,int c){
        if(i<0||j<0||i>=r||j>=c||g[i][j]!='1') return;
        g[i][j]='0';
        dfs(g,i+1,j,r,c);
        dfs(g,i-1,j,r,c);
        dfs(g,i,j+1,r,c);
        dfs(g,i,j-1,r,c);
    }
}
