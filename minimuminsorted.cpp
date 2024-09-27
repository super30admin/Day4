

// Time Complexity : O( logn )
// Space Complexity : None
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

class Solution {
public:
    
    int findminrecur( vector<int> nums, int left, int right ){
        if( left >= right ){
            return -1;
        }
        if( right == left + 1 ){
            return ( min( nums[right], nums[left]));
        }
        int mid = ( left + right )/2;
        if( nums[mid] < nums[mid-1] && nums[mid] < nums[mid+1] ){
            return nums[mid];
        } else if( nums[mid] > nums[left]){
            return findminrecur( nums, mid, right);
        } else {
            return findminrecur( nums, left, mid );
        }
    }
    
    int findMin(vector<int>& nums) {
        int left = 0;
        int right = nums.size()-1;
        // NO rotation case
        if( nums.size() == 1){
            return nums[0];
        }
        if( nums[right] > nums[left] ){
            return nums[left];
        }
        return findminrecur( nums, left, right );
    }
};
