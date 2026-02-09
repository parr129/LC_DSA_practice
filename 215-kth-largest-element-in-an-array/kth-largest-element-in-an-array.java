class Solution {
    public int findKthLargest(int[] a, int k) {
        PriorityQueue<Integer> q=new PriorityQueue<>();
        for(int x:a){
            q.add(x);
            if(q.size()>k)q.poll();
        }
        return q.peek();
    }
}
