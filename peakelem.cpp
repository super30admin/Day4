// Time Complexity : O( logn )
// Space Complexity : None
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None



class Solution {
public:
    
    
    int findPeakElementrecur( vector<int>& nums, int left, int right ){
        if( left == right ){
            return left;
        }
        int mid = ( left + ( right - left)/2);
        // only case where nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1] code starting at line 18  will fail is when we have two elements and left is leftmost and thus mid becomes left and mid -1 fails
// so addressing that by an early return in below code at line 12;
            if( left == right-1 && left == 0 ){
                if( nums[mid] > nums[mid + 1]){
                    return mid;
                } else {
                    return mid+1;
                }
            } 
        // only case where below fails is handled at line 12.
            if( nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            } else if ( nums[mid-1] > nums[mid] ){
                return findPeakElementrecur( nums, left, mid-1);
            } else {
                return findPeakElementrecur( nums, mid+1, right);
            }

    }
    int findPeakElement(vector<int>& nums) {
        int left = 0;
        int right = nums.size() - 1;
        return findPeakElementrecur( nums, left, right );
    }
};
