// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach in three sentences only:
//  I used a binary search approach to find the min element in an array. 
// I start by calculating the middle index mid.
//  If nums[mid] is less than its nums[m-1] and mid!=0, it is a min, and I return nums[mid].otherwise i just check which side part of array is sorted by comparing nums[low]<nums[mid] it means left size is sorted it indicated our min defintle will be in rightside 
//  So, I update low = mid + 1, effectively ignoring the left half. Otherwise, I search in the left half
//  by setting high = mid - 1. This process continues, reducing the search space until the peak element is found.



class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low <= high){
            if(nums[low] <= nums[high]){
                return nums[low];
            }else{
                int mid=low+(high-low)/2;
                //  if(low == high){
                //     return nums[low];
                // }
                   if(mid != 0 && nums[mid] < nums[mid-1]){
                    return nums[mid];
                }else{
                    //  if(mid == low){
                    //     low=mid+1;
                    //  }
                    if(nums[low] <= nums[mid]){
                       low=mid+1;
                    }else{
                        high=mid-1;
                    }
                }       
                  }
        }
        return 4567;
    }
}