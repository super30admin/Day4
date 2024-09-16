// Time Complexity : O(logN) in all cases.
// Space Complexity : O(logN) since recursion
// Did this code successfully run on Leetcode : Yes and 100% Time 97% Space
// Any problem you faced while coding this : LeetCode test cases are not much reliable.


// Your code here along with comments explaining your approach

class Solution {
    //Defined the result as a global static variable. Static member is accessible throughout all the instances of the class.
    static int[] result ={-1,-1};
    
    //
    public static int[] searchRange(int[] nums, int target) {
        BinarySearch(nums, target, 0, nums.length-1); //Defining the initial start and end parameters as 0 and nums.length-1
        return result;
    }

    private static int BinarySearch(int[] nums, int target, int low, int high) {
        //Base case 1
        if(low>high) return -1;
        
        //Base case 2
        if(target <nums[low] || target > nums[high]){
            return -1;
        }
        
        //Modification to Binary Search as per our requirement.
        int mid = low + (high-low)/2;
        if(nums[mid]==target){ //a is the lower bound and b is the higher bound of the required result
            int a = BinarySearch(nums, target, low, mid-1);
            int b = BinarySearch(nums, target, mid+1, high);
            if(a==-1){ //Case 1: Not found in the left sub array
                result[0]=mid;
            } else if(a<=result[0]){ //Case 2: Found in the left sub array
                result[0]=a;
            }
            if(b==-1){ //Case 3: Not found in the right sub array
                result[1]=mid;
            } else if(b>=result[1]){ //Case 4: Found in the right sub array
                result[1]=b;
            }
            return mid; //Since nums[mid] is equal to target
        }
        if(nums[mid]<target){
            return BinarySearch(nums, target, mid+1, high);
        }
        if(nums[mid]>target){
            return BinarySearch(nums, target, low, mid-1);
        }
        return -1;
    }
    
}
