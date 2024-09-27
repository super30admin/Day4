class Solution {
    public int findFirst(int[] a, int t, int l, int r) {
        int m;
        while(l <= r) {
            m = l + (r - l) / 2;
            if(a[m] == t) {
                if(m == 0 || a[m-1] != t) {
                    return m;
                } else {
                    r = m - 1;
                }
            } else if(a[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
    public int findLast(int[] a, int t, int l, int r) {
        int m;
        while(l <= r) {
            m = l + (r - l) / 2;
            if(a[m] == t) {
                if(m == a.length - 1 || a[m+1] != t) {
                    return m;
                } else {
                    l = m + 1;
                }
            } else if(a[m] < t) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] a, int t) {
        int[] occ = new int[2];
        occ[0] = findFirst(a, t, 0, a.length - 1);
        if(occ[0] == -1) {
            occ[1] = -1;
        } else {
            occ[1] = findLast(a, t, occ[0], a.length - 1);
        }
        return occ;
    }
}