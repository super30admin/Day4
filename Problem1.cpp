// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> ans;
        if(nums.size() == 0){
            ans.push_back(-1);
            ans.push_back(-1);
            return ans;
        }
        int left = firstOccurence(nums, target);
        //if left == -1 i.e. element is not found in the array
        if(left == -1){
            ans.push_back(-1);
            ans.push_back(-1);
            return ans;
        }
        
        int right = lastOccurence(nums, target);
        ans.push_back(left);
        ans.push_back(right);
        return ans;
    }
    
    int firstOccurence(vector<int>& nums, int target){
        int low = 0;
        int high = nums.size()-1;
        while(low <=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                //check if it is first occurence
                if(mid == 0 || nums[mid-1] < nums[mid]){
                    return mid;
                }else{
                   high = mid -1;   
                } 
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1; 
            }
        }
        return -1;
    }
    
        int lastOccurence(vector<int>& nums, int target){
        int low = 0;
        int high = nums.size()-1;
        while(low <=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                //check if it is last occurence
                if(mid == nums.size()-1 || nums[mid+1] > nums[mid]){
                    return mid;
                }else{
                   low = mid + 1;
                } 
            }else if(nums[mid] < target){
                low = mid + 1;
            }else{
                high = mid - 1; 
            }
        }
        return -1;
    }
    
};