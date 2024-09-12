class Problem8 {
    public int findMin(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        if(nums.length==1) return nums[0];
        
        int low=0;
        int high=nums.length-1;
        
        if(nums[high]>nums[low]) return nums[low];
        while(low<high-1){
            int mid= (high-low)/2+low;
            if(nums[mid]>nums[low]){
                low=mid;
            }else {
                high=mid;
            }
        }
        return nums[high];
    }
}
