import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;


import java.util.Random;


public class PercolationStats {
    int T;


    //
    public PercolationStats(int n, int trials) {
        T = trials;// 代表做多少次实验
        int[] PercolateOpenSite = new int[T];
        Percolation p = new Percolation(n);
        int[] resultArray = new int[n * n];
        int[] startArray = new int[n * n];

        for (int i = 0; i < startArray.length; i++) {
            startArray[i] = i;
        }

        for (int i = 0; i < n * n; i++) {
            int seed = StdRandom.uniform(0, startArray.length - 1);
            resultArray[i] = startArray[seed];//这个是双随机出来的数，但还是要经过转换变成col,row

            startArray[seed] = startArray[startArray.length - i - 1];
            p.open();
        }

    }

    // sample mean of percolation threshold
    public double mean() {

    }

    // sample standard deviation of percolation threshold
    public double stddev() {

    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - 1.96 * stddev() / (Math.sqrt(T));
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + 1.96 * stddev() / (Math.sqrt(T));
    }

    // test client (see below)
    public static void main(String[] args)

}
