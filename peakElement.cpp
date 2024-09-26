// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// [***] KEY INSIGHT: IF MIDDLE IS NOT PEAK, GO IN ANY DIRECTION WHERE THERE IS A GREATER ELEMENT

// Your code here along with comments explaining your approach
// 1. Binary search: find if mid is peak and return if true
// 2. Else, if right neighbor is greater, search peak in right part else search in left part
// 3. If there is even one greater element, there'll be a peak, maybe even the boundary points in strict ascending case
// 4. We can return any peak, hence we can choose any direction with a peak

class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        if(nums.size() < 2)
            return 0;
        int low=0, high=nums.size()-1;
        int n = nums.size()-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if((mid==0 || nums[mid]>nums[mid-1]) && (mid==n || nums[mid]>nums[mid+1]))
                return mid;
            else if(mid-1>=0 && nums[mid-1]>nums[mid])
                high = mid-1;
            else
                low = mid+1;
        }
        return 0;
    }
};

// Time Complexity : O(n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Getting it in O(log n)


// Your code here along with comments explaining your approach
// 1. Linear traversal- If number is greater than the right neighbor then it is a peak
// 2. Place INT_MIN as last element to take care of single element array 
// 3. Since we can return any peak, just return first element when the above condition is true else return second last element since last is INT_MIN


class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        nums.emplace_back(INT_MIN);
        int i=0;
        for(; i<nums.size()-1; i++){
            if(nums[i]>nums[i+1])
                return i;
        }
        return i-1;
    }
};
