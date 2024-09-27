/*
The time complexity is O(logN) and the space complexity is O(1).

Here to check if the mid is minimum, we need to check if nums[mid-1]>nums[mid]. Else, we continue the search.

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public int findMin(int[] nums) {
        int size = nums.length;
        if(size==1){return nums[0];}
        int start = 0; int end = size-1;
        if(nums[start]<nums[end]){return nums[start];}

        while(start<=end){
            int mid = start + (end-start)/2;
            if(mid-1>=0 && nums[mid]<nums[mid-1]){
                return nums[mid];
            }
            else if(nums[mid]>nums[end]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }

        }
        return -1;
    }
}