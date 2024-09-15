//Time Complexity: O(logn)
//Space Complexity: O(1)
//Leetcode: Yes

//Used one function instead of two and called the same

//Find the rightmost index of a target using binary search
//Find the right most index of the number that is less than target using the same function (binary search)


class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums!= null || nums.length ==0){
            return new int[]{-1,-1};
        }
        int first = getRightMostIndex(nums, target-1);
        int last = getRightMostIndex(nums, target);
        if(first == last){return new int[]{-1,-1};}
        return int[]{first+1, last-1};
    }
    private int getRightMostIndex(int[] nums, int target){
        int low =0, mid, high = nums.length -1;
        if(target <nums[low]){return -1;}
        if(target >= nums[high]){return high;}
        while(low<=high){
            mid = low + (high-low)/2;
            if(nums[mid]<=target&&target<nums[mid+1]){return mid;}
            if(nums[mid]<=target){low = mid+1;}
            else{high = mid-1;}
        }
        return -1;
    }
}