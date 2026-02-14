class Solution {
    public int[] maxSlidingWindow(int[] a,int k) {
        int n=a.length;
        int[] r=new int[n-k+1];
        java.util.Deque<Integer> d=new java.util.ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!d.isEmpty()&&d.peekFirst()<=i-k)d.pollFirst();
            while(!d.isEmpty()&&a[d.peekLast()]<=a[i])d.pollLast();
            d.offerLast(i);
            if(i>=k-1)r[i-k+1]=a[d.peekFirst()];
        }
        return r;
    }
}
