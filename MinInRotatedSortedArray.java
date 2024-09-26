/**
 * Time Complexity : O(log(N)) where N is size of the array.
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */

public class MinInRotatedSortedArray {
    public static void main(String args[]){
        int nums[] = {1,2,3,4,4,4,4,4,6};
        
        System.out.println(findMin(nums));
    }

    public static int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int res = nums[0];
        
        int low = 0, high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            //compare low and mid to reduce the search space
            if(nums[low] <= nums[mid]){
                //left side perfectly sorted
                res = Math.min(res, nums[low]);
                // i wont find any smaller element on left side
                // so check right side
                low = mid + 1;
            }else{
                // right side perfectly sorted
                res = Math.min(res, nums[mid]);
                // i wont not find any smaller element on right side
                // so check left side
                high = mid - 1;
            }
        }
        
        return res;
    }
}
