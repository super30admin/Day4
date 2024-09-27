class Solution {

    //time: O(log n) space: O(1)
    public  int[] searchRange(int[] nums, int target) {
        int first=0;int last=nums.length-1;int[] result={-1,-1};
        while(first<=last){
            
        if(nums[first]==nums[last]&& target==nums[first])                                               {
            result[0]=first;
            result[1]=last;
            return result;
           }
            int mid=first+(last-first)/2;
            
            if(target==nums[mid]){
               if(mid>=first){
                if(nums[first]==target)
                    result[0]=first;
                else first=first+1;
            }
                if(mid<=last){
                if(nums[last]==target)
                    result[1]=last;
                else last=last-1;
            }}
            else if(target>mid)first=mid+1;
            else last=mid-1;
                                    
            }
    return result;
    }
}
