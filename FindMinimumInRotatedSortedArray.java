public class FindMinimumInRotatedSortedArray {

    //Time Complexity-0(log n)
    //Space Complexity- 0(1)
    //Did it successfully run on leetcode : Yes
    //Did you face any problem while: No

    //I am assuming that there are 3 types of test cases that can occur. 1st- the array is sorted. Eg=[1,2,3,4,5]
    //2nd- both sides of array are sorted from mid. Eg=[3,4,5,1,2] or 3rd type where one part is sorted and 2nd is not.
    //Eg=[5,1,2,3,4]. There can be multiple cases of Case 3. But only 1 case for case 1 & 2. So while taking various examples
    //of test case 3, it is found that the minimum element always lies in the unsorted array. Hence, we can apply binary
    //search and neglect the sorted array and always try to search the min in unsorted. For cases 1 and 2, I have handled
    //the case in 1st if condition inside my while loop where it will check if the array is sorted whenever the array is halved
    //and return the low if ever the condition is true.

    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length-1;
        while(low <= high){
            if(nums[low] < nums[high]){
                return nums[low];
            }
            int mid = low + (high - low) / 2;
            if((mid == 0 || nums[mid -1] > nums[mid]) && (mid == nums.length -1 || nums[mid] < nums[mid + 1])){
                return nums[mid];
            }
            else if(nums[low] <= nums[mid]){
                low = mid + 1;
            }
            else{
                high = mid - 1;
            }
        }
        return 12345;
    }
}
