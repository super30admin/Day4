// time complexity  O(logn)
// space complexity O(1)
class Solution {
    public int[] searchRange(int[] nums, int target) {
       
        int [] result=new int [2];
        Arrays.fill(result,-1);
         if(nums.length==0){
            return result;
        }
        result[0]=leftIndex(nums,target);
        result[1]=rightIndex(nums,target);
        return result;
    }
    public int leftIndex(int[] nums, int target){
        int start=0;
        int end=nums.length-1;
        int mid;
        if(nums[0]==target){
            return 0;
        }
        while(start<=end){
            mid=start + (end-start)/2;
            
            if(nums[mid]==target && nums[mid-1]!=nums[mid]){
                return mid;
            }
            if(nums[mid]<target){
                start=mid+1;
            }else if(nums[mid]>=target){
                end=mid-1;
            }
        }
        return -1;
    }
    
    public int rightIndex(int[] nums, int target){
        int start=0;
        int end=nums.length-1;
        int mid;
        if(nums[nums.length-1]==target){
            return nums.length-1;
        }
        while(start<=end){
            mid=start + (end-start)/2;
            
            if(nums[mid]==target && nums[mid+1]!=nums[mid]){
                return mid;
            }
            if(nums[mid]<=target){
                start=mid+1;
            }else if(nums[mid]>target){
                end=mid-1;
            }
        }
        return -1;
    }
    
}