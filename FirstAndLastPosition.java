// Time Complexity : O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : no
/*Approach
*basically doing binary search two times one for the first and one for the second as in last position
*for first binary search we will keep on looking for the target and at the same time we will keep comparing it with its previous 
element it should be less than target
* similarily in the second binary search we wil compare it with element next to it and it should be greater
 */

public class FirstAndLastPosition {
    public int first(int[] nums,int low, int high, int target){
        while(low <= high){
            int mid = low + (high- low)/2;
            if((mid == 0 && nums[mid] == target) || (nums[mid] == target && nums[mid -1] < nums[mid]))return mid;
            if(nums[mid] < target){
                low = mid+1;
            }
            else{
                high = mid -1;
            }

        }
        return -1;
    }
    public int second(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high- low)/2;
            if((mid == nums.length-1  && nums[mid] == target)|| (nums[mid] == target && nums[mid+1] > nums[mid]))return mid;
            if(nums[mid] <= target){
                low = mid+1;
            }
            else{
                high = mid -1;
            }

        }
        return -1;

    }
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;
        int f = first(nums, low, high, target);
        int s = second(nums, low, high, target);
        return new int[]{f,s};
    }
    public static void main(String args[]){
        FirstAndLastPosition obj = new FirstAndLastPosition();
        int target = 5;
        int[] result = obj.searchRange(new int[]{1,2,2,3,3,4,4,4,4,5,5,5}, target);
        System.out.println("The start and the end position for the "+target+" is "+result[0] + " to "+result[1]);
    }

}