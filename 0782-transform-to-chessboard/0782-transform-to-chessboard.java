class Solution {
    public int movesToChessboard(int[][] b) {
        int n=b.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if((b[0][0]^b[i][0]^b[0][j]^b[i][j])==1) return -1;
            }
        }
        int r=0,c=0;
        for(int i=0;i<n;i++){
            r+=b[0][i];
            c+=b[i][0];
        }
        if(r!=n/2&&r!=(n+1)/2) return -1;
        if(c!=n/2&&c!=(n+1)/2) return -1;
        int rs=0,cs=0;
        for(int i=0;i<n;i++){
            if(b[i][0]==i%2) rs++;
            if(b[0][i]==i%2) cs++;
        }
        if(n%2==1){
            if(rs%2==1) rs=n-rs;
            if(cs%2==1) cs=n-cs;
        }else{
            rs=Math.min(rs,n-rs);
            cs=Math.min(cs,n-cs);
        }
        return (rs+cs)/2;
    }
}