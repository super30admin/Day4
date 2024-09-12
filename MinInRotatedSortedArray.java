// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
//At first I will check whether my l<r, then I will check if my mid<right, 
//then I will replace r=m, else left=m+1, and I will return my left


class MinInRotatedSortedArray {
    public int findMin(int[] nums) {
        int mid;
        int left = 0, right = nums.length-1;
        
        while(left<right){
            mid = left+(right-left)/2;
            if(nums[mid]<nums[right]){
                right=mid;
            }
            else{
                left = mid+1;
            }
        }
        return nums[left];
    }
}