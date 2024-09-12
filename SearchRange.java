class Solution{
public static int[] searchRange(int[] nums, int target) {
    int firstAppearance = -1;
    int lastAppearance = -1;
    int[] position = new int[2];
    int start = 0;
    int end = nums.length - 1;
    while (start <= end) {
        int mid = start + (end - start) / 2;
        if (nums[start] == target) {
            firstAppearance = start;
        }
        if (nums[end] == target) {
            lastAppearance = end;
        }
        if (nums[mid] > target) {
            end = mid - 1;
        } else if (nums[mid] < target) {
            start = mid + 1;
        } else {
            if (firstAppearance == -1) {
                start++;
            } else if (lastAppearance == -1) {
                end--;
            } else {
                break;
            }
        }
    }
    position[0] = firstAppearance;
    position[1] = lastAppearance;
    return position;
}

}
