package demo;

/**
 * 走阶梯，有n级阶梯，一次可以走一级、两级或者三级，请编写一个函数计算走完该阶梯一共有多少种种方法?
 */
class GoStep {

    public int getStairsWays(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return n;
        }
        return getStairsWays(n - 1) + getStairsWays(n - 2);
    }
}
