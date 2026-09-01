class Solution {
    public int minMoves(String[] g, int e) {
        int n=g.length,m=g[0].length(),k=0,sx=0,sy=0;
        int[][] id=new int[n][m];
        for(int[] a:id)java.util.Arrays.fill(a,-1);

        for(int i=0;i<n;i++)for(int j=0;j<m;j++){
            char c=g[i].charAt(j);
            if(c=='S'){sx=i;sy=j;}
            if(c=='L')id[i][j]=k++;
        }

        int z=1<<k, s=n*m*z;
        int[] b=new int[s];
        java.util.Arrays.fill(b,-1);

        int[] qx=new int[s*2],qy=new int[s*2],qm=new int[s*2],qe=new int[s*2],qd=new int[s*2];
        int h=0,t=0;
        int st=((sx*m+sy)*z);
        b[st]=e;
        qx[t]=sx;qy[t]=sy;qm[t]=0;qe[t]=e;qd[t++]=0;

        int[][] d={{1,0},{-1,0},{0,1},{0,-1}};

        while(h<t){
            int x=qx[h],y=qy[h],ms=qm[h],en=qe[h],mv=qd[h++];
            if(ms==z-1)return mv;

            for(int[] a:d){
                int X=x+a[0],Y=y+a[1];
                if(X<0||X>=n||Y<0||Y>=m||g[X].charAt(Y)=='X')continue;
                if(en==0)continue;

                int E=en-1,M=ms;
                char c=g[X].charAt(Y);

                if(c=='R')E=e;
                if(id[X][Y]>=0)M|=1<<id[X][Y];

                int p=(X*m+Y)*z+M;
                if(E<=b[p])continue;

                b[p]=E;
                qx[t]=X;qy[t]=Y;qm[t]=M;qe[t]=E;qd[t++]=mv+1;
            }
        }
        return -1;
    }
}