/**34. Find First and Last Position of Element in Sorted Array
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

/**
 * Finding the first occurance of the target using binary search and searching the first occurance based on its previous element and last by its next ele
 */
public class BinarySearch2Q1 {
    /**
     * find first & last occur using modified binary search
     * @param nums
     * @param target
     * @return array of first and last occur else -1,-1
     */
        public int[] searchRange(int[] nums, int target) {
            if(nums == null || nums.length == 0)                            //if array is empty
                return new int[]{-1,-1};
            int first = binarysearch(nums,target,-1);                   //first occur --O(log n)
            int last = binarysearch(nums,target,1);                     //last occur --O(log n)
            return new int[]{first,last};
        }

    /**
     * modified binary search to find the first and last occur based on its neighbouring elements
     * @param nums
     * @param target
     * @param pos
     * @return array of first and last occur else -1,-1
     */
        public int binarysearch(int[] nums, int target, int pos){
            if(nums == null || nums.length == 0)
                return -1;
            int left=0,right=nums.length-1,mid=0;
            while(left <= right){
                mid = left+(right-left)/2;
                if(nums[mid] == target){
                    if(pos == -1 &&(mid == 0 || nums[mid] > nums[mid-1]))
                        return mid;
                    else if(pos == 1 && (mid == nums.length-1 || nums[mid] < nums[mid+1]))
                        return mid;
                    else if(pos == -1)
                        right = mid-1;
                    else if(pos == 1)
                        left = mid+1;
                }else if(target > nums[mid])
                    left = mid+1;
                else
                    right = mid-1;
            }
            return -1;
        }
}
