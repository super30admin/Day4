/**
 * // This is ArrayReader's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface ArrayReader {
 *     public int get(int index) {}
 * }
 */
//Complexity : O(Log N)
class Solution {
    public int search(ArrayReader reader, int target) {

        int low = 0;
        int high = 1;

        while(target>reader.get(high))
        {
            if(target > reader.get(high))
            {
                low = high;
                high = high*2;
            }
        }

        while(high >= low)
        {
            int mid = low +(high-low);

            if(reader.get(mid) == target)
                return mid;

            if(reader.get(mid)>target)
                high=mid-1;
            else
                low =mid+1;
        }

        return -1;
    }
}