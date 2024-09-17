//Time complexity : Big O(logn) since we are doing binary search
//Space complexity :  Its iterative method so space is O(1)
//Ran on leetcode : yes
class Solution {
    	public int[] searchRange(int[] nums, int target) {
        int[]  result= new int[2];
        int leftIndex = binarySearchLeft(nums,0,nums.length-1,target);
        int rightIndex = binarySearchRight(nums,0,nums.length-1,target);
        result[0] = leftIndex;
        result[1] = rightIndex;
        
        return result;
    }
    
    private int binarySearchLeft(int[] nums,int l,int h,int target)
    {
        int res=-1;
        while(l<=h)
        {
        int mid=l+(h-l)/2;
            //if found, dont return, keep checking in left and save new mid if found in left part
        if(target==nums[mid])
        {
            res=mid;
            //return mid;
           // h=mid-1;
        }
           
        if(target<=nums[mid])
            h=mid-1;
        else
            l=mid+1; 
        }
        //System.out.println("res left" + res);
       return res; 
    }
     private int binarySearchRight(int[] nums,int l,int h,int target)
    {
        int res=-1;
        while(l<=h)
        {
        int mid=l+(h-l)/2;
         if(target==nums[mid])
        {
            res=mid;
            //l=mid+1;
        }
           //this is important, here it shouldn't be lesser than equals, because equals we already checked in left half, so here it should be lesser only
        if(target< nums[mid]) 
            h=mid-1;
        else 
            l=mid+1;
        }
        //System.out.println("res right" + res);
       return res; 
    }
		
}
