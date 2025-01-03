// Time Complexity :log(n)+log(n)=2(log(n))=log(n)
// Space Complexity :O(1) constant
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
import java.util.Arrays;
/*
First see if mid is the target, if the ele before it is not the same, its the lowest occ. If it is, repeat binary search on left side to find lowest.
If mid is the target, if the ele after it is not the same, its the last occ. If it is, repeat binary search on right side to find highest.
If not perform regular binary search to ensure mid reaches target to meet base case.
 */
class FirstAndLastOccurance {
    public int[] searchRange(int[] nums, int target) {
        int [] res = new int[2];
        if(nums==null || nums.length==0){
            res[0]=-1;
            res[1]=-1;
            return res;
        }
        int low = 0;
        int high = nums.length-1;
        int firstOccurance = findTheFirstOccurance(nums,target,low,high);
        if(firstOccurance == -1){
            res[0]=firstOccurance;
            res[1]=firstOccurance;
            return res;
        }
        int secondOccurance = findTheSecondOccurance(nums,target,low,high);
        res[0]=firstOccurance;
        res[1]=secondOccurance;
        return res;
    }
    private int findTheFirstOccurance(int [] nums, int target, int low, int high){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if((mid == low) || nums[mid-1]!=target)
                    return mid;
                else{
                    high=mid-1;
                }
            } else if(nums[mid]<target){
                low = mid+1;
            } else if(nums[mid]>target){
                high = mid-1;
            }
        }
        return -1;
    }
    private int findTheSecondOccurance(int [] nums, int target, int low, int high){
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]==target){
                if((mid==high) || (nums[mid+1]!=target))
                    return mid;
                else{
                    low=mid+1;
                }
            } else if(nums[mid]<target){
                low = mid+1;
            } else if(nums[mid]>target){
                high = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] nums = {5,7,7,8,8,8,8,10};
        int target = 8;
        FirstAndLastOccurance obj = new FirstAndLastOccurance();
        System.out.println(Arrays.toString(obj.searchRange(nums,target)));
        int [] nums1 = {8,8,8,8,8,8,8,8};
        target = 8;
        System.out.println(Arrays.toString(obj.searchRange(nums1,target)));
        int [] nums2 = {1,2,3,4,5,6,7};
        target = 11;
        System.out.println(Arrays.toString(obj.searchRange(nums2,target)));
    }
}