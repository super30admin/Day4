
//time complexity = o(logn)
//ran successfully on leetcode : Yes

public class FirstAndLastOccurrence {

    public static void main(String[] args) {
        int[] nums = new int[] {5,7,7,8,8,10};

        int [] answer =searchRange(nums,6);
        for (int i =0; i < answer.length; i++) {
            System.out.println(answer[i]);
        }
    }

    public static int[] searchRange(int[] nums, int target) {
        int firstOccurrence = leftSearch(nums,0,nums.length-1,target);
        int lastOccurrence = rightSearch(nums,0,nums.length-1,target);
        return new int[] {firstOccurrence,lastOccurrence};
    }

    public static int leftSearch(int[] nums, int low, int high, int target) {


        while (low<=high) {
            int mid = (low+high)/2;

            if (nums[mid]==target) {
                if(low==mid|| nums[mid-1] < nums[mid]) {
                    return mid;
                }
                else {
                    high = mid -1;
                }
            }

            else if (nums[mid] < target) {
                low = mid +1;
            }

            else {
                high = mid -1;
            }
        }

        return -1;
    }

    public static int rightSearch (int[] nums, int low, int high, int target) {



        while (low <= high) {
            int mid = (low+high)/2;

            if (nums[mid]==target) {
                if (high==mid||nums[mid] < nums[mid+1]){
                    return mid;
                }
                else {
                    low = mid + 1;
                }
            }

            else if (nums[mid] < target) {
                low = mid +1;
            }
            else {
                high = mid -1;
            }
        }

        return -1;
    }
}
