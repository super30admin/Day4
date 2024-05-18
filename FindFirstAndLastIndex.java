class FindFirstAndLastIndex {
    public int[] searchRange(int[] nums, int target) {
        int first = getFirstIndex(nums,target);
        if(first ==-1){
            return new int[]{-1,-1};
        }
        int last = getLastIndex(nums,target);
        return new int[]{first,last};
    }
    private int getFirstIndex(int[] nums, int target){
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low +(high-low)/2;
            if(nums[mid]==target){
                if(mid==0 ||nums[mid-1]!=target){
                    // we are using the mid ==0 so that when mid is 0 it will not thorw error. we can we mid==low
                    return mid;
                }else{
                    high = mid -1;
                }
            }else if(target<nums[mid]){
                high = mid-1;
            }else{
                low = mid +1;
            }
        }
        return -1;
    }

    private int getLastIndex(int[] nums, int target){
        int low =0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low +(high-low)/2; //Using this to avoid integer overflow
            if(nums[mid]==target){
                if(mid==high || nums[mid+1]!=target){
                    // we are using the mid ==0 so that when mid is 0 it will not thorw error. we can we mid==high(i.e the last element)
                    return mid;
                }else{
                    low = mid+1;
                }
            }else if(target<nums[mid]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return -1;
    }
}