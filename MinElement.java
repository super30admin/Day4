// Time Complexity : O(logn)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : no


class MinElement {
    public static int findMin(int[] nums) {
        int start = 0;
        int end  = nums.length - 1;

        while(start <= end){

            if (nums[start] <= nums[end]){
                return nums[start];
            }
            int mid = (start + end) / 2;

            if(mid != 0 && nums[mid - 1] > nums[mid] ){
                return nums[mid];
            }

            if (nums[start] <= nums[mid]){
                start = mid + 1;
            }
            else{
                end = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int arr[] = {6,7,8,9,10,0,1,2};
        System.out.println(MinElement.findMin(arr));

    }
}