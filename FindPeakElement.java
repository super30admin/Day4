// Find Peak Element
// Time Complexity: O(log N)
// Space Complexity: O(1)
// Did this code successfully run on Leetcode: Yes
// Any problem you faced while coding this: No

public class FindPeakElement {

    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low < high) {
            int mid1 = (low+high)/2;
            int mid2 = mid1+1;
            
            if(nums[mid1] < nums[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }

}
