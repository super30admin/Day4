class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int a =firstOccurence(nums,target);
        if(a==-1)
            return new int [] {-1,-1};
        int b= lastOccurence(nums,target);
        return new int [] {a,b};
        
        
    }
      int firstOccurence(int arr[],int x)
    {
        int n=arr.length;
        int low=0,high=n-1;
        
        while(low<=high)
        {
             int mid=(low+high)/2;
            if(arr[mid]<x)
                low=mid+1;
            else if(arr[mid] >x ) 
                high=mid-1;
            else 
            {
                if(mid == n-1 || arr[mid]!= arr[mid+1])
                    return mid;
                else 
                    low=mid+1;
            }
        }
        return -1;
    }
    
    int lastOccurence(int arr[],int x)
    {
        int n=arr.length;
        int low=0,high=n-1;
        int mid=(low+high)/2;
        while(low<=high)
        {
            if(arr[mid]<x)
                low=mid+1;
            else if(arr[mid] >x)
                high=mid-1;
            else 
                if(mid==0 || arr[mid-1]!=arr[mid] )
                    return mid;
                else 
                    high=mid-1;
            
        }
        return -1;
    }
    
    
}