public class MinimumRotated {
    public int findMin(int[] a) {
      int l = 0;
        int r = a.length - 1;
        
        while (a[l] > a[r]) {
            int m = (l + r) / 2;
            if (a[m] >= a[l]) l = m + 1;
            else r = m;
        }
        
        return a[l];
    }
}