// Time complexity: O(n)
// Space complexity: O(1)
// 1. Peak element being higher than its neighbouring elements, carrying out binary search with that as a condition
// 2. Find subsequent mid points by iterating in the direction where the neightbouring element is bigger that the previous mid.
// 3. Carry out the same process till we find the peak element

class Solution{
    public int search(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            if((mid == start || nums[mid] > nums[mid-1]) && (mid == end || nums[mid] > nums[mid+1])){
                return mid;
            }
            else if(nums[mid] < nums[mid+1]){
                start = mid+1;
            }
            else{
                end = mid-1;
            }
        }
        return -1;
    }
}