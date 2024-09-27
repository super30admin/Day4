// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int findMin(int[] nums) {
         if(nums[nums.length-1]>=nums[0]){
            return nums[0];
        }
        int high= nums.length-1;
        int low = 0;
        
        while(low<=high){
             if(nums[high]>=nums[low]){
                return nums[low];
             }   
            int mid= low+ (high-low)/2; //to avoid integer overflow
            
            
          
        
            if((mid==nums.length-1 || nums[mid+1]>nums[mid]) && (mid==0 || nums[mid-1]>nums[mid])){
            return nums[mid];
            }
            if(nums[low]<=nums[mid]){
                low = mid +1;
            }else{
                high = mid -1;
            }    
        }
    return 123;
    }
}

MY APPROACH:

1. First check if array is sorted nums[low]<=nums[high] return nums[low] as its minimum
2. And checking if mid is minimum my checking mid-1 > min <mid+1
3. Afterwards check if nums[low]<=nums[mid] as we are starting from low and we now low isn't min so always move to unsorted part and do again 

