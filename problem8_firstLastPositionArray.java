package BinarySearch2;

public class problem8_firstLastPositionArray {

    /*
    Brute Force ---->
        Time Complexity : O(n + n) --> O(n)
        Space Complexity: O(1) //not sure tho.??
     */
    private int[] searchRange(int[] nums, int target) {
        if(nums.length == 1 && nums[0] == target) return new int[]{0,0};

        int[] result = new int[]{-1, -1};

        for(int i = 0 ; i < nums.length ; i++) {
            if(nums[i] == target) {
                result[0] = i;
                break;
            }
        }
        for(int i = nums.length - 1 ; i >= 0 ; i--) {
            if(nums[i] == target) {
                result[1] = i;
                break;
            }
        }
        return result;
    }

    /*
    Binary search Technique ---->
    A)
        Time Complexity: O(log n + log n) ---> O(log n)
        Space Complexity: O(1)
     */
    private int[] searchRange1(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};

        int left = binarySearchLeft(nums, target);
        int right = binarySearchRight(nums, target);

        return new int[] {left, right};
    }
    private int binarySearchLeft(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid] > nums[mid - 1]) return mid; //found leftmost element
                else high = mid - 1; // keep moving left
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    private int binarySearchRight(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == nums.length - 1 || nums[mid] < nums[mid + 1]) return mid; // found rightmost element
                else low = mid + 1; //keep moving right
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /*
    B) With further optimization. If you do not find the left most index or the first index, break your program and do not search for the last index.
        Time Complexity: O(log n + log n) ---> O(log n)
        Space Complexity: O(1)
     */
    private int[] searchRange2(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};

        int left = binarySearchLeft2(nums, target);

        // Optimization 1
        if(left == -1) return new int[]{-1, -1};

        int right = binarySearchRight2(nums, target);

        return new int[] {left, right};
    }
    private int binarySearchLeft2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid] > nums[mid - 1]) return mid; //found leftmost element
                else high = mid - 1; // keep moving left
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    private int binarySearchRight2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == nums.length - 1 || nums[mid] < nums[mid + 1]) return mid; // found rightmost element
                else low = mid + 1; //keep moving right
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /*
    C) With further optimization after part B, what we can do is, instead of performing the binary search on the right with low = 0 (start index of the array),
    we can start searching the last index from or after the first index is found. Therefore, low = firstIndex of the target (mid in this code).
        Time Complexity: O(log n + log n) ---> O(log n)
        Space Complexity: O(1)
     */
    private int[] searchRange3(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};

        int left = binarySearchLeft3(nums, target);

        // Optimization 1
        if(left == -1) return new int[]{-1, -1};

        int right = binarySearchRight3(nums, target);

        return new int[] {left, right};
    }
    private int leftIndex;
    private int binarySearchLeft3(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid] > nums[mid - 1]) {
                    leftIndex = mid;
                    return mid; //found leftmost element
                } else {
                    high = mid - 1; // keep moving left
                }
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    private int binarySearchRight3(int[] nums, int target) {
        int low = leftIndex;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == nums.length - 1 || nums[mid] < nums[mid + 1]) return mid; // found rightmost element
                else low = mid + 1; //keep moving right
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    /*
    D) Check if the target exist or not.
        Time Complexity:
        Space Complexity:
        Will they be same as of the previous case? I guess yes, Am I right?
     */
    private int[] searchRang4(int[] nums, int target) {
        if(nums == null || nums.length == 0) return new int[]{-1, -1};
        if(target < nums[0] || target > nums[nums.length - 1]) return new int[]{-1, -1};
        int left = binarySearchLeft4(nums, target);

        // Optimization 3
        if(left == -1) return new int[]{-1, -1};

        int right = binarySearchRight4(nums, target);

        return new int[] {left, right};
    }
    private int leftIndex4;
    private int binarySearchLeft4(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == 0 || nums[mid] > nums[mid - 1]) {
                    leftIndex4 = mid;
                    return mid; //found leftmost element
                } else {
                    high = mid - 1; // keep moving left
                }
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    private int binarySearchRight4(int[] nums, int target) {
        int low = leftIndex4;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(nums[mid] == target) {
                if(mid == nums.length - 1 || nums[mid] < nums[mid + 1]) return mid; // found rightmost element
                else low = mid + 1; //keep moving right
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        /*
        Sample 1:
            Input: nums = [5,7,7,8,8,10], target = 8
            Output: [3,4]

        Sample 2:
            Input: nums = [5,7,7,8,8,10], target = 6
            Output: [-1,-1]
         */
    }
}
