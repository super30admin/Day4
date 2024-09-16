class Solution {
    public int[] searchRange(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int start=binarySearchLeft(nums,left,right,target);
        if(start==-1)
        {
            return new int[]{-1,-1};
        }
        int end=binarySearchRight(nums,left,right,target);     
        return new int[]{start,end};
    }
    
    int binarySearchLeft(int[] a,int left,int right,int target)
    {
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(a[mid]==target)
            {
                if(mid==left||
                  a[mid-1]!=target)
                {
                    return mid;
                }
                right=mid-1;
            }
            else if(a[mid]>target)
            {
                right=mid-1;
            }
            else{
                left=mid+1;
            }
            
        }
        return -1;
         
    }
    int binarySearchRight(int[] a,int left,int right,int target)
    {
        while(left<=right)
        {
            int mid=left+(right-left)/2;
            if(a[mid]==target)
            {
                if(mid==right||
                  a[mid+1]!=target)
                {
                    return mid;
                }
                left=mid+1;
            }
            else if(a[mid]>target)
            {
                right=mid-1;
            }
            else
            {
                left=mid+1;
            }            
        }
        return -1;
         
    }
}

//Time Complexity- O(logn)
//Space complexity-O(1)