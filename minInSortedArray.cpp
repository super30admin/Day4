// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// [***] KEY INSIGHT: FIND PIVOT I.E. THE ELEMENT WHICH IS LOWER THAN BOTH NEIGHBORS; PIVOT ALWAYS LIES IN UNSORTED PART

// Your code here along with comments explaining your approach
// 1. Find pivot to be that element lesser than both neighbors
// 2. Edge case: if mid comes out to be first or last element and satisfies to be lesser than neighbor then its pivot
// 3. Return element at pivot

class Solution {
public:
    int findMin(vector<int>& nums) {
        if(nums.size()==0)
            return -1;
        
        int low=0, high=nums.size()-1, pivot=0;
        while(low<=high){
            int mid = low+(high-low)/2;
            // element should be lesser than both neighbors; else if its first/last element then it should be less than its only neighbor 
            if((mid == 0 || nums[mid]<nums[mid-1]) && (mid == nums.size()-1 || nums[mid]<nums[mid+1])){
                // pivot found
                pivot = mid;
                break;
            }
            else{ // search in unsorted part
                if(nums[mid]>nums[high]) // left is unsorted
                    low = mid+1;
                else
                    high = mid-1;
            }
        }
        return nums[pivot];
    }
};

// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// 1. Binary Search - if mid is greater than next then next is the pivot and hence the minimum
// 2. If element previous to mid is greater than mid then mid is the min
// 3. Else trim array such that if mid is greater than first element then min is on the right, else it is on the right
// 4. Take care of edge cases like 1 element array or non-rotated array

class Solution {
public:
    int findMin(vector<int>& nums) {
        int l=0, r=nums.size()-1;
        if(!r)
            return nums[0];
        if(nums[l]<nums[r])
            return nums[l];
        while(l<=r){
            int mid=l+(r-l)/2;
            if(nums[mid+1]<nums[mid])
                return nums[mid+1];
            if(nums[mid]<nums[mid-1])
                return nums[mid];
            if(nums[mid]<nums[0])
                r=mid-1;
            else
                l=mid+1;
        }
        return -1;
    }
};

