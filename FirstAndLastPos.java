//Time Complexity : O(logN)
//Space Complexity : O(1)

class FirstAndLastPos {

    //This method will first look for first and last occurance of the target
    public int[] searchRange(int[] nums, int target) {
        //Get the first occurance of the target
        int first = binarySearchLeft(nums, target);

        //If there is no first occurance found, we know that the array 
        //does not have the target and we exit returning [-1,-1]
        if(first == -1) {
            return new int[] {-1,-1};
        }
        //If first occurance is found, check the last occurance.
        //We reduce the search space by taking starting index as the first occurance
        int last = binarySearchRight(nums, target, first);
        return new int[] {first,last};
    }
    
    //This method will traverse the array and find the first occurance of target
    public int binarySearchLeft(int nums[], int target) {
        int low = 0;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;

            if(nums[mid] == target) {
    
                //If target is found at mid check if it is the first element
                // OR if it does not have target element one previous to itself                
                if(mid == low || nums[mid-1] != target)
                    return mid;

                //If not, check in the first half
                high = mid - 1;

            } else if(nums[mid] > target) {  //else reduce the search space by half
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //This method will traverse the array and find the second occurance of target
    public int binarySearchRight(int nums[], int target, int first) {

        //Since first occurance is found we reduce the search space by starting with the index of first occurance
        int low = first;
        int high = nums.length - 1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                
                //If target is found at mid check if it is the last element
                // OR if it does not have target element one after itself
                if(mid == high || nums[mid+1] != target)
                    return mid;

                //If not check in the second half
                low = mid + 1;

            } else if(nums[mid] > target) { //else reduce the search space by half
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        FirstAndLastPos find = new FirstAndLastPos();
        int arr[] = {5,7,7,8,8,8,10};
        int res[] = find.searchRange(arr,8);
        System.out.println("Element 8 found at ["+ res[0] +","+res[1]+"]");
        res = find.searchRange(arr,6);
        System.out.println("Element 6 found at ["+ res[0] +","+res[1]+"]");
    }
}

/**
OUTPUT:
Element 8 found at [3,5]
Element 6 found at [-1,-1]
 */