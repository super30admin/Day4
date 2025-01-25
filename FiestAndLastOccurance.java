// Time Complexity : O(log(n)) n is the no of elements
// Space Complexity : O(1) no extra space
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
/*
binary search to find first occurance and last occurance
*/
class FiestAndLastOccurance {
    public int[] searchRange(int[] nums, int target) {
        int firstOccurance=binarySearch(nums,target,true);
        if(firstOccurance==-1){
            return new int[]{-1,-1};
        }
        int lastOccurance= binarySearch(nums,target,false);
        return new int[]{firstOccurance,lastOccurance};
    }

    public int binarySearch(int[] nums,int target,boolean isFirst){
        int n=nums.length;
        int left=0;
        int right=n-1;

        while(left<=right){
            int mid=left+(right-left)/2;
            if(target==nums[mid]){
                if(isFirst){
                    if(mid==left || nums[mid]!=nums[mid-1]){
                        return mid;
                    }
                    else {
                        right=mid-1;
                    }
                }
                else {
                    if(mid==right || nums[mid]!=nums[mid+1]){
                        return mid;
                    }
                    else {
                        left=mid+1;
                    }
                }
            }
            else if(target < nums[mid]){
                right=mid-1;
            }
            else if(target > nums[mid]){
                left=mid+1;
            }
        }

        return -1;
    }

}
