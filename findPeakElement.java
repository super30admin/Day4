//Time: O(log N)
//Space: O(1)


public class findPeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low < high) {
            int mid = low + (high - low) / 2;
            // go left
            if(nums[mid] > nums[mid + 1])
                high = mid;
            
            // go right
            else
                low = mid + 1;
        }
        return high;
    }
}
