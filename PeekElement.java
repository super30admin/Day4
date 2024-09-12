// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
//At first I will check whether my l<r, then I will check if my mid<mid+1, 
//then I will update left=mid+1 else I will update right=mid, an I will return my left


class PeekElement {
    public int findPeakElement(int[] nums) {
        int mid;
        int left = 0, right = nums.length-1;
        
        while(left<right){
            mid = left+(right-left)/2;
            if(nums[mid]<nums[mid+1]){
                left = mid+1;
            }
            else{
                right=mid;
            }
        }
        return left;
    }
}