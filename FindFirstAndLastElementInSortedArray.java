// Time complexity : O(logn)
// Space complexity : O(1)

// Did problem run on leetcode : Yes

//binary search with 2 methods, one for left most and other for right most target value

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] targetRange = {-1, -1};
        
        targetRange[0] = binarySearchLeft(nums, target);
        if(targetRange[0] == -1){
            return targetRange;
        }
        targetRange[1] = binarySearchRight(nums, target);
        
        return targetRange;
    }
    
    private static int binarySearchLeft(int[] nums, int target){
        
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = l + (r-l)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;   
                }else{
                    r = mid-1;
                }
            }else if(nums[mid] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return -1;
    }
    
    private static int binarySearchRight(int[] nums, int target){
        int l = 0, r = nums.length - 1;
        
        while(l <= r){
            int mid = l + (r - l)/2;
            if(nums[mid] == target){
                if(mid == nums.length - 1 || nums[mid] < nums[mid+1]){
                    return mid;
                }else{
                    l = mid + 1;
                }
            }else if(nums[mid] > target){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return -1;
    }
}


// binary search with 1 method, using boolean flag

// class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int[] targetRange = {-1, -1};
//         int leftIdx = binarySearch(nums, target, true);
//         if(leftIdx == nums.length || nums[leftIdx] != target){
//             return targetRange;
//         }
//         targetRange[0] = leftIdx;
//         targetRange[1] = binarySearch(nums, target, false) - 1;
//         return targetRange;
//     }
    
//     private static int binarySearch(int[] nums, int target, boolean left){
        
//         int l=0, r=nums.length;
//         while(l<r){
//             int mid = l+(r-l)/2;
//             if (nums[mid] > target || (left && target == nums[mid])) {
//                 r = mid;
//             }
//             else {
//                 l = mid+1;
//             }
//         }
//         return l;
//     }
    
// }

// Brute Force approach


// class Solution {
//     public int[] searchRange(int[] nums, int target) {
          
//         int[] targetRange = {-1, -1};
        
//         for(int i=0; i<nums.length; i++){
//             if(nums[i] == target){
//                 targetRange[0] = i;
//                 break;
//             }
//         }
        
//         if(targetRange[0] == -1){
//             return targetRange;
//         }
        
//         for(int j=nums.length - 1; j>=0; j--){
//             if(nums[j] == target){
//                 targetRange[1] = j;
//                 break;
//             }
//         }
//         return targetRange;
//     }
// }