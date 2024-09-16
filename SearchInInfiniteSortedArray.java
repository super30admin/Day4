public class SearchInInfiniteSortedArray {

    // Given a sorted array of unknown length and a number to search for, return the
    // index of the number in the array.
    // Accessing an element out of bounds throws exception.
    // If the number occurs multiple times, return the index of any occurrence. If
    // it isn’t present, return -1.

    // TC: O(1)
    // SC : O(1)
    // Does it successfully run on leetcode : Yes
    public int search(ArrayReader reader, int target) {

        int lo = 0;
        int hi = 1;

        while (reader.get(hi) < target) {
            lo = hi;
            hi = hi * 2;

        }

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (reader.get(mid) == target) {
                return mid;
            } else if (reader.get(mid) < target) {
                lo = mid + 1;
            } else
                hi = mid - 1;
        }
        return -1;

    }

}
