class FindPeakElement{
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            int mid = low + (high-low)/2;
            if((mid == nums.length-1 || nums[mid] > nums[mid+1]) && (mid ==0 || nums[mid] > nums[mid-1])){
                return mid;
            }
            else if(mid !=0 && nums[mid-1] > nums[mid]){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }

        return 1234567;
    }

    public static void main(String[] args) {
        FindPeakElement fp = new FindPeakElement();
        int[] nums = {1,2,3,1};
        System.out.println(fp.findPeakElement(nums) );
    }
}