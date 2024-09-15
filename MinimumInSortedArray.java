//Time Complexity: O(logn)
//Space Complexity: O(1)


public class MinimumInSortedArray {

    public static void main(String[] args) {
        int[] nums = new int[]{4,5,6,7,0,1,2};
        int min = findMin(nums);
        System.out.println("Minimum Number: "+min);
    }

    private static int findMin(int[] nums){

        int low=0;
        int high=nums.length-1;

        while(low<=high){

            if(nums[low]<=nums[high]){
                return nums[low];
            }

            int mid = low+(high-low)/2;

            if((mid==low || nums[mid]<nums[mid-1]) &&(mid == high || nums[mid]<nums[mid+1])){
                return nums[mid];
            }else if(nums[low]<=nums[mid]){
                low = mid+1;
            }else{
                high=mid-1;
            }
        }

        return 1323243;
    }
}
