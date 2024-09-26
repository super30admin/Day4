// Time Complexity : O(log N)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//The approach over here is to use the binary search algo to find the left or starting position and
//right or end position separately using 2 binary search.


public class FirstAndLastPositionOfElementSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[]{-1, -1};

        //search for the left position
        int left = searchLeftPosition(nums, target);
        int right;
        if(left==-1) right=-1;
        else {
            //search for the right position
            right = searchRightPosition(nums, target);
        }
        return new int[]{left,right};
    }

    private int searchRightPosition(int[] nums, int target) {
        int low=0, high= nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2; //to avoid integer overflow
            if(nums[mid]==target &&
                    (mid==nums.length-1 || nums[mid]<nums[mid+1])){
                return mid;
            }
            else if(nums[mid]==target && nums[mid]==target){
                low=mid+1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return -1;
    }

    private int searchLeftPosition(int[] nums, int target) {
        int low=0, high= nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            //check if mid position is equal to target and nid is left most position for the target
            if(nums[mid]==target &&
                    (mid ==0 || nums[mid-1]<nums[mid])){
                return mid;
            }
            //check if value at mid is same as target and immediate left position value is also same as target
            else if(nums[mid]==target && nums[mid-1]==target){
                high=mid-1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        FirstAndLastPositionOfElementSortedArray a = new FirstAndLastPositionOfElementSortedArray();
        System.out.println(a.searchRange(new int[]{5,7,7,8,8,10}, 6));

    }
}