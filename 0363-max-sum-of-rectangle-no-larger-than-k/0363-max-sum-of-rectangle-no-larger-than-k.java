class Solution {
    public int maxSumSubmatrix(int[][] a, int k) {
        int m=a.length,n=a[0].length,r=Integer.MIN_VALUE;
        for(int l=0;l<n;l++){
            int[] s=new int[m];
            for(int c=l;c<n;c++){
                for(int i=0;i<m;i++) s[i]+=a[i][c];
                TreeSet<Integer> t=new TreeSet<>();
                t.add(0);
                int p=0;
                for(int x:s){
                    p+=x;
                    Integer y=t.ceiling(p-k);
                    if(y!=null) r=Math.max(r,p-y);
                    t.add(p);
                }
            }
        }
        return r;
    }
}