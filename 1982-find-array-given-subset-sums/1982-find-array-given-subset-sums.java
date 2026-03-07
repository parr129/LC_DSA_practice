class Solution{
public int[] recoverArray(int n,int[] s){
Arrays.sort(s);
List<Integer> r=new ArrayList<>();

while(n-->0){
int d=s[1]-s[0];
List<Integer>a=new ArrayList<>();
List<Integer>b=new ArrayList<>();
Map<Integer,Integer>m=new HashMap<>();

for(int x:s)m.put(x,m.getOrDefault(x,0)+1);

for(int x:s){
if(m.get(x)==0)continue;
a.add(x);
b.add(x+d);
m.put(x,m.get(x)-1);
m.put(x+d,m.get(x+d)-1);
}

if(a.contains(0)){
r.add(d);
s=a.stream().mapToInt(i->i).toArray();
}else{
r.add(-d);
s=b.stream().mapToInt(i->i).toArray();
}
}

int[] ans=new int[r.size()];
for(int i=0;i<ans.length;i++)ans[i]=r.get(i);
return ans;
}
}