//Algo: Binary Search, used sepearte binary search for finding first and last element
//TC: O(logN) + O(logN) = 2(logN) = O(logN)
//SC: O(1) no extra space

public class Solution {
    
    private int BinarySearchFirstIndex(int[]nums,int target,int low, int high){
        
        if(nums[low]==target){
            return low;
        }
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                 if(mid == 0 || nums[mid-1]!=target){
                return mid;
              }else{
                     high = mid-1;
                 }
            }else if(nums[mid]<target){
                low =mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
    
     private int BinarySearchLastIndex(int[]nums,int target,int low, int high){
        
        if(nums[high]==target){
            return high;
        }
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                if(mid == nums.Length-1 || nums[mid+1]!=target){
                return mid;
            }else{
                    low = mid+1;
                }
            
            }else if(nums[mid]<target){
                low =mid+1;
            }else{
                high = mid-1;
            }
        }
        return -1;
    }
    
    public int[] SearchRange(int[] nums, int target) {
        if(nums == null || nums.Length == 0){
            return new int[]{-1,-1};
        }
        
        int high = nums.Length - 1;
        int low  = 0;
        
        if(nums[low] == target && nums[high] == target){
            return new int[]{low,high};
        }
        int firstPos = BinarySearchFirstIndex(nums,target,low,high);
        if(firstPos == -1){
            return new int[]{-1,-1};
        }
        int lastPos = BinarySearchLastIndex(nums,target,firstPos,high);
        
        return new int[] {firstPos,lastPos};
    }
}