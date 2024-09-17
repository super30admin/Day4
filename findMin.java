/**Time Complexity :
    O(log n)
// Space Complexity :
    O(1)
// Did this code successfully run on Leetcode :
    Yes
// Any problem you faced while coding this :   
// Your code here along with comments explaining your approach
**/

class findMin{
    public int findMin(int[] nums) {

        //edge case
        if(nums.length==1) return nums[0];
        if(nums[0]<=nums[nums.length-1]) return nums[0];

        int low=0;
        int high=nums.length-1;

        while(low<=high){

            //if the array is sorted already, return low
            if(nums[low]<=nums[high]) return nums[low];
            int mid=low+(high-low)/2;

 
            if((mid==0 || nums[mid]<nums[mid-1]) && (mid==nums.length-1 || nums[mid]<nums[mid+1])){
                return nums[mid];
            }
            else if(nums[low]<=nums[mid]){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }
}