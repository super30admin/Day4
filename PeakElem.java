//Exercise_10 : Find minimum in rotated Sorted Array
// Time Complexity : O(log(N))
// Space Complexity : O(1) constant space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :  No

/* Implement Binary Search, check whether arr[mid] is bigger than its neigbors, if it is return the mid. Otherwise check if arr[mid-1] is greater than the arr[mid]. If it is move end = mid-1. Else move start=mid+1 which means peak elemnt will be on the right side of the mid.

Note: While checking mid-1 or mid+1, check mid is not at the 0th index or the last index. Write conditions for these cases accordingly.
*/

class Solution10 {
    public int findPeakElement(int[] nums) {
     
    
        int start = 0;
        int N = nums.length;
        int end   = N-1;
        
        if(N==1){
          return 0;  
        }
        
        while(start<=end){
            
            int mid = start+(end-start)/2;
            
            if(mid>0 && mid<N-1){
                if(nums[mid]>nums[mid-1] && nums[mid]>nums[mid+1]){
                    return mid;
                }else if(nums[mid-1]>nums[mid]){
                    end = mid-1;
                }else if(nums[mid+1]>nums[mid]){
                    start = mid+1;
                }
            }else if(mid==0){
                if(nums[mid]>nums[mid+1]){
                    return mid;
                }else{
                    start = mid+1;
                }
            }else if(mid==N-1){
                if(nums[mid]>nums[mid-1]){
                    return mid;
                }else{
                    end = mid-1;
                }
            }
            
        }
        
        return -1;
        
    }
}