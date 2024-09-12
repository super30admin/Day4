// T(n)=O(log n)
// S(n) = O(1)

class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        int i=0,j=nums.length-1;
        int li=nums.length+1,hi=-2;
        while(i<=j)
        {
            int mid=i+(j-i)/2;
            if(nums[mid]==target)
            {
                System.out.println(li+" "+mid);
                if(li>mid)
                {
                    
                   li=mid; 
                }
                    
                j=mid-1;
            }
            else if(nums[mid]>target)
            {
                j=mid-1;
            }
            else
                i=mid+1;
        }
        i=0;
        j=nums.length-1;
        while(i<=j)
        {
            int mid=i+(j-i)/2;
            if(nums[mid]==target)
            {
                if(hi<mid)
                    hi=mid;
                i=mid+1;
            }
            else if(nums[mid]>target)
            {
                j=mid-1;
            }
            else
                i=mid+1;
        }
        if(li==(nums.length+1)||(hi==-2))
        {
            li=-1;
            hi=-1;
        }
        int[] ar={li,hi};
        return ar;
    }
}