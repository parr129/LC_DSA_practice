import java.util.*;

class Solution {
    int[] p;

    public int numSimilarGroups(String[] a){
        int n=a.length;
        p=new int[n];
        for(int i=0;i<n;i++) p[i]=i;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(f(i)!=f(j)&&ok(a[i],a[j])) u(i,j);
            }
        }
        int c=0;
        for(int i=0;i<n;i++) if(p[i]==i) c++;
        return c;
    }

    int f(int x){
        if(p[x]!=x) p[x]=f(p[x]);
        return p[x];
    }

    void u(int a,int b){
        p[f(a)]=f(b);
    }

    boolean ok(String a,String b){
        int c=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)&&++c>2) return false;
        }
        return true;
    }
}