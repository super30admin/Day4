class SolutionRMin {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;

        int min=5001;

        while(low<=high){
            int mid = low + (high-low)/2;

            if(min>nums[mid]) min = nums[mid];
            System.out.println(min);

            if(nums[low]<=nums[mid] && nums[mid]<=nums[high]){
                if(min>nums[low])min = nums[low];
                break;
            }else if(nums[low]<=nums[mid]){
                low = mid+1;
            }else{
                high = mid-1;
            }
        }
        return min;
    }
}