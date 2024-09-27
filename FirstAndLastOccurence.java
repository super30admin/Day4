/*
The time complexity is O(LogN) where N is number of elements in the array. The space complexity is O(1)

Here the idea is to seach for the first and last occurence of the target seperately. While finding first occurence, even if we found the
target we still search if the left of our found index is equal to target. If, yes we continue the binary seach. Same applies to
last occurence. Here we seach if the right of our index is equal to target.

Yes, the solution passed all the test cases in leetcode.
 */
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[]{-1,-1};

        int first = findFirst(nums,target);
        if(first==-1){return ret;}
        int last = findLast(nums,target);
        ret[0] = first; ret[1] = last;
        return ret;
    }

    public int findFirst(int[] nums,int target){
        int start = 0; int end = nums.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(nums[mid]==target){
                if(mid-1<0 || nums[mid-1]<target){return mid;}
                else{
                    end = mid-1;
                }
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }

    public int findLast(int[] nums,int target){
        int start = 0; int end = nums.length-1;

        while(start<=end){
            int mid = start + (end-start)/2;

            if(nums[mid]==target){
                if(mid+1>=nums.length || nums[mid+1]>target){return mid;}
                else{
                    start = mid+1;
                }
            }
            else if(nums[mid]>target){
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return -1;
    }
}