// Time Complexity: O(log(M*N))
// Space complexity: O(1)

import java.util.Arrays;

class findFirstLast {
    public int[] searchRange(int[] nums, int target) {
        int low =0;
        int high = nums.length -1;
        int[] result = {-1,-1};
        int mid = 0;
        int found=0;
        while(low<=high){
            mid = low + (high-low)/2;
            if(nums[mid]==target){
                found = mid;
                if(mid==0 || nums[mid]!=nums[mid-1]){
                    result[0] = mid;
                    break;
                } else{
                    high = mid-1; 
                }
            } else{
                if(nums[mid]<target){
                    low = mid+1;
                } else{
                    high = mid-1;
                }
            }
        }
        if(result[0] == -1) return result;
        low = result[0];
        high = nums.length-1;
        while(low<=high){
            mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid]!=nums[mid+1]){ 
                    result[1] = mid;
                    break;
                } else{
                    low = mid+1;
                }
            } else{ 
                if(nums[mid]<target){
                    low = mid+1;
                } else{
                    high = mid-1;
                }
            }
        }
        return result;
        }
    }