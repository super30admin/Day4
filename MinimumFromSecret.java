// Time Complexity : O(LogN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :
class Solution {
    public int Search(ArrayReader reader, int target) {

        if (reader.get(0) == Integer.MAX_VALUE) return -1;
        int low = 0;
        int high = 1;
        while (reader.get(high) < target) {
            low = high;
            high = high * 2;
        }

    }

    private int binarySearch (ArrayReader reader, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high-low)/2;

            if (target == reader.get(mid)) {
                return target;
            } else if (target < reader.get(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}