// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No, followed the approach as discussed in class


// Your code here along with comments explaining your approach in three sentences only
// Did the first binary search to find first occurrence of the element
// and then a second binary search to calculate the last occurrence of the element

public class FindFirstAndLastPositionInArray {

        public int[] searchRange(int[] nums, int target) {
            if(nums == null || nums.length ==0){
                return new int[] {-1,-1};
            }
            if(nums[0] > target || nums[nums.length-1] < target){
                return new int[] {-1, -1};
            }

            int first = binarySearchFirst(nums, target);
            if(first == -1){
                return new int[]{-1,-1};
            }

            int last = binarySearchLast(nums, target);
            return new int[] {first, last};
        }

        public int binarySearchFirst(int[] nums, int target){
            int low = 0;
            int high =nums.length -1;
            while(low<=high){
                int mid = low + (high-low)/2;
                if(nums[mid] == target){
                    if( (mid == low) || (nums[mid-1] != nums[mid])){
                        return mid;
                    }
                    high = mid-1;
                }else if(nums[mid] < target){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
            return -1;
        }

        public int binarySearchLast(int[] nums, int target){
            int low = 0;
            int high =nums.length -1;

            while(low <= high){
                int mid = low + (high-low)/2;
                if(nums[mid] == target){
                    if((mid == high) || (nums[mid+1] != nums[mid]) ){
                        return mid;
                    }
                    low = mid+1;
                }else if(nums[mid] < target){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
            return -1;
        }


}
