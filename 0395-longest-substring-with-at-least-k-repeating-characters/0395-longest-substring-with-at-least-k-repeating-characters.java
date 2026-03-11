class Solution{
public int longestSubstring(String s,int k){
return f(s,0,s.length(),k);
}
int f(String s,int l,int r,int k){
int[] c=new int[26];
for(int i=l;i<r;i++)c[s.charAt(i)-'a']++;
for(int i=l;i<r;i++){
if(c[s.charAt(i)-'a']<k)
return Math.max(f(s,l,i,k),f(s,i+1,r,k));
}
return r-l;
}
}