/**
 * Time Complexity : O(logn) where n is the size of sorted array
 * Space Complexity : O(1)
 */

public class FirstLast {
    private int binarySearchLeft(int[] nums, int target){
            int low = 0;
            int high = nums.length-1;
            
            while(low<=high){
                int mid = low + (high-low)/2;
                 if(target==nums[mid]){
                     if(mid == 0 || nums[mid-1]<nums[mid])
                         return mid;
                     else high=mid-1;
                 }
                else if(target<nums[mid])
                    high = mid-1;
        
                else low = mid+1;
            }
            return -1;
        }
    
    private int binarySearchRight(int[] nums,int target){
        int low = 0;
        int high = nums.length-1;
        
        while(low<=high){
            int mid = low + (high-low)/2;
            if(target==nums[mid])
                if( mid == nums.length-1 || nums[mid+1]>nums[mid])
                    return mid;
                else low = mid + 1;
            else if(target<nums[mid])
                high = mid-1;
            else low = mid+1;
        }
        return -1;
    }
    
    public int[] searchRange(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1,-1};
        int firstOccurance = binarySearchLeft(nums,target);
        int lastOccurance = binarySearchRight(nums,target);
        return new int[]{firstOccurance,lastOccurance};
        
    }

    public static void main(String args[]){
        int[] myArr = {2,2,4,5,5,5,7,15,20,20};
        int target = 5;
        FirstLast obj = new FirstLast();
        int[] occurance=obj.searchRange(myArr,target);
        System.out.println(occurance[0]+" , "+occurance[1]);
    }
}