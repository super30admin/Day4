// Time Complexity : O(log n) since we are doing binary search recursively
// Space Complexity : O(log n) number of recursive calls
// Did this code successfully run on Leetcode : Partially
// Any problem you faced while coding this : Challenge was to consider all the possibilities. I did Binary search on both directions but using the same recursive function
/*Algorithm:  Find the mid element recursively to land up on the searched element. Then do a binary search recursively at the left and binary search
recrusively at the right to get left and right element if the occurance of the same element found.
Left will give start position and right will give end position. If both return -1, implies mid is either at the start or end position.
*/
class Solution {
    int[] result = new int[2];                  // to store my result
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length-1, left = -1, right = -1;
        BinarySearch(nums, start, end,target,left, right);
        if(result == null){                             // Result is empty
            result[0] = -1;
            result[1] = -1;
        }
        return result;
    }
    
    public int BinarySearch(int[] nums, int start, int end, int target,int left, int right) {
        if(end < start){
         return -1;   
        }
        int mid = start+ (end-start)/2;
        if(nums[mid] == target){
           if(mid != 0 && nums[mid] == nums[mid-1]){            // check if I should go for the left direction
           left =  BinarySearch(nums, start, mid-1, target,left, right);                    // Searching the left side
           } else if(left == 0 || mid ==0){             // case if my start position of the first occurance is 0
               return mid;
           }
           if(mid != nums.length -1 && nums[mid] == nums[mid+1]){
            right = BinarySearch(nums, mid+1, end, target,left, right);  // Search on the right side 
           } else if(right==nums.length-1 || mid == nums.length -1){     // case if my last position is the last occurance of the element
               return mid;
           }
           if(left == -1 && right != -1){               // Return values of left and right suggest that in the right no occurances were found
           result[0] = mid;
           result[1] = right;
           } else 
           if(left != -1 && right == -1){                  // Return values of left and right suggest that in the left no occurances were found
           result[0] = left;
           result[1] = mid;
           } else 
           if(left == -1 && right == -1){    //  Return values suggest that both the directions no occurances were found and hence it itself is the only occurance
           result[0] = mid;
           result[1] = mid;
           }  
        }
    else 
    if(nums[mid] > target){
            return BinarySearch(nums, start, mid-1, target,left,right);
        }
    else
    {       
            return BinarySearch(nums, mid+1, end, target,left, right);
    }
        return mid;
    }
}