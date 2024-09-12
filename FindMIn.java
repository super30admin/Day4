class Solution{
public int findMin(int[] nums) {
        int low=0,high=nums.length-1;
        int minEle=Integer.MAX_VALUE;
        while(low<=high)
        {
            int mid=(low+high)/2;
            minEle=Math.min(minEle,nums[mid]);
            if(nums[mid]>nums[low]) //Left Part
            {
                minEle=Math.min(minEle,nums[low]);
                low=mid+1;
            }
            else // Right Part
            {
                if(mid!=(nums.length-1))
                {
                    minEle=Math.min(minEle,nums[mid+1]);
                }
                high=mid-1;
            }
        }
        return minEle;
    }
    
    }
