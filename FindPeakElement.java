
//Time Complexity: O(logn)
//Space Compelxity: O(1)

public class FindPeakElement {

    public static void main(String[] args) {

        int[] nums = new int[]{1,2,1,3,5,6,4};
        int peak = findPeak(nums);
        System.out.println("Peak Element: "+peak);
    }

    private static int findPeak(int[] nums){
        int low=0;
        int high=nums.length-1;

        while(low<=high){

            int mid = low+(high-low)/2;

            if((mid == low|| nums[mid]>nums[mid-1])&&(mid==high || nums[mid]>nums[mid+1])){
                return mid;
            }else if(nums[mid]<nums[mid+1]){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return 2432;
    }
}
