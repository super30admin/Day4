// Time Complexity : O(logn) where n is the number of elements in nums. 
// Space Complexity : O(1).

public class Solution2 {
        public int findMin(int[] nums) {
            int n = nums.length;
        //checking if the numbers are sorted, return the first element. 
        if(nums[0]<=nums[n-1]){
            return nums[0];
        }
        int low = 0, high = nums.length - 1;
        while(low<=high) {
            int mid = low + (high - low) / 2;
            //if value at mid is greater than value at 0, then search to right 
            if (nums[mid] >= nums[0]) {
                low = mid + 1;
            }
            //else search to left. 
            else{
                high = mid-1;
            }
        }
        return nums[low]; 
    }
}
