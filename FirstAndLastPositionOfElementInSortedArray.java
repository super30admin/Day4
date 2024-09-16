import java.util.Arrays;

/**
 * Time complexity is O(log n)
 * Space complexity is O(1)
 * Did this code successfully run on Leet code : Yes
 * Any problem you faced while coding this : No
 */
public class FirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 7;
        FirstAndLastPositionOfElementInSortedArray obj = new FirstAndLastPositionOfElementInSortedArray();
        int[] result = obj.searchRange(nums, target);
        System.out.println(Arrays.toString(result));
    }

    private int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[] {-1, -1};
        }

        if(target < nums[0] || target > nums[nums.length-1]){
            return new int[] {-1,-1};
        }

        int first = binarySearchFirst(nums, target);
        if(first == -1){
            return new int[] {-1,-1};
        }
        int second = binarySearchSecond(nums, target);
        return  new int[] {first, second};
    }

    private int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1] < nums[mid]){
                    return mid;
                }
                else{
                    high = mid-1;
                }
            }
            else if( target < nums[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }

    private int binarySearchSecond(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1] > nums[mid]){
                    return mid;
                }
                else{
                    low = mid + 1;
                }
            }
            else if(target > nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return -1;
    }
}
