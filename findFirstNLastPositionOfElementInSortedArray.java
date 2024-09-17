// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : Yes, then look into the discussion and understood

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] resultantArray = new int[2];
        int low = 0;
        int high = nums.length - 1;
        int firstIndex = -1;
        // After finding the mid, we are checking whether there's any target value before that mid index, if so, we will make high to mid minus 1,
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(nums[mid] == target) firstIndex = mid;
            if(target <= nums[mid]) high = mid - 1;
            else low = mid+1;
        }
        low = 0;
        high = nums.length -1;
        int secondIndex = -1;
        while(low<=high) {
            int mid = low+(high-low)/2;
            if(nums[mid] == target) secondIndex = mid;
            if(target >= nums[mid]) low = mid + 1;
            else high = mid-1;
        }
        resultantArray[0] = firstIndex;
        resultantArray[1] = secondIndex;
        return resultantArray;
    }


}
// Time Complexity :O(N)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this : No

// //class Solution {
//     public int[] searchRange(int[] nums, int target) {
//         int low = 0;
//         int high = nums.length - 1;
//         int foundTarget = -1;
//         int[] resultantArray = {-1, -1};
//         while(low<=high) {
//             int mid = low+(high-low)/2;
//             if(nums[mid] == target) {
//                 foundTarget = mid;
//                 break;
//             } else if(target < nums[mid]) high = mid -1;
//             else low = mid + 1;
//         }
//         if(foundTarget == -1) {
//             return resultantArray;
//         };
//         int pointer1 = foundTarget;
//         int pointer2 = foundTarget;
//         while(pointer1 >= 0 && nums[pointer1] == target) {
//             pointer1--;
//         }
//         while(pointer2 <= nums.length -1 && nums[pointer2] == target) {
//             pointer2++;
//         }
//         resultantArray[0] = pointer1+1;
//         resultantArray[1] = pointer2-1;
//         return resultantArray;
//     }
// }