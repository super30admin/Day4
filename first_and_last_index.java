/*

Did it run on leet code: yes
Time Complexity: 0(logN)
Difficulties: How to continue search even if search is satisfied for finding lower 
or higher index

Algorithm:
-> Just do binary search twice for last and first index
-> Even if you have find the target, for left index you will still search in the lower half
to check if the same element is present for a lower index
-> Even if you have find the target, for right index you will still search in the right half
to check if the same element is present for a higher index

*/


class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = new int[]{-1,-1};
        
        // if(nums.length==1){
        //     if(nums[0]==target){
        //         return new int[]{0,0};
        //     }else{
        //         return new int[]{-1,-1};
        //     }
        // }
        
        // Finding left index
        int l=0;
        int r=nums.length;
        int res = -1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]==target){
                res = mid;
                r=mid;
            }else if(nums[mid]>target){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        result[0] = res;
        
        // Finding the right index
        l=0;r=nums.length;res=-1;
        while(l<r){
            int mid = (l+r)/2;
            if(nums[mid]==target){
                res = mid;
                l=mid+1;
            }else if(nums[mid]>target){
                r=mid;
            }else{
                l=mid+1;
            }
        }
        
        result[1] = res;
        return result;
    }
}