// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Finding the pivot or the min element in the array

 //find the pivot using altered binary search , pivot is the min element of the array 
    //set 2 pointer - one at the begining and one at the end , and  find the pivot - 3rd pointer

class Solution {
    public int findMin(int[] nums) {
  int left =0;
        int right = nums.length-1;
        while(left<right){
            int mid =(left+right)/2;
            if(nums[mid] > nums[right]){
                left = mid+1;
            }
            else{
                right =mid;
            }
        }
         return nums[right];
}
       
}