/*
Time Complexity = O(log n)
Space Complexity = O(1)
Solved on leetcode? = yes

Approach: 
divide the problem into two parts: first find the first occurence and then the second
apply binary search to find the first occurence. once the element is found keep scanning the
left half to find the very first occurence
before jumping to find the last occurence check whether the number exists at all of not? 
if not directly return -1 else check if the very last element of the array is the target?
if not then apply binary search.
 */
class Solution {
    int binarySearchFirst(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                if(mid>0 && nums[mid-1] != nums[mid]) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
            else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    int binarySearchLast(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if(nums[mid] == target) {
                if(mid<nums.length - 1 && nums[mid+1] != nums[mid]) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
            else if(nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if(nums.length > 0 && nums[0] == target) {
            res[0] = 0;
        } else {
            res[0] = binarySearchFirst(nums, target);
        }
        if(res[0] == -1) {
            res[1] = -1;
        }
        else if(nums.length > 0 && nums[nums.length - 1] == target) {
            res[1] = nums.length - 1;
        } else {
            res[1] = binarySearchLast(nums, target);
        }
        return res;
    }
}