// Time Complexity : O(log(n))
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach



class FirstLastElement {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0 || nums==null || target<nums[0] || target>nums[nums.length-1])
            return new int[]{-1,-1};
        int left=binarySearchLeft(nums,0, nums.length-1,target);
        if(left==-1) return new int[]{-1,-1};
        int right=binarySearchRight(nums,left, nums.length-1,target);
        
        return new int[]{left,right};        
        
    }
    
    private int binarySearchLeft(int[] nums, int low, int high, int target ){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==0 || nums[mid]>nums[mid-1]){
                    return mid;
                }else
                    high=mid-1;
                
            }else {
                if(nums[mid]>target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
        }
        
        return -1;
    }
    
      private int binarySearchRight(int[] nums, int low, int high, int target ){
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid]<nums[mid+1]){
                    return mid;
                }else
                    low=mid+1;
                
            }else {
                if(nums[mid]>target){
                    high=mid-1;
                }else{
                    low=mid+1;
                }
            }
        }
        
        return -1;
    }



    public static void main(String args[]) 
    {
       
        FirstLastElement obj = new FirstLastElement();
        int array_input[]={ 5,7,7,8,8,10  };
        obj.searchRange(array_input, 8);
   
    }


}