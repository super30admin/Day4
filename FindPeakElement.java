class Solution {

    //Time Complexity-0(log n)
    //Space Complexity- 0(1)
    //Did it successfully run on leetcode : Yes
    //Did you face any problem while: No

    //In Short explain your approach: Well, this initially first seemed a fairly easy problem. But in the middle of it,
    //things changed as the array was not sorted and to abide by time coplexity, I had to modify the algorithm a lot.
    //The approach taken was to compare the mid with the elements left and right index. If the larger element lied on the
    //right hand size, then the objective was to traverse the right side of the array and if the larger element lied in the
    //left side, then to traverse in the left side of the array . Had to take care of all the edge cases as well as array
    //out og bounds exception as well.

    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if((mid == nums.length-1 || (nums[mid] > nums[mid+1]) && (mid == 0 ||nums[mid] > nums[mid-1]))){
                return mid;
            }
            else if(mid != 0 && nums[mid-1] > nums[mid]){
                high = mid -1;
            }
            else{
                low = mid+1;
            }
        }
        return 54321;
    }
}