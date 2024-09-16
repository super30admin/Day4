
public class FindPeek {
   
    //edge case
    if(nums == null || nums.length == 0) return -1;
    int low = 0; int high = nums.length -1;
    while(low <= high){
        //stack overflow
        int mid = low + (high - low) / 2;
        if(mid == nums.length || mid nums[mid] > nums[mid + 1] && mid ==0 ||nums[mid]>nums[mid-1] ){
            return mid;
        }

        else if(mid > 0 && nums[mid - 1] > nums[mid]){
            high = mid - 1;
        }
        else{
            low = mid + 1;
        }
    }
    return -1;
}