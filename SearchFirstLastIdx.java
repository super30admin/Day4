/**
 * Time Complexity : O(log(N) where N is size of the array. O(N) in worst case where all elements of the array is target element
 * Space Complexity : O(1)
 * Did this code successfully run on Leetcode : Yes
 * Any problem you faced while coding this : No
 */
import java.util.*;
class SearchFirstLastIdx{
    public static void main(String args[]){
        int nums[] = {1,2,3,4,4,4,4,4,6};
        int target = 4;

        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return new int[]{-1, -1};
        }
        int first = -1, last = -1;
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(nums[mid] == target){
                first = mid;
                last = mid;
                first = firstOccurence(nums, target, mid);
                last = lastOccurence(nums, target, mid);
                break;
            }else{
                if(target < nums[mid]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
        }
        return new int[]{first, last};
    }
    
    private static int firstOccurence(int[] nums, int target, int index){
        int idx = index;
        
        while(idx - 1 >= 0 && nums[idx - 1] == target){
            idx--;
        }
        return idx;
    }
    
    private static int lastOccurence(int[] nums, int target, int index){
        int idx = index;
        
        while(idx + 1 < nums.length && nums[idx + 1] == target){
            idx++;
        }
        return idx;
    }
}