class Solution {// O(log n)
    public int findMin(int[] nums) {
        int mid;
        int left =0;
        int right = nums.length - 1;
        while (left < right){
            mid = left +(right - left)/2;
            if (nums[mid]< nums[right]){
                right = mid ;
            }else{
                left = mid + 1 ;
            }
        }
        return nums[left] ; 
        
    }
}