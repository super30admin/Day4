//TimeComplexity : O(log(n))
//SpaceComplexity : O(1)

public class LastAndFirst {
    public int[] searchRange(int[] nums, int target) {
        if(nums==null || nums.length==0){
            return new int[] {-1,-1};
        }
        if(nums[0]>target || nums[nums.length-1] < target){
            return new int[] {-1,-1};
        }
        int first = firstBinarySearch(nums, target);
        if(first==-1){
            return new int[]{-1,-1};
        }
        int second= lastBinarySearch(nums, target);
        return new int[] {first,second};
    }

    private int lastBinarySearch(int[] nums, int target) {
        int low =0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low +(high-low /2);
           if(nums[mid]==target){
               if(nums[mid+1]!=target){
                   return mid;
               }
               low=mid+1;
           }else if(nums[mid]<target){
               low=mid+1;
           }
           else{
               high=mid-1;
           }
        }

        return -1;
    }

    private int firstBinarySearch(int[] nums, int target) {
        int low =0;
        int high = nums.length-1;

        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid]== target) {
                if (nums[mid - 1] != target) {
                    return mid;
                }
                high = mid - 1;
            }
            else if(nums[mid]< target){
                    low= mid+1;
            }
            else
                high=mid-1;
            }
        return -1;
    }


}
