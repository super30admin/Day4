// Time complesxity: O(log n)
// space complexity: O(1)
// approach:
// 1.  find the element in the array 
// 2. if element is present find the firstAppearance 
// 3. find the  lastAppearance 


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        
        result[0] = firstAppearance(nums, target);
        result[1] = lastAppearance(nums, target);
        
        return result;
    }
    
    public int firstAppearance(int[] nums, int target){
        int start = 0;
        int end = nums.length -1;
        int res = -1;
        while(start<=end){
            int mid = (start + end)/2;
            if(target > nums[mid]){
                start = mid +1;
            }
            else if(target < nums[mid]){
                end = mid -1;
            }
            
            else {
                res = mid;
                end = mid -1;
            }
        }
        return res;
    }
    
     public int lastAppearance(int[] nums, int target){
        
        int start = 0;
        int end = nums.length -1;
        int res = -1;
        while(start<=end){
            int mid = (start + end)/2;
            if(target > nums[mid]){
                start = mid +1;
            }
            else if(target < nums[mid]){
                end = mid -1;
            }
            
            else {
                res = mid;
                start = mid +1;
            }
        }
        return res;
    }
}