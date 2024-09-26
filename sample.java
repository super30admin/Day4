//*****FIND FIRST AND LAST INDEX OF GIVEN ELEMENT IN SORTED ARRAY*****
//Time complexity- o(logn)+o(logn);
//space complexity- 0(1);
//leetcode -Y;

class Solution {
    int lowforlast;
    
    private int Firstbinarysearch(int[] nums, int target)
    {
        int low=0;
        int high=nums.length-1;
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(nums[mid]==target)
            {
                if(mid==0 || nums[mid]> nums[mid-1])
                {
                    return mid;
                }
                else
                {
                    high=mid-1;
                }
                
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return -1;
    }
    
    private int Lastbinarysearch(int[] nums, int target)
    {
        int low=lowforlast;
        int high=nums.length-1;
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(nums[mid]==target)
            {
                if(mid == nums.length-1 || nums[mid]<nums[mid+1])
                {
                    return mid;
                }
                else
                {
                    low=mid+1;
                }
                
            }
            else if(nums[mid]>target)
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return -1;
    }
    
    
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0 || nums==null) return new int[] {-1,-1};
        
        if(nums[0]>target || nums[nums.length-1]<target) return new int[] {-1,-1};
        int first=Firstbinarysearch(nums, target);
        if(first==-1) return new int[]{-1,-1};
        lowforlast = first;
        int last=Lastbinarysearch(nums, target);
        return new int[] {first,last};
        
    }
}

****FIND THE MINIMUM IN ROTATED SORTED ARRAY****
//Time complexity- o(logn);
//space complexity- 0(1);
//leetcode -Y;

class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            
            if(nums[low]<=nums[high]) return nums[low];
            
            if((mid==0 || nums[mid]<nums[mid-1]) &&
               (mid==nums.length-1 || nums[mid]<nums[mid+1]))
            {
                return nums[mid];
            }
            else if(nums[low]<=nums[mid])
            {
                low=mid+1;
            }
            else
            {
                high=mid-1;
            }
           
            
        }
        return 989;
        
    }
}
//****FIND THE PEAK ELEMENT IN THE GIVEN ARRAY****
//Time complexity- o(logn);
//space complexity- 0(1);
//leetcode -Y;

class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length-1;
        
        while(low<=high)
        {
            int mid=low+(high-low)/2;
            if((mid ==0 || nums[mid] > nums[mid-1])
                && (mid==nums.length-1 || nums[mid] > nums[mid+1]))
            {
                return mid;
            }
            else if(mid>0 && nums[mid-1]>nums[mid])
            {
                high=mid-1;
            }
            else
            {
                low=mid+1;
            }
        }
        return -1;
    }
}

