import java.util.Arrays;

class FirstAndLastPosition {
    public static int[] searchRange(int[] nums, int target) {

        int n = nums.length;
        if(nums==null || n==0){
            return new int[]{-1,-1};
        }
        if(nums[0]>target || nums[n-1] < target){
            return new int[]{-1,-1};
        }
        int first = firstIndexBinarySearch(nums, 0, n-1, target);
        if(first == -1){
            return new int[]{-1,-1};
        }
        int last = lastIndexBinarySearch(nums, first, n-1, target);
        return new int[]{first, last};
    }

    private static int firstIndexBinarySearch(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                if(mid == 0 || nums[mid]!=nums[mid-1]){
                    return mid;
                }
                high = mid - 1;
            }
            else if(nums[mid]>target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int lastIndexBinarySearch(int[] nums, int low, int high, int target){
        while(low<=high){
            int mid = low + (high-low)/2;

            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid]!=nums[mid+1]){
                    return mid;
                }
                low = mid + 1;
            }
            else if(nums[mid]>target){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,6,6,7,8};
        int[] result = searchRange(nums, 6);

        System.out.println(Arrays.toString(result));
    }
}