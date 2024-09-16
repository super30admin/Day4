// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : yes


class Solution {
private:

    //normal binary search, except we move to the left to find the first 
    //we are either on the smallest element or its on the left side of that element
    int findFirst(vector<int>& nums, int target){
        int low = 0;
        int high = nums.size()-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid==0 || nums[mid-1] != target)
                    return mid;
                else
                    //moving to the left as the first has to be on the left
                    high = mid-1;
            }
            else if (nums[mid] < target)
                low = mid+1;
            else 
                high = mid -1;
        }
        return -1;
    }

    //normal binary search except the last element has to be on the right 
    int findLast(vector<int>& nums, int target){
        int low = 0;
        int high = nums.size()-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid==nums.size()-1 || nums[mid+1] != target)
                    return mid;
                else
                    //moving to the right as the last element has to be on the right 
                    low = mid+1;
            }
            else if (target > nums[mid])
                low = mid+1;
            else 
                high = mid-1;
        }
        return -1;
    }
public:
    vector<int> searchRange(vector<int>& nums, int target) {
        if(nums.empty() or nums.size() == 0)
            return (vector<int>(2, -1));

        int first = findFirst(nums, target);
        if (first == -1){
            return (vector<int>(2, -1));
        }
        int second = findLast(nums, target);
        return (vector<int>({first, second}));
    }
};