public class NumberRange {
    //TC is 2logn which is equal to O(logn)
    //SC is O(1)
    public static int[] searchRange(int[] nums, int target) {
        int firstIndex = -1, lastIndex = -1;
        firstIndex = binarySearchLeft(nums,target);
        if(firstIndex != (-1)){
            lastIndex = binarySearchRight(nums, firstIndex, target);
        }
        return new int[]{firstIndex,lastIndex};
    }
    
    //TC is O(logn)
    //SC is O(1)
    public static int binarySearchLeft(int[] nums, int target){
        int low = 0, high = nums.length-1,mid;
        while(low<=high){
            mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == 0 || nums[mid]>nums[mid-1]){
                    return mid;
                }else{
                    high = mid-1;
                }
            }else if(nums[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
    
    //TC is O(logn)
    //SC is O(1)
    public static int binarySearchRight(int[] nums, int low, int target){
        int high = nums.length-1,mid;
        while(low<=high){
            mid = low + (high-low)/2;
            if(nums[mid] == target){
                if(mid == nums.length-1 || nums[mid+1]>nums[mid]){
                    return mid;
                }else{
                    low = mid+1;
                }
            }else if(nums[mid]>target){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }

    public static void main(String arr[]){
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        int[] range = searchRange(nums, target);
        System.out.printf("Expected 3,4  actual %d,%d",range[0],range[1]);
    }
}
