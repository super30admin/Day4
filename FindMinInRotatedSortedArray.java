class Solution {
    public int findMin(int[] a) {
        int l, r, m;
        l = 0;
        r = a.length - 1;
        if(a.length == 1) {
            return a[0];
        }
        while(l <= r) {
            if(a[l] < a[r]) {   //array is sorted already
                return a[l];
            } else if (l == r-1) { // only 2 elements left in comparison
                if (a[l] < a[r]) {
                    return a[l];
                }
                return a[r];
            }
            m = l + (r - l) / 2;
            if (m != 0 && a[m] < a[m-1] && a[m] < a[m+1]) { //mid itself is min
                return a[m];
            } else if(a[l] < a[m] && a[m] > a[r]) { //left is sorted, right is unsorted
                l = m;
            } else {    //left is unsorted, right is sorted
                r = m;
            }
        }
        return -1;
    }
}