//A peak element is an element that is greater than its neighbors.
//Time Complexity: O(n)
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        if( nums.length ==1 || nums[0]>nums[1]) return 0;
        if(nums[high]>nums[high-1]) return high;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if ((mid ==0 ||nums[mid] > nums[mid-1]) && nums[mid] > nums[mid+1]) {
                return mid;
            } else if (mid ==0 || nums[mid] > nums[mid-1]) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return -1;
    }
}
