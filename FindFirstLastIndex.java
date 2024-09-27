public class FindFirstLastIndex {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0)
            return new int[] {-1,-1};
        if(nums[0]==target && nums[nums.length-1]==target)
             return new int[] {0,nums.length-1};
        int first=binarySearchLeft(nums,0,nums.length-1,target);
        if(first==-1)
            return new int[] {-1,-1};
        int second=binarySearchRight(nums,first,nums.length-1,target);
        
        return new int[] {first,second};
    }
    public int binarySearchLeft(int[] nums,int low,int high,int target)
    {
        while(low<=high)
        {
            int middle=low+(high-low)/2;
            if(nums[middle]==target)
            {
                if(middle==0||nums[middle-1]<nums[middle])
                    return middle;
                else high=middle-1;
                
            }
            else if(nums[middle]>target)
                high=middle-1;
            else low=middle+1;
        }
        return -1;
    }
     public int binarySearchRight(int[] nums,int low,int high,int target)
    {
        while(low<=high)
        {
            int middle=low+(high-low)/2;
            if(nums[middle]==target)
            {
                if(middle==nums.length-1||nums[middle+1]>nums[middle])
                    return middle;
                else low=middle+1;
                
            }
            else if(nums[middle]>target)
                high=middle-1;
            
        }
        return -1;
    }

    public static void main(String[] args)
    {
        FindFirstLastIndex obj=new FindFirstLastIndex();
        int[] nums={5,7,7,8,8,10};
        int[] range=obj.searchRange(nums, 8);
        System.out.println(range[0]+","+range[1]); 
    }

}
