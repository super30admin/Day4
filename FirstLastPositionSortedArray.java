// Time Complexity :log(n)
// Space Complexity :log(n)
// Did this code successfully run on Leetcode:Yes 
// Any problem you faced while coding this :No
class FirstLastPositionSortedArray {
    public int[] searchRange(int[] nums, int target) {
        if (nums==null||nums.length==0){
            return new int [] {-1,-1};
        }
        int leftElement=binarySearchLeft(nums,target);
        int rightElement=binarySearchRight(nums,target);
        return new int [] {leftElement,rightElement};
    }
        


	private int binarySearchLeft(int[] nums, int target) {
		// TODO Auto-generated method stub
    	int low=0;
        int high=nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;
            if (nums[mid]==target){
                if(mid==0||nums[mid-1]<nums[mid]){
                    return mid;
                }
                else{
                    high=mid-1;
                }
            }
            else if(nums[mid]>target){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        
    }
		return -1;
	}
    private int binarySearchRight(int[] nums, int target) {
    	 int low=0;
         int high=nums.length-1;

         while(low<=high){
             int mid=low+(high-low)/2;
             if (nums[mid]==target){
                 if(mid==nums.length-1||nums[mid]<nums[mid+1]){
                     return mid;
                 }
                 else{
                     low=mid+1;
                 }
             }
             else if(nums[mid]>target){
                 high=mid-1;
             }
             else{
                 low=mid+1;
             }
         
     }
             return -1;
	}

       
}
