class TextEditor {
    StringBuilder l=new StringBuilder(),r=new StringBuilder();

    public TextEditor() {}

    public void addText(String text) {
        l.append(text);
    }

    public int deleteText(int k) {
        int d=Math.min(k,l.length());
        l.setLength(l.length()-d);
        return d;
    }

    public String cursorLeft(int k) {
        while(k-- >0 && l.length()>0){
            r.append(l.charAt(l.length()-1));
            l.deleteCharAt(l.length()-1);
        }
        return l.substring(Math.max(0,l.length()-10));
    }

    public String cursorRight(int k) {
        while(k-- >0 && r.length()>0){
            l.append(r.charAt(r.length()-1));
            r.deleteCharAt(r.length()-1);
        }
        return l.substring(Math.max(0,l.length()-10));
    }
}