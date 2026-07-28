class Solution{
    public String smallestPalindrome(String s){
        int[]c=new int[26];
        for(char x:s.toCharArray())c[x-97]++;
        StringBuilder a=new StringBuilder(),b=new StringBuilder();
        char m=0;
        for(int i=0;i<26;i++){
            while(c[i]>1){
                a.append((char)(i+97));
                b.insert(0,(char)(i+97));
                c[i]-=2;
            }
            if(c[i]>0)m=(char)(i+97);
        }
        return a+(""+(m>0?m:""))+b;
    }
}