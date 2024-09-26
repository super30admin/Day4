// Time Complexity :o(logn)
// Space Complexity :0(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :some of the cases like when array length is 1 and 2.


// Your code here along with comments explaining your approach:- checking middle value with end and deciding to move start accordingly.
class Solution {
    public int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;
         while(start < end){
             int mid = start + (end - start) / 2;
             if(nums[mid] < nums[end]){
                 end = mid;}
             else{
                 start = mid + 1;
         }
         }
        return nums[start];}
}
   
