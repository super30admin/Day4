/*
    Time Complexity :  O(log(N)) N is size of input
    Space Complexity :O(1)
    Leetcode accepted : YES
*/

class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null && nums.length == 0){
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        
        
        while(left < right){
            
            int mid = (left + right)/2;
            // if mid element is greated than mid +1 we will update right pointer to mid 
            // else left pointer to mid + 1
            if(nums[mid] > nums[mid+1]){
                right = mid;
            }else{
                left = mid + 1;
            }
                        
        }
        return left;
        
    }
}