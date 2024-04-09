/**
 * Time Complexity: )(log n), Space Complexity: O(1)
Search for  the target using binary search
Once found check the adjacennt if itt does nott match the target do binary seach on them for both first and last occurances
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        if(target<nums[0] || target > nums[nums.length-1])return new int[]{-1,-1};
       
        int low = 0;int high = nums.length-1;

        int first = firstBS(nums, target, low, high);
        if(first == -1) return new int[]{-1,-1};

        int last = secondBS(nums, target, first, nums.length-1);
        if(last == -1) return new int[]{-1,-1};

          return new int[]{first,last};
    }

        private int firstBS(int[] nums, int target, int low, int high){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(target == nums[mid]){
                if(mid == 0|| target!=nums[mid-1]){
                    return mid;
                } else {
                    high = mid-1;
                }
            } else if (target < nums[mid]){
                high = mid -1;
            } else {
                low = mid+1;
            }
        }
        return -1;
        }

        
        private int secondBS(int[] nums, int target, int low, int high){
            while(low<=high){
            int mid = low+(high-low)/2;
            if(target == nums[mid]){
                if(mid == high || target!=nums[mid+1]){
                    return mid;
    
                } else {
                    low = mid+1;
                }
            } else if ( target < nums[mid]){
                high = mid -1;
            } else {
                low = mid+1;
            }
        }
        return -1;
        }
}