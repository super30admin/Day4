//Complexity would be O(logn +n+n) but this is not optimal. Couldn't figure out the ideal optimal way.


class Solution {
    public int[] searchRange(int[] nums, int target) {
       
        int[] ans = new int[]{-1,-1};
        if(nums.length<1 )
            return ans;
         int low=0;
        int high=nums.length-1;
        int f=0;
        boolean flag=false;
        if(nums[low]==target && nums[high]==target){
            ans[0]=low;
            ans[1]=high;
            return ans;
        }
        while(low<high)
        {
            int mid=low+(high-low)/2;
            if(nums[mid]<target)
                low=mid+1;
            else if(nums[mid]>target)
                high=mid-1;
            else
            {
                f=mid;
                flag=true;
                break;
            }
        }
        if(!flag) return ans;
        if(nums[low]==target )
        {
            if(low>0 && nums[low-1]==target)
            {
                while(nums[low-1]!=target && low>=0)
                    low--;
            }
            ans[0]=low;
        }
        else{
             while(nums[low]!=target && low<=f){
                    low++;
                  
             }
            ans[0]=low;
        }
        if(nums[high]==target )
        {
            if( high<nums.length-1 && nums[high+1]==target)
            {
                while(nums[high+1]!=target && high<=nums.length-1)
                    high++;
            }
            ans[1]=high;
        }
        else{
             while(nums[high]!=target && high>=f){
                    high--;
                 
             }
            ans[1]=high;
        }
        return ans;
    }
}