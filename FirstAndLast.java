// Time Complexity :O(log n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this :no
class Solution {
    public int[] searchRange(int[] nums, int target) {
            if(nums.length==0)
                return new int[]{-1,-1};
            if(nums.length==1){
                if(nums[0]==target)
                    return new int[]{0,0};
                else
                    return new int[]{-1,-1};
            }
            return bs(nums,target);   
    }
    private int[] bs(int[] nums,int target){
        int[] out=new int[]{-1,-1};
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]==target)
            {
                if(out[0]!=-1 && out[1]!=-1 && s<0 && e>nums.length-1){
                    return out;
                }
               //find the start index
                int sindex=mid; int eindex=mid;
                while(sindex>=0 && nums[sindex]==target)
                    sindex--;
                //find the end index
                while(eindex<=nums.length-1 && nums[eindex]==target)
                    eindex++;
                out[0]=sindex+1;
                out[1]=eindex-1;
                
                return out;
                
                
                
            }
            if(nums[mid]<target){
                s=mid+1;
            }
            if(nums[mid]>target){
                e=mid-1;
            }
            
        }
        return out;
    }
   
}