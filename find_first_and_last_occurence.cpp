// Time Complexity : log N + O(N) - we are using binary search + linear to expand the range
// worst case = O(N)
// Space Complexity : O(1). We are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A


// find the index of target using binary search 
// and then expand the range to find start and end 

class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {

        vector<int> result{-1,-1};
        int low = 0; 
        int high = nums.size() - 1;

        while(low <= high)
        {
            int mid = low + ((high-low)/2);

            if(nums[mid] == target)
            {
                // find start and end position
                int start = mid;
                int end = mid;

                // decrement mid until you find start 
                while(start >= 0 && nums[start] == target)
                {
                    start--;
                }
                if(start > -2 && nums[start+1] == target)
                {
                    result.front() = start+1;
                }

                // increment mid until you find end
                while(end < nums.size() && nums[end] == target)
                {
                    end++;
                }

                if(end <= nums.size() && nums[end-1] == target)
                {
                    result.back() = end-1;
                }

                return result;
            }

            if(nums[mid] < target)
            {
                low = mid + 1;
            }
            else
            {
                high = mid -1;
            }
        }

        return result;
        
    }
};

// Time Complexity : O(long N)
// worst case = O(N)
// Space Complexity : O(1). We are not using any extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : N/A


// find start of target using binary search
// and end of target using another binary search 
class Solution {
public:
    int binarySearchStart(vector<int>& nums, int target, int low, int high)
    {
        while(low<=high)
        {
            int mid = low+ (high -low)/2;
            if(nums[mid]==target)
            {
                if(mid == 0 || nums[mid-1] != target)
                {
                    return mid;
                }
                high = mid - 1;
            }
            else if(nums[mid] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return -1;
    }

    int binarySearchEnd(vector<int>& nums, int target, int low, int high)
    {
        while(low<=high)
        {
            int mid = low+ (high -low)/2;
            if(nums[mid]==target)
            {
                if(mid == nums.size() - 1 || nums[mid+1] != target)
                {
                    return mid;
                }
                low = mid + 1;
            }
            else if(nums[mid] > target)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }

        return -1;
    }
    

    vector<int> searchRange(vector<int>& nums, int target) {
        vector<int> result{-1, -1};

        int low = 0;
        int high = nums.size() - 1;

        result.front() = binarySearchStart(nums, target, low, high);
        result.back() = result.front() > -1 ? binarySearchEnd(nums, target, result.front(), high) : -1;

        return result;
    }
};