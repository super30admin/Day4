// Time Complexity : O(log(N)) N is size of input
// Space Complexity : O(1) No Auxilary Array
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : How to get first and last index of target with binary search option
// edge case handling was tricky


// Your code here along with comments explaining your approach


class FindPosition_last_first {
    private int firstPosition(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        
        while(left <= right){
            int mid = left + (right-left)/2;
//             if mid is target
            if(nums[mid] == target){
//                 if mid == 0 or mid element is greater than previous element
//                  that means mid is the first position
                if(mid == 0 || nums[mid] > nums[mid-1]){
                    return mid;
                }else{
//                     else there are elementes to the left of current mid that are equal to target
                    right = mid - 1;
                }
            }
//             search in lef side of array
            else if(nums[mid] > target){
                right = mid -1;
            }
//             search in right side of array
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
    
    private int lastPosition(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        
        while(left <= right){
            int mid = left + (right-left)/2;
//             if mid is target
            if(nums[mid] == target){
//                 if mid == 0 or mid element is less than than next element
//                  that means mid is the last position
                if(mid == nums.length -1  || nums[mid] < nums[mid+1]){
                    return mid;
                }else{
//                     else there are elementes to the right of current mid that are equal to target
                    left = mid + 1;
                }
            }
//             search in lef side of array
            else if(nums[mid] > target){
                right = mid -1;
            }
//             search in right side of array
            else {
                left = mid + 1;
            }
        }
        return -1;
    }
    public int[] searchRange(int[] nums, int target) {
//         edge case
        if (nums == null || ( nums.length == 0) ) return new int []{-1,-1};
        //  find the first position of target in array using binary search

        int first = firstPosition(nums,target);
        //  find the last posiiton of target in array using binay search
        int last = lastPosition(nums,target);
        
        return new int[]{first,last};
    }
    
    public static void main(String[] args) {
            int []nums = {5,7,7,8,8,10};
            int target = 8;
            FindPosition_last_first obj  = new FindPosition_last_first();

            int [] arr =obj.searchRange(nums, target);
            System.out.println(arr[0]+" "+arr[1]);
        }
    }