// Time Complexity : O(log n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes.
// Any problem you faced while coding this : Had written the mid formula wrong and struggled with array out of bound exception.
//Applying binary search to find the peak. Changing the boundaries for binary search based on the highest neighbour of the two
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low + (high - low)/2;

            if((mid == 0 || nums[mid]>nums[mid-1])
                    && (mid == nums.length-1 || nums[mid]>nums[mid+1])){
                return mid;
            }else if( mid > 0 && nums[mid]<nums[mid-1]){
                high = mid - 1;
            }else{
                low = mid +1;
            }
        }
        return -1;
    }
}
