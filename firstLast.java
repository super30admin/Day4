//TC: O(n)
//SC: O(n)
/* We try to do Binary search twice, we do it once to find one occurence, and re do it for second occurence, we take the minumum index of these two, as index in resultant array, and max value as the second index
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0]=Integer.MAX_VALUE;
        result[1]=Integer.MIN_VALUE;
        bsearch(nums,result,0,nums.length-1,target);
        if(result[0]==Integer.MAX_VALUE&&result[1]==Integer.MIN_VALUE){
            result[0]=-1; result[1]=-1;
        }
        return result;
        
    }
    
     private void bsearch(int[] nums, int[] result, int l, int r, int target){
        
        if(l>r) return;
        
        int mid=(r-l)/2+l;
        
        if(target==nums[mid]) {
            //One element has been found already
            result[0] = Math.min(result[0],mid);
            result[1]= Math.max(result[1],mid);
            bsearch(nums,result,l,mid-1,target);
            bsearch(nums,result,mid+1,r,target);
            
        }
        else if(target<nums[mid]) bsearch(nums,result,l,mid-1,target); //left side only search
        else if(target>nums[mid]) bsearch(nums,result,mid+1,r,target);
//right side only search
        
        
    }
}
