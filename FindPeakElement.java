// Time Complexity : O(logn)
// Space Complexity :O(1)
class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(nums[mid]<nums[mid+1]){
                left=left+1;
            }else{
                right=mid;
            }
        }
        return left;
        
        
    }
}
