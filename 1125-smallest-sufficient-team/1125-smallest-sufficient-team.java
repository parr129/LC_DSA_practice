class Solution {
    public int[] smallestSufficientTeam(String[] r, List<List<String>> p) {
        int n=r.length;
        Map<String,Integer> m=new HashMap<>();
        for(int i=0;i<n;i++)m.put(r[i],i);
        int t=1<<n;
        List<Integer>[] d=new List[t];
        d[0]=new ArrayList<>();
        for(int i=0;i<p.size();i++){
            int s=0;
            for(String x:p.get(i))if(m.containsKey(x))s|=1<<m.get(x);
            for(int j=0;j<t;j++){
                if(d[j]==null)continue;
                int nj=j|s;
                if(d[nj]==null||d[nj].size()>d[j].size()+1){
                    List<Integer> l=new ArrayList<>(d[j]);
                    l.add(i);
                    d[nj]=l;
                }
            }
        }
        List<Integer> l=d[t-1];
        int[] a=new int[l.size()];
        for(int i=0;i<a.length;i++)a[i]=l.get(i);
        return a;
    }
}