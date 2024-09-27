

public class BinarySearch2 {
    /*34.Find First and Last Position of Element in Sorted Array
    https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/ */
    //time complexity: log(N)
    //space complexity: o(1)
    // able to run in leetcode: yes
    // any doubt about this question: no
    public int[] searchRange(int[] nums, int target) {
       int[] range = new int[2];
       range[0]= findfirstindex(nums,target);
       range[1]= findlastindex(nums,target);
       return range;
    }
    private static int findfirstindex(int[] nums,int target){
        int index =-1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high ){
            int mid = low+(high-low)/2;
            if(nums[mid]>= target){
                high = mid-1;
            }else{
                low = mid+1;
            }
            if(nums[mid]==target){
                index=mid;
            }
        }
        return index;
    }
    private static int findlastindex(int[] nums,int target){
        int index = -1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(nums[mid]<=target){
                low = mid+1;
            }else{
                high= mid-1;
            }
            if(nums[mid]==target){
                index=mid;
            }
        }
        return index;
    }

    /*153. Find Minimum in Rotated Sorted Array 
    https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/*/
    //time complexity: log(N)
    //space complexity: o(1)
    // able to run in leetcode: yes
    // any doubt about this question: no
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int min =  Integer.MAX_VALUE;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid]>=nums[low]){
                if(min>nums[low]){
                    min=nums[low];
                }
                low=mid+1;
            }else{  
                min=nums[mid];
                high=mid-1;
            }
        }
        return min;
    }
    /*162. Find Peak Element
    https://leetcode.com/problems/find-peak-element/ */
    //time complexity: log(N)
    //space complexity: o(1)
    // able to run in leetcode: yes
    // any doubt about this question: no
    public int findPeakElement(int[] nums) {
        int low =0;
        int high= nums.length-1;
        while(low<high){
            int mid= low+ (high-low)/2;
            if(nums[mid]<nums[mid+1]){
                low = mid+1;
            }else{
                high=mid;
            }
        }
        return low;
    }

}
