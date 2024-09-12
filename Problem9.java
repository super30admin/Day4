class Solution {
    public int findPeakElement(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        if(nums.length==1) return 0;
        int low= 0;
        int high= nums.length-1;
        while(low<=high){
            int mid = (high-low)/2+low;
            if(mid>0 && nums[mid] > nums[mid-1] 
               && mid<nums.length-1 && nums[mid] > nums[mid+1]){
                return mid;
            }
            // to avoid infite loop when high-low==1 mid ll be low
            if(high-low==1){
                if(nums[mid] > nums[mid+1])
                    return mid;
                else
                    return mid+1;
            }
            
            if(mid>0 && nums[mid] > nums[mid-1] &&
              !(mid<nums.length-1 && nums[mid] > nums[mid+1])){
                low=mid;
            }else{
                high=mid;
            }
        }
        return high;
    }
}
