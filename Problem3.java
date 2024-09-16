// 162. Find Peak Element
// Time compexity - O(log(n))
// space - O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        
        if(nums.length==1){
            return 0;
        }
        
        while(start<=end){
            int mid = start + (end-start)/2;
            
            if(mid==0 && nums[mid]>nums[mid+1]){
                return mid;
            }else if(mid==0){
                start = mid+1;
                continue;
            }
            
            if(mid==nums.length-1 && nums[nums.length-1]> nums[nums.length-2]){
                return mid;
            }else if(mid == nums.length-1){
                end = mid-1;
                continue;
            }
            
            if(nums[mid+1]<nums[mid] && nums[mid-1]<nums[mid]){
                return mid;
            }
            
            if(nums[mid+1]>nums[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }
}