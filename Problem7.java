class Problem7 {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0) return new int[]{-1,-1};
        return new int[]{findFirstIndex(nums,target),findLastIndex(nums,target)};
    }
    
    private int findFirstIndex(int[] nums, int target){
        int low=0;
        int high= nums.length-1;
        while(high>0 && low<nums.length-1 && low<high-1){
            int mid = (high-low)/2 +low;
            if(nums[mid]>target){
                high=mid-1;
            }else if (nums[mid]<target){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        if(nums[low]==target){
            return low;
        }else if(nums[high]==target){
            return high;
        }else{
            return -1;
        }
    }
    
    private int findLastIndex(int[] nums, int target){
    int low=0;
        int high= nums.length-1;
        while(high>0 && low<nums.length-1 && low<high-1){
            int mid = (high-low)/2 +low;
            if(nums[mid]>target){
                high=mid-1;
            }else if (nums[mid]<target){
                low=mid+1;
            }else{
                low=mid;
            }
        }
        
       if(nums[high]==target){
            return high;
        }else if(nums[low]==target){
            return low;
        }else{
            return -1;
        }
    }
}
