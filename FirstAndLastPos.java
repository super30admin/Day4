// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        //find the left and right positions of the target
        int left = findleft(nums, s ,e, target);
        int right = findright(nums, s ,e, target);
        return new int[]{left, right};
    }
    //
    private int findleft(int[] nums, int s, int e, int target){
        while(s <= e){
            int mid = s + (e - s)/2;
            if(nums[mid] == target){
                //check if left to current is not target then it is the left most position
                if(mid == 0 || nums[mid - 1] != target){
                    return mid;
                }    
                else{
                    e = mid - 1;
                }
            }
            else if(nums[mid] < target){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        return -1;
    }
    private int findright(int[] nums, int s, int e, int target){
        while(s <= e){
            int mid = s + (e - s)/2;
            if(nums[mid] == target){
                //check if right to current is not target then it is the right most position
                if(mid == (nums.length - 1) || nums[mid+1] != target)
                    return mid;
                else
                    s = mid + 1;
            }
            else if(nums[mid] < target){
                s = mid + 1;
            }
            else{
                e = mid - 1;
            }
        }
        return -1;
    }
}