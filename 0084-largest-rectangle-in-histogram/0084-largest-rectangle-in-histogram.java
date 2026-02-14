class Solution {
    public int largestRectangleArea(int[] h) {
        int n=h.length,m=0;
        java.util.Stack<Integer> s=new java.util.Stack<>();
        for(int i=0;i<=n;i++){
            int x=i==n?0:h[i];
            while(!s.isEmpty()&&h[s.peek()]>x){
                int ht=h[s.pop()];
                int w=s.isEmpty()?i:i-s.peek()-1;
                m=Math.max(m,ht*w);
            }
            s.push(i);
        }
        return m;
    }
}
