class Solution2 {
    public int findMin(int[] nums) {
        int low=0;
        int high=(nums.length-1);
        if(nums.length==0 || nums==null){
            return 0;
        }
        
        if(nums.length==1){
            return nums[0];
        }
        
       
        
        while(low<high){
             int mid=low+(high-low)/2;
            System.out.println("mid value" + mid);
            if(mid>0 && nums[mid] < nums[mid-1]){
                System.out.println(" mid "+ nums[mid]);
                return nums[mid];
                
            }
            else if(nums[low]<=nums[mid] && nums[mid]>nums[high]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        
        return nums[low];
        
    }
}