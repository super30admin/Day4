// Time Complexity :O(n) where n in the number elements in the vector
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Aproach 1 - Binary search and brute force
class Solution {
    vector<int> ans = {-1,-1};
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if(!nums.size()) return ans;
        int position = helper(nums,target,0,nums.size()-1);
        if(position < 0) return {-1,-1};
        int left = position;
        int right = position;
        while(left > 0){                            //brute force to find the left 
            if(nums[left-1] != target) break;
            left--;
        }
        while(right < nums.size()-1){               //brute force to find the right 
            if(nums[right+1] != target) break;
            right++;
        }
        return {left,right};
    }
    int helper(vector<int> nums,int target,int low,int high){ //binary search
        if(low > high)
            return -1;
        int mid = (low +high)/2;
        if(nums[mid] == target){
            return mid;
        }
        else if(nums[mid] < target){
            return helper(nums,target,mid+1,high);
        }
        else
            return helper(nums,target,low,mid-1);
        
    }
};


// Time Complexity :O(log n) where n in the number elements in the vector
// Space Complexity : O(1)  
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Aproach 2 - Binary search Optimized

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {  // driver function 
        bool isLeft = true;
        int low = 0;
        int high = nums.size()-1;
        if(nums.size() == 0) return {-1,-1};
        int left = binary_search(nums,low,high,target,isLeft);
        int right;
        if( left != -1)
            right = binary_search(nums,left,high,target,!isLeft);
        else 
            right = -1;
        return {left,right};
    }
    int binary_search(vector<int>& nums,int low,int high,int target,bool isLeft){   //binary search
        while(low<=high){
            int mid = low + (high-low)/2;
            cout<<mid<<endl;
            if(nums[mid] == target){                                    //left binary search
                if(isLeft){
                 if((mid == 0 )|| (nums[mid-1] < nums[mid]))
                     return mid;
                else high = mid-1;
                }
            else{
                if((mid == nums.size()-1)  || (nums[mid+1] > nums[mid]))  // right binary search
                    return mid;
                else low = mid+1;
                }
            }
            else if(nums[mid] < target)
                low = mid+1;
            else
                high = mid-1;
        }
        return -1;
    }
};