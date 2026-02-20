class Solution {
    public String multiply(String a,String b){
        int n=a.length(),m=b.length();
        int[] r=new int[n+m];
        for(int i=n-1;i>=0;i--)
            for(int j=m-1;j>=0;j--){
                int p=(a.charAt(i)-'0')*(b.charAt(j)-'0');
                int s=p+r[i+j+1];
                r[i+j+1]=s%10;
                r[i+j]+=s/10;
            }
        StringBuilder sb=new StringBuilder();
        for(int x:r) if(!(sb.length()==0&&x==0)) sb.append(x);
        return sb.length()==0?"0":sb.toString();
    }
}