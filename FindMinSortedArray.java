class FindMinSortedArry{
    public int findMin(int[] nums) {
        int count = 0;
        if(nums.length==1) {
            return nums[0];
        }
        int min = 0;
        int diff = 0;
        for(int i=1; i<nums.length; i++) {
            diff = nums[i] - nums[i-1];
            if(diff<0) {
                count++;
                min = nums[i];
            }
        }

        if(count==0) {
            return nums[0];
        }
        return min;
    }

}