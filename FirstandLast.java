
// Time Complexity: O(logn);
// Space complexity: O(1);

public class FirstandLast {
    public  int[] searchRange(int[] nums, int target) {
        int res[] = new int[2];

        res[0] = binaryLeft(nums, target);
        res[1] = binaryRight(nums,target);

        return res;

    }

    private int binaryLeft(int[]nums, int target){
        int left =0; int right = nums.length-1;
        int mid;

        while(left <= right){
            mid = left + (right -left)/2;

            if(nums[mid] == target){
                if(mid ==0 || nums[mid-1] !=target) return mid;
                right = mid -1;
            }
            else if(nums[mid]> target) right = mid-1;

            else left = mid+1;
        }

        return -1;
    }

    private int binaryRight(int[]nums, int target){
        int left =0; int right = nums.length-1;
        int mid;

        while(left <= right){
            mid = left + (right -left)/2;

            if(nums[mid] == target){
                if(mid ==  nums.length-1 || nums[mid+1] !=target) return mid;
                left = mid + 1;
            }
            else if(nums[mid]> target) right = mid-1;

            else left = mid+1;
        }

        return -1;
    }
    public static void main(String[] args) {
        System.out.println(searchRange(new int[]{5,5}, 5)[1]);
    }
}
