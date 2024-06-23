import java.util.Arrays;

//Somehow I am getting time limit exceeded for this problem on Leetcode and I am unable to debug.
// Can you please review whats wrong with it.
public class SearchRange {
    public static int[] searchRange(int[] nums, int target) {
        int length = nums.length;
        //optimizations
        if(length == 0) {
            return new int[]{-1,-1};
        }
        int firstIndex, lastIndex;
        if(nums[0] == target) {
            firstIndex = 0;
        }
        else {
            firstIndex = firstSearch(nums, target, 0, length-1);
        }
        if(firstIndex == -1) {
            return new int[]{-1, -1};
        }
        if(nums[length-1] == target) {
            lastIndex = length - 1;
        } else {
            lastIndex = lastSearch(nums, target, firstIndex, length-1);
        }
        //until here
        return new int[]{firstIndex, lastIndex};
    }

    private static int firstSearch(int[] nums, int target,
                                   int low, int high) {
        while(low<=high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid] != nums[mid - 1]) {
                    return mid;
                }
                else{
                    high = mid - 1;
                }
            }
            else if(nums[mid] > target) {
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int lastSearch(int[] nums, int target, int low, int high) {
        int mid = low + (high - low)/2;
        while(low<=high) {
            if(nums[mid] == target) {
                if(mid == nums.length - 1 || nums[mid] != nums[mid + 1]) {
                    return mid;
                }
                else {
                    low = mid + 1;
                }
            }
            else if(nums[mid] > target) {
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int[] res = searchRange(nums, 2);
        System.out.println("First and last indices are: " + Arrays.toString(res));
    }
}
