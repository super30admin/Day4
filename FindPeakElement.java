class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int start = 0, end   = nums.length-1;

        while(end-start >= 2){
            
            int middle = start + (end - start) / 2;
            
            if(nums[middle]>nums[middle-1]&& nums[middle]>nums[middle+1]){
                return middle;
            }
            else if(nums[middle]>nums[middle-1] && nums[middle+1]>nums[middle]){
                start = middle+1;
            }
            else{
                end = middle-1;
            }
        }

        return nums[start]<nums[end]? end : start;
    }
}