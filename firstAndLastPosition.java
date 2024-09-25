/*
 * Time complexity - O(log(N)) + O(log(N)) = O(log(N)) where N is the  number of elements in the array 
 * Space Complexity  - O(1) no extra space used in this algortithm
 * Ran on leetcode - yes
 */


/*
 * Brute force
 * class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] ans = new int[]{-1,-1};
        for(int i = 0 ; i < nums.length; i++){
            if (nums[i]==target){
                ans[0] =i ; 
                break;
            }
        }
        for(int i = 0 ; i < nums.length; i++){
            if (nums[i]==target){
                ans[1] =i ; 
            }
        }
      return ans;
        
    }
}

*/


class Solution {
    public int findFirst(int[] nums, int target ){
        
        int lo = 0 ; 
        int hi = nums.length -1;
        int first= -1 ;
        
        while(lo <= hi){
            int mid = lo + (hi-lo) /2;
            if (nums[mid] == target){
                first = mid;
                hi = mid -1;  
            } else if (nums[mid] < target ){
                // target is greater, move to wards right 
                lo = mid + 1;
            } else {
                // move towards left since target lies there
                hi  = mid-1;
            }
        }
        return first;
        
        
    }
    public int findLast(int[] nums, int target ){
        
        int lo = 0 ; 
        int hi = nums.length -1;
        int last = -1;
        while(lo <= hi){
            int mid = lo + (hi-lo) /2;
            if (nums[mid] == target){
                last = mid;
                lo = mid +1;  
            } else if (nums[mid] < target ){
                // move towards right, since target is greater than element at mid
                lo = mid + 1;
            } else {
                hi  = mid-1;
            }
        }
        return last;
        
        
    }
    public int[] searchRange(int[] nums, int target) {
        
        int [] ans = new int[2];
        
        ans[0] = findFirst(nums, target);
        ans[1] = findLast(nums, target);
        return ans;
    }
}