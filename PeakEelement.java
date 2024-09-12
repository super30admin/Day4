class Solution {
    int res=-1;
    public int findPeakElement(int[] nums) {
        if(nums.length==1 || nums[0]>nums[1])
            return 0;
        if(nums[nums.length-1]>nums[nums.length-2])
            return nums.length-1;
        
        searchPeak(nums, 1, nums.length-2);
        return res;
    }
    public void searchPeak(int[] nums, int low, int high){
        if(low<=high && res == -1){
            int mid = (high-low)/2 + low;
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                res = mid;
                return;
            }
            if(nums[mid] < nums[mid-1] || nums[mid] < nums[mid+1]){
                searchPeak(nums, low, mid-1);
                searchPeak(nums, mid+1, high);
            }
        }
    }
    
}

//Time complexity : O(logN)
//Space complexity : O(1)
