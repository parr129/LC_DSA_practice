class Solution{
public List<String> findRepeatedDnaSequences(String s){
Set<String>a=new HashSet<>(),b=new HashSet<>();
for(int i=0;i+9<s.length();i++){
String x=s.substring(i,i+10);
if(!a.add(x))b.add(x);
}
return new ArrayList<>(b);
}
}