/*Algorithm:
    1. We will perform 2 binary searchs one for getting the left index and the other for. getting the right index.
    2. Get the mid element If it is equal to the target, Check if the left is less than the mid if yes return the mid index else go to the left because we know there is one more element is there with the same value of target. If mid is not equal to the target, based on the target go to left or right(Normal BFS approach).
    3. Get the mid element If it is equal to the target, Check if the right is greater than the mid if yes return the mid index else go to the right because we know there is one more element is there with the same value of target. If mid is not equal to the target, based on the target go to left or right(Normal BFS approach).
    
    
    Time Complexity: O(logn)
    Space Complexity: O(1)
    
    Did the code run successfully on leetcode? Yes
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
       
        
        if(nums==null || nums.length==0) // Base Case
            return new int[]{-1,-1};
        
       
        
        return new int[]{leftSearch(nums, 0, nums.length-1, target), rightSearch(nums,0, nums.length-1, target)}; 
        
        
    }
    
    private int leftSearch(int[] nums, int low, int high, int target){
        
        
        while(low<=high){
            int mid = low + (high-low)/2 ; 
            if(nums[mid]==target){
                if(low == mid || nums[mid-1]< nums[mid]) return mid;
                else high = mid-1;
            }
            else if(nums[mid]>=target){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        
        return -1;
        
    }
    
    
    private int rightSearch(int[] nums, int low, int high, int target){
        
        while(low<=high){
            int mid = low + (high-low)/2 ;
            if(nums[mid]==target){
                if(mid==high || nums[mid]<nums[mid+1]) return mid;
                else low = mid+1;
            }
            else if(nums[mid]>=target){
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return -1;
        
    }
}