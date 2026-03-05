import java.util.*;

class MagicDictionary {

    List<String> l;

    public MagicDictionary() {
        l = new ArrayList<>();
    }

    public void buildDict(String[] d) {
        for(String s:d) l.add(s);
    }

    public boolean search(String w) {
        for(String s:l){
            if(s.length()!=w.length()) continue;

            int c=0;

            for(int i=0;i<s.length();i++){
                if(s.charAt(i)!=w.charAt(i)) c++;
                if(c>1) break;
            }

            if(c==1) return true;
        }

        return false;
    }
}