class Solution {
    String[] a={"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven",
    "Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    String[] b={"","","Twenty","Thirty","Forty","Fifty","Sixty","Seventy","Eighty","Ninety"};

    String f(int n){
        if(n==0) return "";
        if(n<20) return a[n]+" ";
        if(n<100) return b[n/10]+" "+f(n%10);
        return a[n/100]+" Hundred "+f(n%100);
    }

    public String numberToWords(int n){
        if(n==0) return "Zero";
        int[] v={1000000000,1000000,1000,1};
        String[] s={"Billion","Million","Thousand",""};
        String r="";
        for(int i=0;i<4;i++){
            if(n>=v[i]){
                r+=f(n/v[i])+s[i]+" ";
                n%=v[i];
            }
        }
        return r.trim().replaceAll(" +"," ");
    }
}