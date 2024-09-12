// Time Complexity : O(logN)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes


// Your code here along with comments explaining your approach
//I will take an op array with predefined elements [-1,-1], then I will take a flag isLeft, then I will check if l<=right I will proceed with BS
//In first case I will check if mid=traget then I will replace first element of op array =mid, then I will check whether islet is true, if so I will update right =mid-1, else left=mid-1
//In case 2 I will check if mid<target, then l=m+1 else r=m-1


class FirstAndLastInSortedArray {
    int[] output = new int[]{-1,-1};
    public int[] searchRange(int[] nums, int target) {
            
            int left = 0, right=nums.length-1;
            binarySearch(nums,target,left,right,true);
            binarySearch(nums,target,left,right,false);
            return output;
        }
        
        private void binarySearch(int[] nums, int target, int left, int right, boolean isLeft){
            while(left<=right){
                int mid = left+(right-left)/2;
                if(nums[mid]==target){
                    if(isLeft){
                        output[0]=mid;
                        right=mid-1;
                    }
                    else {
                        output[1]=mid;
                        left = mid+1;
                    }
                }
                else if(nums[mid]<target){
                    left = mid+1;
                }
                else{
                    right=mid-1;
                }
            }
        }
    }
