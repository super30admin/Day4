
// Time Complexity : 2 * O(logn)
// Space Complexity : none except array given
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : None


// Your code here along with comments explaining your approach

// find first the highest index of target 
// find then the lowest index of target 
//return vector of that

class Solution {
public:
    
    int searchRangeRecur( vector<int>& nums, int left, int right, int target, bool low){
      if( left > right ){
         return -1;
      }  
      int mid = ( left + (right - left)/2);  
      if( !low && nums[mid] == target ){  // highest case
             if( mid < right ) {
                 if( nums[mid] == nums[mid + 1]){
                    return searchRangeRecur( nums, mid+1, right, target, low );
                 } else {
                     return mid;
                 }
             } else {
                 return mid;
             }
      } else if( low && nums[mid] == target ) { // lowest case
             if( mid > left ) {
                 if( nums[mid] == nums[mid - 1]){
                    return searchRangeRecur( nums, left , mid-1, target, low );
                 } else {
                     return mid;
                 }
             } else {
                 return mid;
             }
      } else if ( nums[mid] > target ) {
             return searchRangeRecur( nums, left, mid-1, target, low);
      } else {
             return searchRangeRecur( nums, mid+1, right, target, low);
      }
    }
        
    vector<int> searchRange(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size()-1 ;
        bool low = false;
        int highest = searchRangeRecur( nums, left, right, target, low );
        low = true;
        int lowest = searchRangeRecur( nums, left, right, target, low );
        vector<int>arr { lowest, highest };
        return arr;
    }
};
