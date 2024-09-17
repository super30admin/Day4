class Solution {
    public int[] searchRange(int[] nums, int target) {
        int []res = new int[2];
        res[0]= findFirst(nums,target);
        res[1]= findSecond(nums,target);
        return res;
    }
    
    int findFirst(int [] nums,int target){
        int start = 0;
        int end = nums.length-1;
        while(start<=end)
        {
            int mid = start+(end-start)/2;
           if(target==nums[mid])
           {        
                if(mid==0 || nums[mid-1]!=target)
                   return mid;

                    end=mid-1;

           }
            
                
            else if(target<nums[mid])
                end = mid-1;
            else
                start=mid+1;     
        }
        return -1;
    }
    
    
    
    int findSecond(int [] nums,int target){
        
        int start = 0;
        int end = nums.length-1;
        while(start<=end)
        {
            int mid = start+(end-start)/2;
           if(target==nums[mid])
           {
               if( mid == nums.length-1 || nums[mid+1]!=target)
                  return mid;
               
            start =mid+1;
                     
           }
                
            else if(target<nums[mid])
                end = mid-1;
            else
                start=mid+1;     
        }
        return -1;
    }
    
}