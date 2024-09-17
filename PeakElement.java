//Runtime: log(n)
//Space Complexity: O(1)
//Passed on Leetcode
//Concept was somewhat difficult, coding was good


public class FirstLastElement {
    public int findPeakElement(int[] nums) {
        //null or empty
        if(nums == null || nums.length == 0){
            return -1;
        }

        if(nums.length == 1){  //[1] index is 0
            return 0;
        }

        int low = 0;
        int high = nums.length - 1;

        while(low <= high){
            int mid = low + (high - low)/2;

            //if low is peak
            if(mid == 0 && (nums[mid + 1] < nums[mid])){  //if mid first element and is the peak
                return mid;
            }

            //if high is peak
            if(mid == nums.length -1 && (nums[mid -1] < nums[mid])){ //if mid last and is peak
                return mid;
            }


            //if mid is the peak and not first or last element
            if(nums[mid] > nums[mid + 1] && nums[mid] > nums[mid - 1] && mid != 0 && mid != nums.length - 1){
                return mid;
            }
            else if(nums[mid + 1] > nums[mid]){  //if right is bigger
                low = mid + 1;
            }
            else{
                high = mid - 1;    //if left is bigger
            }
        }
        return -1;
    }
}