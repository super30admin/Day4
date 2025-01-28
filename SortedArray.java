// Overall Time Complexity : O log(n) . The n is number of elements in the search space.
// Overall Space Complexity : O(1) . The space complexity of storing the values in variables like low, high uses constant space.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No issues faced during implementation


// The solution to the problem involves identifying the range where the element lies within the array. 
// The first index marks the entry point of the range and thus allows identifying the second index.

class SortedArray {
    private int BinarySearch(int[]nums, int low, int high, int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if(mid == 0 || nums[mid]!=nums[mid-1]){
                    return mid;
                }
                else{
                    high = mid -1;
                }
            } else if(nums[mid]>target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
           
        }
        return -1;
    }
    private int BinarySearchLst(int[]nums, int low, int high, int target){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if(mid == nums.length-1 || nums[mid]!=nums[mid+1]){
                    return mid;
                }
                else{
                    low = mid +1;
                }
            } else if(nums[mid]>target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
           
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        if(nums == null || n == 0) return new int[]{-1,-1};
        if(target<nums[0] || target>nums[n-1]) return new int[]{-1,-1};

        int fst_index = BinarySearch(nums,0,n-1,target);
        if (fst_index == -1){
            return new int[]{-1,-1};
        } 
        int scd_index = BinarySearchLst(nums,fst_index,n-1,target);
        return new int[]{fst_index,scd_index};
    }
   
}