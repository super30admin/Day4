// Time Complexity :O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No.

//approach is to first find the first occurrence of the target for that from mid we'll go to the left and then for last occurrence we go to the right
public class Problem_1 {
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1,-1};
        }
        int firstIndex =  binarySearchFirst(nums,target);
        if (firstIndex == -1) return new int[]{-1,-1};
        int findSecondIndex = binarySearchLast(nums,target);
        return new int[]{firstIndex,findSecondIndex};
    }

    private int binarySearchFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid  = low+(high-low)/2;

            if(nums[mid]==target){
                //if we reached first index of an array
                if(mid == 0 || (nums[mid-1] != target)){
                    return mid;
                }
                high = mid-1;
            }
            else if(nums[mid]>target){
                high = mid-1;
            }
            else{
                low = mid +1;
            }
        }
        return -1;
    }

    private int binarySearchLast(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;

        while(low<=high){
            int mid  = low+(high-low)/2;

            if(nums[mid]==target){
                //if we reached last index of an array
                if(mid ==  nums.length-1 || (nums[mid+1] != target)){
                    return mid;
                }
                low = mid+1;
            }
            else if(nums[mid]>target){
                high = mid-1;
            }
            else{
                low = mid +1;
            }
        }
        return -1;
    }
}
