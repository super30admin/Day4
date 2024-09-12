//time Complexity: log(n)
//space complexity: O(1)

class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1) return 0;
        if(nums.length==2) return (nums[0]>nums[1]) ?0:1;
        int left=0,right=nums.length-1;
        int mid;
        while(left<=right){
            mid =left+(right-left)/2;
            if((mid==0 ||nums[mid]>nums[mid-1]) && (mid==right || nums[mid]>nums[mid+1])) return mid;
            else if(mid>left &&nums[mid-1]>nums[mid]){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }return -1;
    }
}