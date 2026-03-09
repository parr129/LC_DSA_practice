class Solution{
Map<Integer,Boolean> m=new HashMap<>();
public boolean canIWin(int n,int t){
if(t<=0)return true;
if(n*(n+1)/2<t)return false;
return f(0,t,n);
}
boolean f(int s,int t,int n){
if(m.containsKey(s))return m.get(s);
for(int i=1;i<=n;i++){
int b=1<<(i-1);
if((s&b)==0){
if(i>=t||!f(s|b,t-i,n)){
m.put(s,true);
return true;
}
}
}
m.put(s,false);
return false;
}
}