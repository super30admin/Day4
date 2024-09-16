// Time Complexity : O(logn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Identifying boundary condition to avoid out of bouns access


// Your code here along with comments explaining your approach
//1. Identify boundary conditions
//2. Identify returning condition: Element should be greater then its index
//3. Discard left or right side.


class Solution {

public:
    int findPeakElement(vector<int>& nums) {
        //edge cases
        if(nums.size()==0){
            return INT_MIN;
        }
        if(nums.size()==1){
            return 0;
        }
         if(nums.at(0)>nums.at(1)){
            return 0;
        }
        if(nums.at(nums.size()-1)>nums.at(nums.size()-2)){
            return (nums.size()-1);
        }
        
        int low = 0;
        int high = nums.size()-1;
        int mid;
        while(low<high){
            mid = low + ((high - low)/2);
            
            //returning condition
            if(nums.at(mid)>nums.at(mid-1) && nums.at(mid)>nums.at(mid+1)){
                return mid;
            }
            if(nums.at(mid) > nums.at(mid-1)){
                low = mid;
            }
            else{
               high = mid; 
            }
        }
        
        return INT_MIN;
    }
};
