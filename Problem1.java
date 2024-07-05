import java.util.Arrays;

// s30 Problem #8 - medium
// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Time Complexity : O(n) 
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
/**
 * Problem 1 Approach 1
 * 1. binary search to find the target element  - O(log n)
 * 2. two pointer to scan for the first and last index of the target element - O(n)
 */
public class Problem1{
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int pos1 = -1;
        int pos2 = -1;
        int found = -1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                found = mid;
                break;
            } else if (nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        
        if(found > -1 && nums.length != 1){
            pos1 = found;
            pos2 = found;
            
            while(pos1-1>=0){
                if(nums[pos1-1] == target){
                    pos1--;
                } else if (nums[pos1-1] < target){
                    break;
                }
            }
            while(pos2+1<nums.length){
                if(nums[pos2+1] == target){
                    pos2++;
                } else if(nums[pos2+1] > target){
                    break;
                }
            }
            
        } else if (found == 0 && nums.length == 1){
            pos1 = 0;
            pos2 = 0;
        }
        
        return new int[]{pos1, pos2};   
    }
    public static void main(String[] args) {
        int[] nums = {5,7,8,9,9,10};
        int target = 9;
        int[] result = new Problem1().searchRange(nums, target);
        Arrays.stream(result).forEach(e->System.out.print(e + " "));
    }
}

/**
 * Problem1 Approach2
 * using only Binary Search
 * Time complexity: O(log n)
 * Space complexity: O(1);
 * 
 * 1. locate the element using binarySearchFirst mid pointer
 * 2. if element is located
 *        if mid-1 is smaller than mid then return mid (first index)
 *        else keep moving to the left
 * 3. use the first index as low for the binarySearchSecond and locate the element
 * 4. if the element is located 
 *        if mid+1 is greater than mid then return mid (second index)
 *        else keep moving to the right
 *        
 */
class P1Approach2{

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        
        if (nums == null || n == 0) return new int[]{-1, -1};
        if(nums[0] > target || nums[n - 1] < target) return new int[]{-1, -1};
        
        int first = binarySearchFirst(nums, target);
        if(first == -1) return new int[]{-1, -1};
        
        int second = binarySearchSecond(first, nums, target);
        return new int[]{first, second};
        
    }
    
    public int binarySearchFirst(int[] nums, int target){
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high-low)/2;
            
            if(nums[mid] == target){
                if(mid==0 || nums[mid-1] < nums[mid]){
                    return mid;
                } else {
                    high = mid - 1;
                }
                
            } else if (nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    
    public int binarySearchSecond(int first, int[] nums, int target){
        int low = first;
        int high = nums.length - 1;
        
        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid+1] > nums[mid]){
                    return mid;
                } else {
                    low = mid + 1;
                }
                    
            } else if (nums[mid] < target){
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return 88888;
    }

}