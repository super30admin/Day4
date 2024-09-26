//TC: O(log(n))
//SC: O(1)

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 0) return -1;
        
        int l = 0;
        int h = nums.length - 1;
        int min = Integer.MAX_VALUE;
        while(l<=h) {
            int mid = l + (h-l)/2;
            min = Math.min(min, nums[mid]);
            if(nums[l] <= nums[mid] && nums[l] <= nums[h]) {
                //min is in first array
                 if(min <= nums[l]) {
                    l = mid + 1;
                     
                } else {
                    h = mid - 1;
                }
            } else {
                //min is in second array
                if(min <= nums[h]) {
                    h = mid - 1;
                    
                } else {
                    l = mid + 1;
                }
            }
        }
     return min;   
    }
}
