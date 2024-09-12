class Solution {
    
    private int searchLow(int arr[],int low,int high,int targ)
    {   
        
        
        while(high>=low)
        {
            int mid = low+(high-low)/2;
            
            if(arr[mid] == targ)
            {
                if(mid==0 || arr[mid] > arr[mid-1])
                {
                    return mid;
                }
                else
                {
                    high = mid-1;
                }
            }     
            else if(arr[mid] > targ)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        
        return -1;
    }
    
    private int searchHigh(int arr[],int low,int high,int targ)
    {   
        
        
        while(high>=low)
        {
            int mid = low+(high-low)/2;
            
            if(arr[mid] == targ)
            {
                if(mid==arr.length-1 ||arr[mid] < arr[mid+1])
                {
                    return mid;
                }
                else
                {
                    low = mid+1;
                }
            }    
            else if(arr[mid] > targ)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        
        if(nums.length==0)
        {
            return new int[]{-1,-1};
        }
        
        int first = searchLow(nums,0,nums.length-1,target);
        
        if(first == -1)
        {
            return new int[]{-1,-1};
        }
        
        int second = searchHigh(nums,first,nums.length-1,target);
        
        return new int[]{first,second};
    }
}