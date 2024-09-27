public class SearchFirstLast {

    // normal binary search
    public int binarySearch(int[] nums, int first, int last, int target){
        while(first<=last){
            int mid = first + (last -first)/2;

            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] > target){
                last = mid-1;
            }
            else{
                first = mid+1;
            }
        }
        return -1;
    }
    // time complexity O(log(n)) -> log n + log n
    public int[] searchRange(int[] nums, int target){
        int[] ans = new int[2];
        ans[0] = -1;
        ans[1] = -1;
        int first = 0;
        int last = nums.length -1;
        // to find the left index 
        while(true){
            int index = binarySearch(nums, first, last, target);
            if(index == -1 || last<0){
                break;
            }
            last = index -1;
            ans[0] = index;
        }

        first = 0;
        last = nums.length -1;
        // to find the right index 
        while(true){
            int index = binarySearch(nums, first, last, target);
            if(index == -1 || first >= nums.length){
                break;
            }
            first = index +1;
            ans[1] = index;
        }

        return ans;
    }
}
