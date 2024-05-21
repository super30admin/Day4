
/**
 * Approach: Binary Search
 *
 * Working:
 *        Finding the upper bound of the array
 *          low = 0, high = 1
 *          when the target is greater that the high index value
 *              set low = high, set high = high*2  //performing the operation in logarithmic time complexity
 *        after obtaining the upper bound perform binary search
 *
 *
 * Time Complexity: O(long n)
 * Space Complexity: O(1)
 *
 */

class SearchInSortedArrayOfUnknownSize {
    public int search(ArrayReader reader, int target) {

        int low = 0;
        int high = 1;

        while(target > reader.get(high)) {
            low = high;
            high = high * 2;
        }

        while(low<=high) {

            int mid = low+(high-low)/2;
            int midVal = reader.get(mid);

            if(midVal == target) {
                return mid;
            }
            else if(target < midVal) {
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}
