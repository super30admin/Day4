//Time Complexity : O(logN)
//Space Complexity : O(1)

class FindPeakElement {

    //This method finds peak element in an array
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            //If mid is greater than its previous as well as next element
            if((mid == 0 || nums[mid] > nums[mid-1]) && (mid == nums.length -1 || nums[mid] > nums[mid+1])){
                return mid;
            } else if (nums[mid + 1] > nums[mid]) { //else reduce search space by half by moving to the greater side
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        FindPeakElement find = new FindPeakElement();
        int arr[] = {1,2,3,1};
        System.out.println("Peak in [1,2,3,1] at index "+ find.findPeakElement(arr));
        
        arr = new int[]{1,2,1,3,5,6,4};
        System.out.println("Peak in [1,2,1,3,5,6,4] at index "+ find.findPeakElement(arr));
    }
}

/**
OUTPUT:

Peak in [1,2,3,1] at index 2
Peak in [1,2,1,3,5,6,4] at index 5
 */