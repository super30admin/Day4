/*
 * Time complexity - O(log(N)) where n is the  number of elements in the array 
 * Space Complexity  - O(1) no extra space used in this algortithm
 * Ran on leetcode - yes
 *
 */


/*Commented brute force method 
 * class Solution {
    public int findMin(int[] nums) {
        // brute force 
        int mini = Integer.MAX_VALUE;
        
        for (int num:nums){
            mini = Math.min(mini, num);
        }
        return mini;
    }
}
  */


class Solution {
    public int findMin(int[] nums) {
        int lo = 0 ; 
        int hi = nums.length - 1;
        
        while(lo < hi){
            
            int mid = lo + (hi-lo)/2;
            if (nums[mid] > nums[hi]) {
                // right is unsorted, move towards right , since the unsorted side will contain the mnimum most element
              lo = mid+1;
            } else {
              hi = mid;  // hi = mid since we can have mid at first element, in that case, mid index can go negative 
            } 
            
            
        }
        return nums[lo];
        
    }
}