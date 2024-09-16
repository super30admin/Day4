class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null||nums.length==0)
        {
            
            return new int[]{-1,-1};
        }
        
        int first = binarysearch(nums,target,false);
        int second = binarysearch(nums,target,true);
        
        return new int[]{first,second};
        
    }
    public int binarysearch(int[] nums1,int tar, boolean check)
    {
        int low = 0;
        int high = nums1.length-1;
        
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            
            if(nums1[mid] == tar)
            {
                //first index
                if(check==false)
                {
                    if(mid==0||nums1[mid]>nums1[mid-1])
                    {
                        return mid;
                    }
                    else{
                        high = mid-1;
                    }
                }
                //second index
                else if(check == true)
                {
                    if(mid==nums1.length-1 || nums1[mid]<nums1[mid+1])
                    {
                        return mid;
                    }
                    else{
                        low = mid+1;
                    }
                
                }
            }
            else if(nums1[mid]!=tar){
                if(nums1[mid]>tar)
                {
                    high = mid-1;
                }
                else if( nums1[mid]<tar)
                {
                    low = mid+1;
                }
            }
            
        }
        return -1;
    }
}
//runtime: Since we are using binary search it is O(logn) and O(1) for the rest of the lines and fuctions
//space complexity: since we are not using any additional space it is O(1).
