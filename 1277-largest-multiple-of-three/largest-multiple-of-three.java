class Solution{
    public String largestMultipleOfThree(int[] d){
        int s=0;
        for(int x:d)s+=x;
        java.util.Arrays.sort(d);
        java.util.List<Integer> a=new java.util.ArrayList<>();
        for(int x:d)a.add(x);
        int r=s%3;
        if(r!=0){
            for(int i=0;i<a.size();i++)
                if(a.get(i)%3==r){a.remove(i);r=0;break;}
            if(r!=0){
                int c=0;
                for(int i=0;i<a.size()&&c<2;i++)
                    if(a.get(i)%3==3-r){a.remove(i--);c++;}
            }
        }
        if(a.isEmpty())return "";
        StringBuilder sb=new StringBuilder();
        for(int i=a.size()-1;i>=0;i--)sb.append(a.get(i));
        if(sb.charAt(0)=='0')return "0";
        return sb.toString();
    }
}