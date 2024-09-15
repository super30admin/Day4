class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        //finding first and last occurences in an array.
        /// Time : O(logN) Space: O(1)
        // first we check middle element if target matches with mid  then we check the eleement on the left of middle to see if there any other occurences if yes then that would be first Occurence.
// In the same way if target matches with mid we also check on right to check last occurence too.
        int ans[] = new int[2];
    int start =0, end = nums.length-1;
  ans[0] = firstOcurrence(nums, target, start, end);
    ans[1] = lastOcurrence(nums, target, start, end);
    return ans;
        
    }
    
    public int firstOcurrence(int[] nums , int target, int start , int end  ){
        int res = -1;
        while(start <= end){
            int mid = start + (end- start)/2;
            if(target == nums[mid]){
                res = mid;
                end = mid-1;
            }
            else if(target < nums[mid]){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
    
    
    return res;
    }
     public int lastOcurrence(int[] nums , int target, int start , int end  ){
        int res = -1;
        while(start <= end){
            int mid = start + (end- start)/2;
            if(target == nums[mid] ){
                res = mid;
                start = mid+1;
            }
            else if(target > nums[mid]){
                start = mid+1;
            }else{
                end = mid-1;
            }
        }
    
    
    return res;
    }
    
    
    
}