//brute force solution: find the min element in array by traversing
// time = O(n)

    //Binary search
    // Time: O(log n)
    // Space: O(1)

class Solution {
    public int findMin(int[] nums) {
        
        if(nums.length==1){
            return nums[0];
        }
        
        int low=0;
        int high=nums.length-1;
        
        if(nums[high]>nums[low]){
            return nums[0];
        }
        
        while(low<high){
            int mid=low+(high-low)/2;
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            if(nums[mid]>nums[mid+1]){
                return nums[mid+1];
            }
            
            if(nums[mid-1]>nums[mid]){
                return nums[mid];
            }
            
            if (nums[mid] > nums[0]) {
                low = mid + 1;
            } else {
        
             high = mid - 1;
        }
        }
        return -1;
       
        
        
    }
}