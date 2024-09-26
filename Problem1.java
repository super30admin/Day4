class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int l=0;
        int h =nums.length;
      
        
        while(l<h)
        {
             int mid =l + (h-l)/2;
            if(nums[mid]==target)
            {
                if(nums[mid-1]==target)
                {
                   
                 return  new int[]{mid-1,mid};
                }
                else
                {
                return new int[]{mid,mid+1};
                }
            }
            else if(nums[mid]>target)
            {
                
                h=mid-1;
            }
            else
            {
               l=mid+1; 
            }
            
        }
        
    return new int[]{-1,-1};    
        
    }
}