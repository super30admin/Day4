class firstandLast {
    public  int[] searchRange(int[] nums, int target) {
        int result[] = new int[2];
        result[0] = findFirst(nums,target);
        result[1] = findLast(nums,target);
        return result;
    }

    public int findFirst(int[] nums,int target){
        int index = -1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                index = mid;
                high = mid-1;
            }

            else if(nums[mid]<target){
                low = mid+1;
            }else if(nums[mid]>target){
                high = mid-1;
            }
        }
        return index;
    }
    public int findLast(int[] nums,int target){
        int index = -1;
        int low = 0;
        int high = nums.length-1;
        while(low<=high){
            int mid = low + (high-low)/2;
            if(nums[mid]==target){
                index = mid;
                low = mid+1;
            }
            else if(nums[mid]<target){
                low = mid+1;
            }else if(nums[mid]> target){
                high = mid-1;
            }
        }
        return index;
    }
    public static void main(String[] args){
        int [] arr = {5,7,7,8,8,10};
        int target = 8;
        firstandLast f = new firstandLast();
          f.searchRange(arr,target);
    }
}