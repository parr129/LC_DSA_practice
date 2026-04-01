class Solution{
    public boolean isValid(String s){
        Stack<String> st=new Stack<>();
        for(int i=0;i<s.length();){
            if(i>0&&st.isEmpty())return false;
            if(s.startsWith("<![CDATA[",i)){
                int j=s.indexOf("]]>",i);
                if(j<0)return false;
                i=j+3;
            }else if(s.startsWith("</",i)){
                int j=s.indexOf(">",i);
                if(j<0)return false;
                String t=s.substring(i+2,j);
                if(st.isEmpty()||!st.pop().equals(t))return false;
                i=j+1;
            }else if(s.startsWith("<",i)){
                int j=s.indexOf(">",i);
                if(j<0)return false;
                String t=s.substring(i+1,j);
                if(t.length()<1||t.length()>9)return false;
                for(char c:t.toCharArray())if(c<'A'||c>'Z')return false;
                st.push(t);
                i=j+1;
            }else i++;
        }
        return st.isEmpty();
    }
}