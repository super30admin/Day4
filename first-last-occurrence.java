class Solution {
    
    public int binarySearchFirst(int[] nums, int target) { 
        
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid]==target) {
                if(mid == low || nums[mid]>nums[mid-1]) {
                    return mid;
                } 
                else {
                    high = mid - 1;
                }
            }
            else if(nums[mid] > target) {
                high = mid - 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;
    }
    public int binarySearchLast(int[] nums, int target) { 
        
        int low = 0;
        int high = nums.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid]==target) {
                if(mid == high || nums[mid]<nums[mid+1]) {
                    return mid;
                } 
                else {
                    low = mid + 1;
                }
            }
            else if(nums[mid] > target) {
                high = mid - 1;
            }
            else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        
        if(nums == null || nums.length == 0) {
            return new int[] {-1,-1};
        }
        
        
        // first occurrence
        int first = binarySearchFirst(nums, target);
        int second = binarySearchLast(nums, target);
        
        
        return new int[] { first, second };
        
    }
}

// class Solution {
//     public int[] searchRange(int[] nums, int target) {

        // if(nums == null || nums.length == 0) {
        //     return -1;
        // }
        
//         int[] pos = new int[2];
        
//         pos[0] = -1;
//         pos[1] = -1;
        
//         int low = 0;
//         int high = nums.length-1;
        
//         // first occurrence
//         pos[0] = bs(low, high, nums, target, true);
        
//         low = 0;
//         high = nums.length-1;
//         // last occurrence
//         pos[1] = bs(low, high, nums, target, false);
        
//         return pos;
        
//     }
        // would end up searching more even after we found the element
//     public int bs(int low, int high, int[] nums, int target, boolean first) {
//         int res = -1;
//         while(low <= high) {
//             int mid = low + (high - low)/2;
//             if(nums[mid] == target) {
//                 res = mid; 
//                 if(first) {
//                     high = mid - 1;
//                 }
//                 else {
//                     low = mid + 1;
//                 }
//             }
//             else if (nums[mid] < target) {
//                 low = mid + 1;
//             }
//             else if (nums[mid] > target) {
//                 high = mid - 1;
//             }
//         }
        
//         return res;
//     }
// }
