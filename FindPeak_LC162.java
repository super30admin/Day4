//Time Complexity: O(log n)
//Space Complexity: O(1)
//Steps: BS
// 1. if value@mid < next mid element i.e. ascending element; keep searching to right array else
// 2. keep searching left
// 3. return low position

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low < high){
            int mid = low + (high - low)/ 2;
            
            if(nums[mid] < nums[mid + 1]){
                low = mid + 1;
            }
            else
                high = mid;
        }
        return low;
    }
}