public class problem1 {

    // Time Complexity : O(log n)
    // Space Complexity : Constant
    // Did this code successfully run on Leetcode : Yes 
    // Any problem you faced while coding this : No

    public int[] searchRange(int[] nums, int target) {
        int ans[] = new int[2];
        ans[0] = left(nums,target);
        ans[1] = right(nums,target);
        
        return ans;
    }
    
     private int left(int[] nums, int target){
        int l=0;
        int r= nums.length-1;
        while(l<=r){
            int m = r-(r-l)/2;
            int x = nums[m];
            if(target>x){l=m+1;}
            else if(target<x){r=m-1;}
            else{
                if(m-1>=0 && nums[m-1]==target){ r=m-1;}
                else{return m;}
            }
        }
        return -1;
    }
    
     private int right(int[] nums, int target){
        int l=0;
        int r= nums.length-1;
        while(l<=r){
            int m = r-(r-l)/2;
            int x = nums[m];
            if(target>x){l=m+1;}
            else if(target<x){r=m-1;}
            else{
                if((m+1)<=nums.length-1 && nums[m+1]==target){ l=m+1;}
                else{return m;}
            }
        }
        return -1;
    }
}