// time complexity - O(logn)
// Space complexity - O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        
        if(nums.length==1){
            return 0;
        }
        if(nums.length==2){
            if(nums[0]>nums[1]) return 0;
            else return 1;
        }
        int start=0;
        int end=nums.length-1;
        int mid;
        
        while(start<=end){
            mid= start + (end-start)/2;
            
            if(mid==0){
                if(nums[mid+1]>nums[mid]){
                    start=mid+1;
                    continue;
                }else return 0;
            }
            
            if(mid==nums.length-1){
                if(nums[mid-1]>nums[mid]){
                    end=mid-1;
                    continue;
                }else return nums.length-1;
            }
            
            if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]) {
                return mid;
            }
            
            if(nums[mid-1]<nums[mid]  && nums[mid]<nums[mid+1]){
                start=mid+1;
            }else{
                end=mid-1;
            }
            
        }
        return -1;
    }
}