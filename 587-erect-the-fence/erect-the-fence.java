class Solution{
    public int[][] outerTrees(int[][] p){
        Arrays.sort(p,(a,b)->a[0]==b[0]?a[1]-b[1]:a[0]-b[0]);
        List<int[]> s=new ArrayList<>();
        for(int[] a:p){
            while(s.size()>1&&c(s.get(s.size()-2),s.get(s.size()-1),a)<0)s.remove(s.size()-1);
            s.add(a);
        }
        int t=s.size();
        for(int i=p.length-2;i>=0;i--){
            int[] a=p[i];
            while(s.size()>t&&c(s.get(s.size()-2),s.get(s.size()-1),a)<0)s.remove(s.size()-1);
            s.add(a);
        }
        Set<String> h=new HashSet<>();
        List<int[]> r=new ArrayList<>();
        for(int[] a:s){
            String k=a[0]+","+a[1];
            if(!h.contains(k)){
                h.add(k);
                r.add(a);
            }
        }
        return r.toArray(new int[r.size()][]);
    }
    int c(int[] a,int[] b,int[] c){
        return (b[0]-a[0])*(c[1]-a[1])-(b[1]-a[1])*(c[0]-a[0]);
    }
}