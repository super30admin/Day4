//Time=O(log(n)) same function with small variation in condn is called twice
//Space=O(1)
public class Solution {
public int[] searchRange(int[] nums, int target) {
    int[] result = new int[2];
    result[0] = find1(nums, target);
    result[1] = find2(nums, target);
    return result;
}

private int find1(int[] nums, int target){
    int i = -1;
    int start = 0;
    int end = nums.length - 1;
    while(start <= end){
        int mid = (start + end) / 2;
        if(nums[mid] >= target){
            end = mid - 1;
        }else{
            start = mid + 1;
        }
        if(nums[mid] == target) 
            i = mid;
    }
    return i;
}

private int find2(int[] nums, int target){
    int i = -1;
    int start = 0;
    int end = nums.length - 1;
    while(start <= end){
        int mid = (start + end) / 2;
        if(nums[mid] <= target){
            start = mid + 1;
        }else{
            end = mid - 1;
        }
        if(nums[mid] == target) 
            i = mid;
    }
    return i;
}
}
