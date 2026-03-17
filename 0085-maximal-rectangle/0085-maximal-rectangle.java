class Solution {
    public int maximalRectangle(char[][] m) {
        if(m.length==0) return 0;
        int n=m[0].length;
        int[] h=new int[n];
        int res=0;
        for(int i=0;i<m.length;i++){
            for(int j=0;j<n;j++)
                h[j]=m[i][j]=='1'?h[j]+1:0;
            res=Math.max(res,f(h));
        }
        return res;
    }
    int f(int[] h){
        int n=h.length,res=0;
        java.util.Stack<Integer> s=new java.util.Stack<>();
        for(int i=0;i<=n;i++){
            int x=i==n?0:h[i];
            while(!s.isEmpty() && x<h[s.peek()]){
                int ht=h[s.pop()];
                int w=s.isEmpty()?i:i-s.peek()-1;
                res=Math.max(res,ht*w);
            }
            s.push(i);
        }
        return res;
    }
}