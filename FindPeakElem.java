class FindPeakElem {
    public int findPeakElement(int[] nums) {
        // Using binary Search

        int l = 0;
        int h = nums.length - 1;


        while(l <= h){
            int mid = l + (h - l)/2;

            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length - 1 || nums[mid] > nums[mid + 1])){
                return mid;
            }
            else if(nums[mid] < nums[mid + 1]){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }

        return -1;

    }

}