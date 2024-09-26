class Solution {
    public int findPeakElement(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        if(nums == null){
            return -1;
        }

        while(start<end)
        {
            int mid = start + (end-start)/2;
            if(nums[mid] > nums[mid + 1]){
                return end = mid;
            }
            else{
                start = mid +1;
            }

        } return start;
    }
}