// Time Complexity :O(logN)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes( Array out of bound exceptions but solved)


// Your code here along with comments explaining your approach
Approach using Binary search and taking a Left and right pointer from the Middle element and checking the neighbouring elements

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int i = 0, j = nums.length-1;
        int[] arr = {-1, -1};
        if(nums.length == 1 && nums[0] == target){
            arr[0] = 0; arr[1] = 0;
            return arr;
        }
   else { while( i <= j){
            int mid = i + (j - i)/2;
            if(target == nums[mid]){
                int r = mid, l = i; 
               // arr[0] = l; arr[1] = r;
            while(r < nums.length)
            {
              if(nums[r]==target)
              {
                  arr[1]=r;
              }
                r++;
            }
            while(l<=mid)
            {
               if(nums[l]==target)
               {
                   arr[0]=l;
                   break;
               }
                l++;
            }
            return arr;
            }
            else if(target > nums[mid]){
                i = mid + 1;
            }
            else if(target < nums[mid]){
                j = mid - 1;
            }
        }
                return arr;
    }
}
            
}
