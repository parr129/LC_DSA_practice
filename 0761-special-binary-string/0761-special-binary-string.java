import java.util.*;
class Solution {
    public String makeLargestSpecial(String s) {
        int c=0,l=0,n=s.length();
        List<String> a=new ArrayList<>();
        for(int i=0;i<n;i++){
            c+=s.charAt(i)=='1'?1:-1;
            if(c==0){
                a.add("1"+makeLargestSpecial(s.substring(l+1,i))+"0");
                l=i+1;
            }
        }
        Collections.sort(a,Collections.reverseOrder());
        StringBuilder r=new StringBuilder();
        for(String x:a)r.append(x);
        return r.toString();
    }
}