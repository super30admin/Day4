# Approach
# Get start and end Indexes of target value
# we need to perform binary for start and end index two times
# for start index in mid is target if mid-1 is same as mid then move left else return mid. if mid != target then mid>target move left else right
# Dor end index we need to check the mid+1 similar to mid then move right else return.

# Complexities
# Time Complexity: O(log n + log n). =O(2 log n) = O(log n)
# space Complexity : O(1) + O(2 log n) recursive stack space




from typing import List


class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if len(nums) == 0:
            return [-1, -1]
        else:
            return [self.start_index(nums, target, 0, len(nums) - 1), self.end_index(nums, target, 0, len(nums) - 1)]

    def start_index(self, nums, target, low, high):
        if (high - low) > 0:
            mid = int((low + high) / 2)
            if nums[mid] == target:
                if mid == low:
                    return low
                else:
                    if nums[mid - 1] == target:
                        return self.start_index(nums, target, low, mid - 1)
                    else:
                        return mid
            elif nums[mid] > target:
                return self.start_index(nums, target, low, mid - 1)
            else:
                return self.start_index(nums, target, mid + 1, high)
        else:
            if nums[low] == target:
                return low
            else:
                return -1

    def end_index(self, nums, target, low, high):
        if (high - low) > 0:
            mid = int((low + high) / 2)
            if nums[mid] == target:
                if nums[mid + 1] == target:
                    return self.end_index(nums, target, mid + 1, high)
                else:
                    return mid
            elif nums[mid] > target:
                return self.end_index(nums, target, low, mid - 1)
            else:
                return self.end_index(nums, target, mid + 1, high)
        else:
            if nums[low] == target:
                return low
            else:
                return -1


s = Solution()
print(s.searchRange([5,7,7,8,8,10],8))