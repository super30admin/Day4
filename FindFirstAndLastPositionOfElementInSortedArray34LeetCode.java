//time complexity : O(log(n)) n=length of nums
//space complexity ; O(1)
//I don't face any problems
//runs successfully on leetcode


public class FindFirstAndLastPositionOfElementInSortedArray34LeetCode {

    public int[] searchRange(int[] nums, int target) {

        int start = startIndex(nums, target);               //find the start index
        int end = endIndex(nums, target);                   //find the last index

        return new int[]{start, end};
    }

    public int startIndex(int[] nums, int target){
        int start = 0;
        int end = nums.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;                //calculate the mid

            if(nums[mid] == target){                        //if nums[mid]==target
                if(mid == 0 || nums[mid-1] < nums[mid]){        //check if mid==0 or nums[mid] >nums[mid-1] then it means mid is at starting position
                    return mid;
                }
                else{                                       // it means mid is not at starting index, so move left
                    end = mid - 1;
                    continue;
                }
            }
            if(nums[mid]<target){                   //if num[mid]<target then move right
                start = mid + 1;
            }
            if(nums[mid]>target){                   //if nums[mid]>target then move left
                end = mid - 1;
            }
        }
        return -1;
    }

    public int endIndex(int[] nums, int target){

        int start = 0;
        int end = nums.length - 1;
        while(start<=end){
            int mid = start+ (end -start)/2;                                //calculate the mid

            if(nums[mid] == target){                                             //if nums[mid]==target
                if(mid == nums.length - 1 || nums[mid]<nums[mid+1]){       //check if mid==nums.length-1 or nums[mid] < nums[mid+1] then it means mid is at ending position
                    return mid;
                }
                else{                                            // it means mid is not at ending index, so move right
                    start = mid + 1;
                    continue;
                }
            }

            if(nums[mid]<target){                   //if nums[mid]<target then move right
                start = mid + 1;
            }

            if(nums[mid]>target){                   //if nums[mid]>target then move left
                end = mid - 1;
            }
        }
        return -1;
    }






}
