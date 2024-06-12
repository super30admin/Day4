//first and last element in sorted array
//TC O(logn)
//Space O(1)
//leetcode done
//No problems

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if(nums.length==0){
            return new int[]{-1,-1};
        }
        int start_position=-1;
        int end_position=-1;
        int first=0;
        int last=nums.length-1;
        while(first<=last){
            int mid=first+(last-first)/2;
            if(nums[mid]==target){
                if(mid==0||nums[mid-1]!=target){
                    start_position=mid;
                    break;
                }else{
                    last=mid-1;
                }
            }else if(nums[mid]>target){
                last=mid-1;
            }else{
                first=mid+1;
            }
            
        }
        if(start_position==-1){
            return new int[]{-1,-1};
        }
        first =start_position;
        last=nums.length-1;
        while(first<=last){
            int mid=first+(last-first)/2;
            if(nums[mid]==target){
                if(mid==nums.length-1||nums[mid+1]!=target){
                    end_position=mid;
                    break;
                }else{
                    first=mid+1;
                }
            }else if(nums[mid]>target){
                last=mid-1;
            }else{
                first=mid+1;
            }
            
        }
        
        return new int[]{start_position,end_position};
        
    }
}


//min in rotated sorted array
//O(logn),O(1),leetcode done, no probs

class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<high){
            int mid=low+(high-low)/2;
            
            if(nums[mid]>nums[high]){
                low=mid+1;
            }else{
                high=mid;
            }
        }
        return nums[low];
        
    }
}