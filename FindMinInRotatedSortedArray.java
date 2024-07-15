class Solution {
    public int findMin(int[] nums) {
        
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start)/2;

            if(nums[start] <= nums[end]) return nums[start];
            if( (mid == 0 || nums[mid] <= nums[mid -1]) &&
                    (mid == end || nums[mid] <= nums[mid+1])) {
                        return nums[mid];
                    } else if(nums[start] <= nums[mid]) {
                        start = mid+1;
                    } else {
                        end = mid -1;
                    }
        }
        return -1;
    }
}
