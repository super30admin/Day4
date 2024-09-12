# Approach:
# Brute Force: Iterate from left and the first 'target' value we hit, represents the left extremity. 
# Now, iterate array from reverse and first 'target' we hit represents the right extremity
# Runs in linear time O(N)

# Optimized Solution : Using Binary Search
# Apply binary search twice, once on left subarray to find lext extremity and repeat on the right side
# While doing so we always check if the middle number is at index 0 for left extremity and if middle = last index for right subarray -- 
# The above denotes we are at the start or end and can be considered as the range extremities
# Also check if element before the middle element is the target, if so continue binary search else retun the middle as the index as array is sorted the target cannot be found any further in left sub array
# Repeat for right sub array
# Base Case: If nums is empty return [-1, -1]

# Time Complexity: O(log(N))
# Space Complexity: O(1)
# Successfully ran on leetcode


class Solution:
    def searchRange(self, nums, target):

        final_range = [-1, -1]
        if len(nums) == 0:
            return final_range

        self.searchRangeHelper(nums, target, 0, len(nums)- 1, final_range, True)
        self.searchRangeHelper(nums, target, 0, len(nums)- 1, final_range, False)

        return final_range


    def searchRangeHelper(self, nums, target, left, right, final_range, left_direction):

        while left <= right:
            middle = (left + right) // 2

            if nums[middle] < target:
                left = middle + 1

            elif nums[middle] > target:
                right = middle - 1

            else:

                if left_direction:

                    if middle == 0 or nums[middle -1] != target:
                        final_range[0] = middle
                        return

                    else:
                        right = middle - 1

                else:

                    if middle == len(nums) -1 or nums[middle + 1] != target:
                        final_range[1] = middle
                        return
                    else:
                        left = middle + 1



        