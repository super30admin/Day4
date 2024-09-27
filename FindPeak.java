// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no
//Time taken : 10 mins

public class FindPeak {
    public int findPeakElement(int[] nums) {
        int low = 0, high = nums.length-1;
        while(low<=high) {
            int mid = low+(high-low)/2;
            // It's peak if either element is first element & element+1 is lower or it's last & element-1 is lower
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==nums.length-1 || nums[mid]>nums[mid+1])) {
                return mid;
            }
            else if(mid<nums.length && nums[mid+1]>nums[mid]){
                // Move right because finding the element on right is higher.
                    // case 1 : array is sorted -> last element is peak
                    // case 2: array is not sorted -> there must be a peak on right
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return 0;
    }
}
