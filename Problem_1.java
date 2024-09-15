//LeetCode problem - 34
// Time Complexity : O(log n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes, but not able to run the code for test cases where there are 3 elements in the array that are same.
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
/** Implementation is based on Binary Search. Mid value is calculated and then checked if its equal to the target. In case it is equal, the neighbouring value is checked if that is equal to the target as well. In case this is not valid, then the low and high pointers are changed just like in Binary Search and again same check is done.
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        //if there is just one element in the array
        if(nums.length == 1){
            if(nums[0] == target)
                return new int[]{0,0};
            else 
                return new int[]{-1,-1};
        }
        
        //if there are just 2 elements

        if(nums.length == 2){
            if(target == nums[0]){
                if(target == nums[1])
                    return new int[]{0,1};
                else
                    return new int[]{0,0};
            }else if(nums[1] == target)
                return new int[]{1,1};
            else
               return new int[]{-1,-1};
        
        }
        
            
        
        int low = 0;
        int high = nums.length -1;
        
        while(low<=high){
            
            int mid = (high-low)/2+low;
            
            if(low == high) {
                if(nums[low] == target)
                    return new int[]{low,low};
                else 
                    return new int[]{-1,-1};
            }
            
            if(target == nums[mid]){
                if(target == nums[mid+1])
                    return new int[]{mid,mid+1};
                else if(target == nums[mid-1])
                    return new int[]{mid-1, mid};
                else
                    return new int[]{mid,mid};
            }else if(target<nums[mid])
                high = mid -1;
            else 
                low = mid + 1;
        }
        
        return new int[]{-1,-1};
    }
}