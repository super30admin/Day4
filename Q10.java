// Find peak element LC 162

//both left and right side elements are lower than the peak ellement 
//IF it has both the neighbours
//else you compare with whichever neighbour is there

//there can be multiple peaks
//we first check if the mid is a peak
//We move towards the dirction where a number is higher than the mid

class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            //check if middle element is the peak
            if((mid==0 || nums[mid]>nums[mid-1]) &&(mid==nums.length -1 || nums[mid]>nums[mid+1])){
                return mid;
            }
            else if (mid>0 && nums[mid]<nums[mid-1]){
                high = mid-1;
            }
            else{
                low = mid+1;
            }
        }
        return -1;
    }
}