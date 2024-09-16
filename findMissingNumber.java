public class findMissingNumber {

    public static int findMissingNum(int[] nums){
        int start = 0;
        int end = nums.length - 1;
        int mid = 0;

        if(nums == null || nums.length == 0) {
            return -1;
        }
        while(start <= end){
            mid = start + (end - start)/2;
            if(mid - start == nums[mid]-nums[start]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[mid]+1;
    }

    public static void main(String[] args){
        int[] nums = {1, 2, 3, 4, 5, 7, 8};
        System.out.println(findMissingNum(nums));
    }
}
