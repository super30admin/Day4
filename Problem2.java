// 153. Find Minimum in Rotated Sorted Array
// Time Complexity = Log(n) Space O(1)

class Solution {
    public int findMin(int[] nums) {
        int start = 0;
        int end = nums.length-1;
        int n = nums.length-1;
        
        if(n==0){
            return nums[0];
        }
        if(nums[0] < nums[n]){
            return nums[0]; 
        }
        
        while(start <= end){
            int mid = start + (end-start)/2;
            
            if(nums[mid]<nums[(mid-1+n)%n] && nums[mid] < nums[(mid+1+n)%n]){
                return nums[mid];
            }
            if(nums[mid] >= nums[0]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        
        return -1;
    }
}