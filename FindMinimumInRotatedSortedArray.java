// Time complexity : O(logn)
// Space complexity : O(1)

// Did problem run on leetcode : Yes

class Solution {
    public int findMin(int[] nums) {
        int l=0, r=nums.length-1;
        while(l <= r){
            int mid = l + (r - l)/2;
            
            if((mid == 0 || nums[mid] < nums[mid - 1]) && (mid == nums.length - 1 || nums[mid] < nums[mid+1])){
                return nums[mid];
            }else if(nums[mid] > nums[r]){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return -1;
    }
}



// class Solution {
//     public int findMin(int[] nums) {
//         int ptr = Integer.MAX_VALUE;
//         for(int i=0; i<nums.length; i++){
//             if(nums[i] < ptr){
//                 ptr = nums[i];
//             }
//         }
//         return ptr;
//     }
// }