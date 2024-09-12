// time complexity: O(log(n))
// space complexity: O(1)

class Solution {
    public int search(ArrayReader reader, int target) {
        if (reader.get(0) == Integer.MAX_VALUE) {
            return -1;
        }
        int low = 0;
        int high = 1;

        while (reader.get(high) < target) {
            low = high;
            high *= 2;
        }
        return binarySearch(low, high, reader, target);
    }

    private int binarySearch(int low, int high, ArrayReader reader, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (reader.get(mid) == target) {
                return mid;
            } else {
                if (reader.get(mid) < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }
}