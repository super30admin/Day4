//Time Complexity: O(logn)
//Space Complexity: O(1)
//leetcode: Yes

//If value at mid is less the the value at mid -1 then return mid
//If value at low > value at value at mid update high = mid -1
//if value at high < value at mid update low  = mid +1

class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){return -1;}
        if(nums[0] < nums[nums.length-1]|| nums.length ==1)return nums[0];
        int low =0, high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            
            if(mid-1>0&&nums[mid]<nums[mid-1])return nums[mid];
            if(mid+1 <= nums.length-1&&nums[mid]>nums[mid+1])return nums[mid+1];
            if(nums[low]<nums[mid]){low = mid+1;}else{high = mid-1;}
        }
        return -1;
    }
}