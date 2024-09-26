public class FindFirstLastIndex {
    private int getFirstPosition(int[] nums, int target, int start, int end)
        {
            int left =start;
            int right=end;
            while(left<=right)
            {
                int middle = left + (right - left)/2;
                if(nums[middle] == target)
                {
                    if(middle == left || (nums[middle]>nums[middle-1]))
                        return middle;
                    else {
                        right=middle-1;
                    }   
                }
                else if(nums[middle] > target)
                    right= middle -1;
                else left = middle + 1;
                
            }
         
         return -1;
            
        }
     private int getLastPosition(int[] nums, int target, int start, int end)
        {
            int left=start;
            int right=end;
            while(left<=right)
            {
                int middle = left + (right - left)/2;
                if(nums[middle] == target)
                {
                    if(middle == end || (nums[middle]<nums[middle+1]))
                        return middle;
                    else {
                        left=middle+1;
                    }   
                }
                else if(nums[middle] > target)
                    right= middle -1;
                else left = middle + 1;
                
            }
         
         return -1;
            
        }
      public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0)  return new int[] {-1,-1};
        if(nums[0]==target && nums[nums.length-1]==target)
             return new int[] {0,nums.length-1};  
        int n = nums.length;
        int first = getFirstPosition(nums,target,0,n-1);
          
         if(first ==-1)
             return new int[] {-1,-1};
          
         int last = getLastPosition(nums,target,first,n-1);
          
         return new int[] {first,last}; 
    }

    public static void main(String[] args)
    {
        FindFirstLastIndex obj=new FindFirstLastIndex();
        int[] nums = {1,5,5,5,7,8,9,9};
        int[] pos= obj.searchRange(nums, 5);
        System.out.println(pos[0] + " "+ pos[1]);
    }
}
