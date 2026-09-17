package binary_search;

/**
 * LeetCode Link: https://leetcode.com/problems/sqrtx/
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x.
 */
public class SqrtX {
  public static void main(String[] args) throws Exception {
    System.out.println(mySqrt(Integer.MAX_VALUE));
  }

  public int mySqrt(int x) {
    int s = 0, e = x;
    long ans = 0L;
    while (s <= e) {
      long m = s + (e - s) / 2;
      long prod = m * m;
      if (prod <= x) {
        s = (int) (m + 1);
        ans = m;
      } else e = (int) m - 1;
    }
    return (int) ans;
  }
}
