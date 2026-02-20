class Solution {
    public List<String> fullJustify(String[] w, int m) {
        List<String> r=new ArrayList<>();
        int i=0,n=w.length;
        while(i<n){
            int j=i,l=w[i].length();
            while(j+1<n&&l+1+w[j+1].length()<=m){
                j++;
                l+=1+w[j].length();
            }
            StringBuilder sb=new StringBuilder();
            int g=j-i,sp=m-(l-g);
            if(j==n-1||g==0){
                for(int k=i;k<=j;k++){
                    sb.append(w[k]);
                    if(k<j) sb.append(" ");
                }
                while(sb.length()<m) sb.append(" ");
            }else{
                int e=sp/g,x=sp%g;
                for(int k=i;k<=j;k++){
                    sb.append(w[k]);
                    if(k<j){
                        for(int s=0;s<e+(k-i<x?1:0);s++) sb.append(" ");
                    }
                }
            }
            r.add(sb.toString());
            i=j+1;
        }
        return r;
    }
}