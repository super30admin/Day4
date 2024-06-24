class Solution {

    /*
    Time Complexity: 0(2*log n)
    Space Complesity: 0(1)
    Approach: Perform two binary search one for lowest index & one for highest index and
    return the resultant array.
     */

    public int[] searchRange(int[] nums, int target) {

        int [] result = new int[2];
        result[0] = -1;
        result[1] = -1;

        int low = 0;
        int high = nums.length-1;
        int mid = 0;

        // perform binarySearch for lhs
        while(low <= high){
            mid = (high-low)/2 + low;

            if (nums[mid] == target){
                result[0] = mid; // potential lower index
                high = mid - 1; // chk if possible value on lhs
            }
            else if (nums[mid] < target) {
                low = mid+1;
            }
            else if (nums[mid] > target) {
                high = mid-1;
            }
        }

        // reset values
        low = 0;
        high = nums.length-1;
        mid = 0;

        // perform binarySearch for rhs
        while(low <= high){
            mid = (high-low)/2 + low;

            if (nums[mid] == target){
                result[1] = mid; // potential lower index
                low = mid + 1; // chk if possible value on rhs
            }
            else if (nums[mid] < target) {
                low = mid+1;
            }
            else if (nums[mid] > target) {
                high = mid-1;
            }
        }

        return result;
    }
}