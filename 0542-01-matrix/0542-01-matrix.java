import java.util.*;
class Solution {
    public int[][] updateMatrix(int[][] a){
        int n=a.length,m=a[0].length;
        int[][] d=new int[n][m];
        Queue<int[]> q=new LinkedList<>();
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++){
                if(a[i][j]==0) q.add(new int[]{i,j});
                else d[i][j]=-1;
            }
        int[][] v={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty()){
            int[] x=q.poll();
            for(int[] k:v){
                int i=x[0]+k[0],j=x[1]+k[1];
                if(i>=0&&j>=0&&i<n&&j<m&&d[i][j]==-1){
                    d[i][j]=d[x[0]][x[1]]+1;
                    q.add(new int[]{i,j});
                }
            }
        }
        return d;
    }
}
