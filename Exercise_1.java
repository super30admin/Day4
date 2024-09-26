//Time complexity - O(logN)
//Space Complexity - O(1)

class Solution {
    public int[] searchRange(int[] nums, int target) {

        /** to check first occurence and last occurance of the target */

        int length = nums.length;

        /** check the first Occurence */
        int firstOccurence = this.find(nums,target,true);


        /** return -1 if firstOccurence not found */
        if(firstOccurence == -1) {

            return new int[]{-1,-1};

        }


        /** check the second Occurence */
        int secondOccurence = this.find(nums,target,false);

        /** return firstOccurence & secondOccurence if found */
        return new int[]{firstOccurence,secondOccurence};


    }
    public int find(int[] nums, int target, boolean isFirst) {

        int begin = 0;
        int end = nums.length - 1;


        while(begin <= end){


            int mid = (begin + end) / 2;

            if(nums[mid] == target) {

                if(isFirst) {


                    /** condition to check and only perform binary search on left side */
                    if(mid == begin || nums[mid-1] != target) {

                        return mid;

                    }

                    end = mid - 1;

                }

                else {

                    /** condition to check and only perform binary search on right side */
                    if(mid == end || nums[mid+1] != target) {


                        return mid;
                    }

                    begin = mid + 1;
                }
            }

            else if(nums[mid] > target) {

                end = mid - 1;

            }
            else {
                begin = mid + 1;
            }


        }

        return -1;
    }
}
