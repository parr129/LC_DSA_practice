class Robot {
    int w,h,x,y,d,p;
    int[][] m={{1,0},{0,1},{-1,0},{0,-1}};
    String[] s={"East","North","West","South"};

    public Robot(int a,int b){
        w=a;
        h=b;
        x=0;
        y=0;
        d=0;
        p=2*(w+h-2);
    }

    public void step(int k){
        if(p==0) return;
        k%=p;
        if(k==0 && x==0 && y==0) d=3;
        while(k>0){
            int t=0;
            if(d==0) t=w-1-x;
            else if(d==1) t=h-1-y;
            else if(d==2) t=x;
            else t=y;

            if(t>=k){
                x+=m[d][0]*k;
                y+=m[d][1]*k;
                k=0;
            }else{
                x+=m[d][0]*t;
                y+=m[d][1]*t;
                k-=t;
                d=(d+1)%4;
            }
        }
    }

    public int[] getPos(){
        return new int[]{x,y};
    }

    public String getDir(){
        return s[d];
    }
}