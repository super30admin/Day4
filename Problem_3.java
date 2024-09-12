//Binary Search
//Space complexity:O(1)
//Time Complexity:O(logn)

class Solution {
    public int findMin(int[] nums) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[left]<nums[right]) return nums[left];
            if((nums[mid]==nums[0] || nums[mid]<nums[mid-1]) && (nums[mid]==nums[nums.length-1] ||  nums[mid]<nums[mid+1])) {
                return nums[mid];
            }
            else if(nums[left]<=nums[mid]){
                left=mid+1;
            }else right=mid-1;
        }
        
        return -1;
    }
}