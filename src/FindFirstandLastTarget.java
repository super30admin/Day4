// Time Complexity :O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
public class FindFirstandLastTarget {
        int first;
        public int[] searchRange(int[] nums, int target) {
            if(nums == null || nums.length ==0) return new int[]{-1, -1};
            int first = binaryLeftSearch(nums, target );
            if(nums[first]!=target)
            {
                return new int[]{-1, -1};
            }
            int last = binaryRightSearch(nums, target);
            return new int[]{first, last};
        }
        public int binaryLeftSearch(int[] nums, int target){
            int low = 0;
            int high = nums.length -1;
            while(low < high){
                int mid = low + (high - low)/2;
                if( nums[mid] == target){
                    if(mid!=0 && nums[mid-1] != target)
                        return mid;
                    high = mid -1;
                }
                else if(nums[mid] > target){
                    high = mid-1;
                }
                else{

                    low = mid+1;
                }
            }
            return low;
        }
        public int binaryRightSearch(int[] nums, int target) {
            int low = first;
            int high = nums.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] == target) {
                    if (mid != nums.length - 1 && nums[mid + 1] != target) {
                        return mid;
                    }
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    high = mid - 1;
                } else {

                    low = mid + 1;
                }
            }
            return low;
        }
}
