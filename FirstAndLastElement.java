//Time Complexity : O(log (N))
//Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
/* Take ans array of size 2, Apply binary search on both halves of the array.*/
class FirstAndLastElement {

    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int[] ans = new int[2];
        Arrays.fill(ans, -1);

        while(low <= high){
            int mid = start + (end - start)/2;

            if(arr[mid] == target) {
                ans[0] = mid;
                high = mid - 1;
            }
            else if(arr[mid] < target)
                low = mid + 1;
            else
                high =  mid - 1;
        }

        low = 0;
        high = nums.length - 1;

        while(low <= high){
            int mid = start + (end - start)/2;

            if(arr[mid] == target) {
                ans[1] = mid;
                low = mid + 1;
            }
            else if(arr[mid] < target)
                low = mid + 1;
            else
                high =  mid - 1;
        }
        return ans;
    }
}