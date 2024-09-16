class Solution {
    public int findPeakElement(int[] nums) {
        // Initialize low and high
        int low = 0;
        int high = nums.length - 1;

        // Start Binary Search
        while(low <= high){
            int mid = low + (high - low) / 2;

            
            // if((mid == 0 && mid == nums.length - 1)||(mid == 0 && nums[mid] > nums[mid+1]) || (mid == nums.length - 1 && nums[mid] > nums[mid-1]) || (nums[mid] > nums[mid -1] && nums[mid] > nums[mid + 1])) -- all these conditions are taken care by the simple statement below!
            if((mid == 0 || nums[mid] > nums[mid - 1]) && ((mid == nums.length - 1) || (nums[mid] > nums[mid + 1])))
            {
                return mid;
            }
            else if (nums[mid] < nums[mid + 1]){
                // move to the right side
                low = mid + 1;
            }
            else{
                // move to the left side
                high = mid - 1;
            }
        }
        // If nothing is found
        return -1;
    }
    public static void main(String[] args){
        Solution s = new Solution();
        System.out.println(s.findPeakElement(new int[]{1}));
    }
}
