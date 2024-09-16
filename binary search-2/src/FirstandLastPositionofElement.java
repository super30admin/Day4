
class FirstandLastPositionofElement {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{startingpoint(nums, target),endpoint(nums, target)};
    }
    private int startingpoint(int[] nums, int target){
        int low=0;
        int high= nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]==target){
                if(mid==0 || nums[mid-1]!=target){
                    return mid;
                }
                else{
                    high=mid-1;
                }

            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }

    private int endpoint(int[] nums, int target){
        int low=0;
        int high= nums.length-1;

        while(low<=high){
            int mid=low+(high-low)/2;

            if(nums[mid]==target){
                if(mid==nums.length-1 || nums[mid+1]!=target){
                    return mid;
                }
                else{
                    low=mid+1;
                }

            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return -1;
    }

}