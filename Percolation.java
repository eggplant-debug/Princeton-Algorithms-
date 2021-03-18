import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import org.omg.PortableInterceptor.INACTIVE;

public class Percolation {
    // creates n-by-n grid, with all sites initially blocked
    // 0 is blocked，1 is opened
    private WeightedQuickUnionUF PercolationArray;
    private int count;
    private int[] a;// 记录地块的开关状态
    private int N;
    private int numberopen=0;

    public Percolation(int n){
        a=new int[n*n]; //全部是0的数组
        PercolationArray=new WeightedQuickUnionUF(n*n+2); //2为虚拟节点，用于进行最后一步的判断
        count=n*n;
        N=n;

    }
    private void valid(int row , int col){
        if(row>N || col>N ||row<=0||col<=0){
            throw new IllegalArgumentException();
        }
    }
    // opens the site (row, col) if it is not open already
    //还需考虑四周连接的水块
    public void open(int row, int col) {

        valid(row,col);
        numberopen+=1;
        if(isOpen(row,col)){
            return;
        }
        else{
            a[(row-1)*N+col-1]=1;

            if(row<N &&isOpen(row+1,col)){
                PercolationArray.union(row*N+row,(row+1)*N+col);
            }
            if(row>1 && isOpen(row-1,col)){
                PercolationArray.union(row*N+row,(row-1)*N+col);
            }
            if(col<N && isOpen(row,col+1)){
                PercolationArray.union(row*N+row,row*N+col+1);
            }
            if(col>1 && isOpen(row,col-1)){
                PercolationArray.union(row*N+row,row*N+col-1);
            }
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){
        valid(row,col);
        return a[(row-1)*N+col-1]==1;
    }

    // is the site (row, col) full?
    // 要考虑是否连通到了上面,从这个地块能否连通到最上的地块
    public boolean isFull(int row, int col){
        valid(row,col);
        for(int i=0;i<N;i++){
            if(a[i]==1 && isOpen(row, col) && PercolationArray.find(i)==PercolationArray.find((row-1)*N+col-1)){
                return true;
            }
        }
        return false;
    }

    // returns the number of open sites
    public int numberOfOpenSites(){
        return numberopen;
    }

    // does the system percolate?
    //
    public boolean percolates(){
//union 头节点 和第一行，尾节点和最后一行 ，两个for循环
        a[N*N]=1;
        a[N*N+1]=1;

        for(int i=0;i<N;i++){
            PercolationArray.union(N*N,i);
        }
        for(int i=N*(N-1);i<N*N;i++){
            PercolationArray.union(N*N+1,i);
        }
        return PercolationArray.find(N*N+1)==PercolationArray.find(N*N);
    }

    public static void main(String[] args) {
        Percolation p=new Percolation(10);
        for(int i=1;i<9;i+=2){
            p.open(i,i+1);
            System.out.println(p.a[i]);
        }

}
}
