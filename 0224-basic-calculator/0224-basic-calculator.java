class Solution {
    public int calculate(String s) {
        int r=0,n=0,sg=1;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isDigit(c)) n=n*10+c-'0';
            else if(c=='+'){ r+=sg*n; n=0; sg=1;}
            else if(c=='-'){ r+=sg*n; n=0; sg=-1;}
            else if(c=='('){ st.push(r); st.push(sg); r=0; sg=1;}
            else if(c==')'){ r+=sg*n; n=0; r*=st.pop(); r+=st.pop();}
        }
        return r+sg*n;
    }
}