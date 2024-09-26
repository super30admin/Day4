//Time Complexity : O(logN)
//Space Complexity : O(1)

class MinInRotated {

    //This method finds the minimum element from a sorted rotated array
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        
        //If the array is rotated n times
        //Or if array contains only one element, minimum is present at 0th index
        if(nums[low] < nums[high] || nums.length == 1) return nums[0];
        
        while(low <= high) {
            int mid = low + (high - low)/2;
            
            //If the middle element is the greater than next element it means, next element is the minimum
            if(nums[mid] > nums[mid+1]) 
                return nums[mid+1]; 
            //If the middle element is the smaller than previous element it means, mid element is the minimum
            if(nums[mid] < nums[mid-1])
                return nums[mid];
            else if(nums[mid] > nums[low]) { //else move to the direction of unsorted part of array
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        MinInRotated find = new MinInRotated();
        int arr[] = {3,4,5,1,2};
        System.out.println("Min in {3,4,5,1,2}: "+ find.findMin(arr));
        
        arr = new int[]{4,5,6,7,0,1,2};
        System.out.println("Min in {4,5,6,7,0,1,2}: "+ find.findMin(arr));

        arr = new int[]{11,13,15,17};
        System.out.println("Min in {11,13,15,17}: "+ find.findMin(arr));
    }
}

/**
OUTPUT:
Min in {3,4,5,1,2}: 1
Min in {4,5,6,7,0,1,2}: 0
Min in {11,13,15,17}: 11
 */