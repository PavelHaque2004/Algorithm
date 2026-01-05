import java.util.*;

class B {
    int g[][], n, pre[], dis[], color[];
    Queue<Integer> q = new LinkedList<>();

    B(int g[][], int n) {
        this.g = g;
        this.n = n;

        pre=new int[n];
        dis=new int[n];
        color=new int[n];

        for(int i=0;i<n;i++)
        {
            dis[i]=Integer.MAX_VALUE;
            pre[i]=-1;
        }

    }



void Start(int s)
{dis[0]=0;
    color[s]=1;
    q.add(s);
    
    while (!q.isEmpty()) {
        int u=q.remove();
        for(int v=0;v<n;v++)
        {
            if(g[u][v]==1 && color[v]==0)
            {
                color[v]=1;
                pre[v]=u;
                dis[v]=dis[u]+1;
                q.add(v);
            }
        }
        color[u]=2;
        System.out.println(u+" ");
    }
}

void printpath(int s,int d)
{
    if(s==d)
    {
        System.out.println(s);
        return;
    }
    else
    {
        printpath( s,pre[d]);
        System.out.println("->"+d);
    }
}


}

public class BSP {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Enter number of vertex=");
        int n=input.nextInt();
        int g[][]=new int[n][n];


        System.out.println("Enter graph =");
        for(i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                 g[i][j]=input.nextInt();
            }
        }
        B ob=new B(g,n);
        ob.Start(0);
        System.out.println();
        ob.printpath(0,6);
        System.out.println();


    }

}
