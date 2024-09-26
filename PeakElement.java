/*
  Time Complexity : O(log(n))
  Space Complexity : O(1)

 Did this code successfully run on Leetcode : YES
 Any problem you faced while coding this :No 

Approach:Binary Search Approach
 */
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length <=0){
            return -1;
        }
        if(nums.length ==1)
        {
            return 0;
        }        
        int low =0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+ (high -low)/2;
            if(mid == 0){
                if(nums[mid] > nums[mid+1]){
                    return 0;
                }
                else{
                    return 1;
                }
            }
            else if(mid == nums.length-1){
                    if(nums[mid]> nums[mid-1]){
                        return nums.length -1;
                    }
                else{
                     return nums.length -2;
                }
            }
             else if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }else if(nums[mid] < nums[mid+1]) {
                 low = mid+1;
            }else if(nums[mid] < nums[mid-1]){
                high = mid-1;
            }
            
        }
    return -1;
        }
        
    }
