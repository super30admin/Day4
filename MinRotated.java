public class MinRotated {
    // time complexity O(log(n))
    public int findMin(int[] nums) {
        int first = 0;
        int last = nums.length-1;

        int min = nums[first];
        // no rotation
        if(nums[first] < nums[last]){
            return min;
        }

        while(first<last){
            int mid = first + (last - first)/2;
            // right side is sorted, min might be on th left or mid
            if(nums[first] >= nums[mid] && nums[mid] < nums[last]){
                last = mid;
                continue;
            }
            // left side is sprted, min might be on the right sub array
            if(nums[first] < nums[mid] && nums[mid] >= nums[last]){
                first = mid;
                continue;
            }
            // if the sub array only has 2 numbers
            if(last - first == 1){
                int temp_min = Math.min(nums[first],nums[last]);
                if(temp_min < min){
                    min = temp_min;
                }
                break;
            }
            // check if the min in this sub array is lower than the previous min we got
            if(nums[first] < min){
                min = nums[first];
            }
            if(first == last){
                break;
            }
            
        }
        return min;
    }
}
