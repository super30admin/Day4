/*
Time Complexity : O(log(n))
Space Complexity : O(1)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : Solved once the problem was discussed in the class

Your code here along with comments explaining your approach,
 */

public class FirstAndLastPositionOfElement {
    public static int[] searchRange(int[] nums, int target) {
        int result[] = new int[2];
        result[0] = getFirstPos(nums, target);
        result[1] = getSecondPos(nums, target, result[0]);
        return result;

    }

    public static int getFirstPos(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;

        while(start<= end){
            int mid = start + (end-start)/2;

            if(nums[mid] == target){
                if(mid == 0 || nums[mid-1]!= target){
                    return mid;
                }else{
                    end = mid-1;
                }
            }else if(target < nums[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return -1;
    }

    public static int getSecondPos(int[] nums, int target, int startPos){
        if(startPos == -1) {return -1;}
        int start = 0;
        int end = nums.length-1;

        while(start<= end){
            int mid = start + (end-start)/2;

            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1]!= target){
                    return mid;
                }else{
                    start = mid+1;
                }
            }else if(nums[mid]< target){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] arr = {5,7,7,8,8,10};
        int [] result = searchRange(arr, 8);
            System.out.print("[" + result[0] + ", " + result[1] +"]");

    }
}
