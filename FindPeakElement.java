class Solution {
    public int findPeakElement(int[] a) {
        int l, r, m;
        l = 0;
        r = a.length - 1;
        while(l <= r) {
            if(l == r) {
                return l;
            }
            if (l == r - 1) {
                if (a[l] < a[r]) return r;
                return l;
            }
            m = l + (r - l) / 2;
            if(a[m] > a[m+1] && a[m] > a[m-1]) {
                return m;
            } else if(a[m] < a[m+1]) {
                l = m+1;
            } else {
                r = m-1;
            }
        }
        return 0;
    }
}