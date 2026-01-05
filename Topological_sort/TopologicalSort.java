package Topological_sort;
import java.util.Scanner;
import java.util.Stack;

class DFS
{
    int g[][],n,prev[],col[],d[],f[],time;
    Stack<Integer> st = new Stack<Integer>();
    
    DFS(int g[][], int n)
    {
        this.g=g;
        this.n=n;
        time =0;
        prev = new int[n];
        col = new int[n];
        d = new int[n];
        f = new int[n];
       for(int i=0;i<n;i++)
       {
           prev[i]=-1;
       }
    }
    
    void dfsvisit(int u)
    {
        if(col[u]!=2)
        {
            col[u]=1;
           d[u]= ++time;
        for(int v=0;v<n;v++)
        {
            if(g[u][v]==1 && col[v]==0)
            {
                col[v]=1;
                prev[v]=u;
                dfsvisit(v);
                
            }
        }
        col[u]= 2;
        st.push(u);
        f[u]=++time;
        }
    }
    
    void print()
    {
        System.out.print("Topological order: ");
        while(!st.isEmpty())
        {
            int x= st.pop();
            
            switch(x)
                    {
                case 0: System.out.print("Under ");
                break;
                case 1: System.out.print("pant ");
                break;
                case 2: System.out.print("belt ");
                break;
                case 3: System.out.print("shirt ");
                break;
                case 4: System.out.print("Tie ");
                break;
                case 5: System.out.print("Jac ");
                break;
                case 6: System.out.print("Socks ");
                break;
                case 7: System.out.print("shoes ");
                break;
                case 8: System.out.print("watch ");
                break;
               
            }
            //System.out.print(st.pop()+" ");
        }
    }
}
public class TopologicalSort {

    
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
       DFS dfs= new DFS(g,n);
       for(int i=0;i<n;i++)
       {
         dfs.dfsvisit(i);
       }
       
       dfs.print();
    }
    
}
