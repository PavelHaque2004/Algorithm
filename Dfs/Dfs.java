package Dfs;
import java.util.*;

class DFS1
{
    int g[][],col[],pre[],d[],f[],n,time;
    Stack<Integer>st=new Stack<>();
    DFS1(int g[][],int n)
    {
        this.g=g;
        this.n=n;
        time=0;
        pre=new int[n];
        col=new int[n];
        d=new int[n];
        f=new int[n];
        for(int i=0;i<n;i++)
        {
            col[i]=0;//white
            pre[i]=-1;
        }
    }

//first dfs
void dfsvisit(int u)
{
    // if(col[u]!=2)
    // {
        col[u]=1;
        d[u]=++time;


for(int v=0;v<n;v++)
{
    if(g[u][v]==1 && col[v]==0)
    {
        // col[v]=1;
        pre[v]=u;
        dfsvisit(v);
    }
}
col[u]=2;
st.push(u);
f[u]=++time;

    }


//second dfs call
void dfs2call()
{
    for(int i=0;i<n;i++)
    {
        pre[i]=-1;
        col[i]=0;
       
    }

 time=0;
    while (!st.isEmpty()) {
        int u=st.pop();
        if(col[u]!=2)
        {
            dfsvisit2(u);
            System.out.println();
        }
    }
}

//reverse dfs
void dfsvisit2(int u)
{
    col[u]=1;
    d[u]=++time;

    for(int v=0;v<n;v++)
    {
        if(g[v][u]==1 && col[v]==0)
        {
            // col[v]=1;
            dfsvisit2(v);
        }
    }
    col[u]=2;
    f[u]=++time;
    System.out.println(u+" ");
}


}

public class Dfs {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       System.out.println("Enter number of nodes: ");
       int n = sc.nextInt();
       int g[][] = new int[n][n];
       System.out.println("Enter the graph: ");
       
       for(int i = 0; i<n; i++)
       {
           for(int j = 0;j<n; j++)
           {
             g[i][j] = sc.nextInt();
           }
       }

DFS1 ob=new DFS1(g,n);
//first dfs
for(int i=0;i<n;i++)
{
    if(ob.col[i]==0)
    ob.dfsvisit(i);
}

//second dfs
ob.dfs2call();
    }
}