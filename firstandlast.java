// Time Complexity : o(log n)
// Space Complexity : o(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length== 0 || nums== null) return new int[] {-1,-1};
        int first=binaryFirstOccu(nums,target);
        if(first == -1){
        return new int[] {-1,-1};
        }
        int last=binaryLastOccu(nums,target);
        return new int[] {first,last};
        }
    
    private int binaryFirstOccu(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid= low + (high-low)/2; // to avoid integer overflow
            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]<nums[mid]){
                    return mid;
                }else{
                    high = mid -1;
                }
            }else if(nums[mid]>target){
                    high = mid-1;
            }else{
                    low = mid +1;
            }           
        }
        return -1;
    }
    
    private int binaryLastOccu(int[] nums,int target){
        int low=0;
        int high= nums.length-1;
        
        while(low<=high){
            int mid = low +(high - low)/2;
            
            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid+1]>target){
                    return mid;
                }else{
                    low = mid + 1;
                }
            }else if(nums[mid]>target){
                high= mid -1;
            }else{
                low = mid +1;
            }
            
        }
        
        return -1;
    }
}

MY APPROACH:

1.Here we will do binary search two time one to find first occurrence and last occurrence
2.now for first occurrence we will find target element when mid is equal to target element we will see mid-1<mid if true then return mid otherwise do high = mid -1;
3. Viceversa for last occurrence we will check mid<mid+1;