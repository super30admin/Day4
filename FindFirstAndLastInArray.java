class FindFirstAndLastInArray {
    public int[] searchRange(int[] nums, int target) {
        
        //check if the nums array is null or empty
        if(nums == null || nums.length == 0) {
            return new int[]{-1,-1};
        }
        //check if the target is not present in the array.
        if(target < nums[0] || target > nums[nums.length -1]) {
            return new int[]{-1,-1};
        }
        
        int left  = binarySearchLeft(nums, target);
        if(left == -1) {
            return new int[]{-1,-1};
        }
            
        int right = binarySearchRight(nums, target);
        return new int[]{left,right};
        }
    
    private int binarySearchLeft(int[] arr, int target) {
        int low  = 0, high = arr.length -1;
        while(low <=high) {        
        int mid = low + (high-low)/2;
            if (target == arr[mid]) {
                //check if mid-1/left of mid is not target as well
                if( mid ==0 || arr[mid -1] != target){
                    return mid; //we need to just return the index in this problem as given.
                }else{
                    high = mid-1;
                }
            }
            else if (target > arr[mid]){
                low = mid +1;
            } else {
                high = mid -1;
            }
        }//end while loop
        return -1;
       }
    
    private int binarySearchRight(int[] arr, int target) {
        int low = 0 , high = arr.length-1;
        while(low <= high) {
            int mid = low + (high -low)/2;
            if(target == arr[mid]) {
                if(mid == arr.length-1 || arr[mid +1] != target) {
                    return mid;
                } else {
                    low = mid +1;
                }
            } else if(target > arr[mid]) {
                low = mid +1;
            } else {
                high = mid -1;
            }
        }
        return -1;
    }
    }
    
