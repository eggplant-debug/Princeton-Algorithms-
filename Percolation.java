import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {
    // creates n-by-n grid, with all sites initially blocked
    // 0 is blocked，1 is opened
    private WeightedQuickUnionUF PercolationArray;
    private int count;
    private int[] a;// 记录地块的开关状态
    private int N;

    public Percolation(int n){
        a=new int[n*n]; //全部是0的数组
        PercolationArray=new WeightedQuickUnionUF(n*n);
        count=n*n;
        N=n;
    }
    public void valid(int row , int col){
        if(row>N || col>N ||row<0||col<0){
            throw new IllegalArgumentException();
        }
    }
    // opens the site (row, col) if it is not open already
    //还需考虑四周连接的水块
    public void open(int row, int col) {
        valid(row,col);
        if(isOpen(row,col)){
            return;
        }
        else{
            a[row*N+col]=1;
            //连接周围四个地块
//            if(isOpen)
        }
    }

    // is the site (row, col) open?
    public boolean isOpen(int row, int col){

    }

    // is the site (row, col) full?
    // 要考虑是否连通到了上面,从这个地块能否连通到最上的地块
    public boolean isFull(int row, int col){

    }

    // returns the number of open sites
    public int numberOfOpenSites(){

    }

    // does the system percolate?
    //
    public boolean percolates(){

    }

    // test client (optional)
    public static void main(String[] args) {

    }
}
