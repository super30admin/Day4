// Time Complexity :O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Boundary condition identification was tricky


// Your code here along with comments explaining your approach
//1. Write edge cases
//2. Returning condition is that if element at an index is less than the element before then it is minimum element
//3. Discard left or right side if that side is sorted
class Solution {

public:
    int findMin(vector<int>& nums) {
        
        //edge cases
        if(nums.size() ==0)
            return INT_MIN;
        if(nums.at(0) <= nums.at(nums.size()-1))
                return nums.at(0);
           
        
        int low =0, high = nums.size()-1;

        int mid = INT_MIN;
        
        while(low<=high){
            mid = low + ((high - low)/2);
            
            //returning condition
           if(nums.at(mid) > nums.at(mid+1)  ){
                    return nums.at(mid+1);
                }
            
          //discarding a set of data conditions            
            if(nums.at(low) <= nums.at(mid+1)){
                low=mid+1;
            }
            else {
                high =mid-1;
            }
        }

        return nums.at(low);
    }
};
