// Time Complexity :O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : Understanding boundary conditions was a bit tricky.


// Your code here along with comments explaining your approach
//1. Write all the edge cases
//2. Find whether the element exists in the array or not
//3. Search the minimum index of elements existance
//4. Search the maximum index of elements existance

class Solution {
    int binsearch(vector<int>& nums, int target, int low, int high){
        int index=-1;
        while(low<=high){
            int mid = low + ((high-low)/2);
            if(nums.at(mid)==target){
                return mid;
            }
            if(target < nums.at(mid)){
               index= binsearch(nums, target, low, mid-1);
                break;
            }
            else if(target > nums.at(mid)){
              index=  binsearch(nums, target, mid+1, high);
                break;
            }
        }
        return index;
    }
    
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        
        int pivot_index=-1;
        int first_index=-1;
        int last_index=-1;
        vector<int> result(2, -1);
        
        //edge cases
        if(nums.size()==0){
            return result;
        }
        if(nums.size()==1){
            if(nums.at(0)==target){
                result.at(0) = result.at(1) =0;
            }
            return result;
        }
        
        //searching the number
       first_index=last_index=pivot_index = binsearch(nums, target,0, nums.size()-1);
        
        //element not found
        if(pivot_index==-1){
         return result;   
        }
        
        //search lower boundary
       do{
          result.at(0) = first_index;
          first_index = binsearch(nums, target,0, first_index-1); 
       }while(first_index != -1 );
       
        //search upper boundary
       do{
          result.at(1) = last_index;
          last_index = binsearch(nums, target, last_index+1, nums.size()-1); 
       }while(last_index != -1);
        
        return result;
        
    }
};
