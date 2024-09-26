//Problem-1
//Time-Complexity-O(logn)
//Space Complexity_O(1)


//Did it sucessfully run on Leetcode:Yes
//Approach:Here we need to find the find and last position of the given target. We will do binary search first if we find
//the target then we store that to index list and will perform the binary search on the elments before it.If we find any
//then we update the result.In the same way we continue for the right side elements and store the elements the result to
//result list
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int []res= {-1,-1};
        int left=0;int right=nums.length-1;int mid=left+(right-left)/2;

        while(left<=right){
            mid= left+ (right-left)/2;
            if(nums[mid]==target){
                res[0]=mid;
                right=mid-1;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else right=mid-1;
        }

        left=0;right=nums.length-1;
        while(left<=right){
            mid= left+ (right-left)/2;
            if(nums[mid]==target){
                res[1]=mid;
                left=mid+1;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else right=mid-1;
        }

        return res;

    }
}
//Problem-2
//Time-Complexity-O(logn)
//Space Complexity_O(1)
//Did it sucessfully run on Leetcode:Yes
//Approach: Here the main observation is that pivot is the only element that is less than both its adjacent elements.Here
// we will take the mid element and check if any element to its adjacent is in sorted manner. If its sorted then we go to the
//unsorted end and continue the same procedure.we will find the minimum element(pivot).
class Solution {
    public int findMin(int[] nums) {
        int low=0;
        int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[low]<=nums[high]) return nums[low];
            if((mid==0 || nums[mid]<nums[mid-1])&& (mid==nums.length-1 || nums[mid]<nums[mid+1])){
                return nums[mid];
            }
            else if(nums[low]<=nums[mid]){
                low=mid+1;
            }
            else {
                high=mid-1;
            }
        }
        return -1;

    }
}
//Problem-3
//Time-Complexity-O(logn)
//Space Complexity_O(1)
//Did it sucessfully run on Leetcode:Yes
//Approach:Here the peak is greater than both of its adjacent elements. If its last of first element then we check the// c
//check the corresponding left and right elements.If the left element of mid is greater then we towards that array part. we
//do the same vice versa.Tip: We always go on the side greater to find the peak.

class Solution {
    public int findPeakElement(int[] nums) {
        int low=0;
        int high=nums.length-1;

        while (low<=high){
            int mid=low+(high-low)/2;
            if((mid==0||nums[mid]>nums[mid-1]) && (mid==nums.length-1||nums[mid]>nums[mid+1])){ return mid;}
            else if(mid>0 && nums[mid]<nums[mid-1]) {high=mid-1; }
            else {low=mid+1; }
        }
        return 0;
    }
}