class Solution:
    def searchRange(self, nums, target):

        # find left index first set a flag that we are setting flag for left side of the nums
        left_index = self.helper_binary_search(nums, target, True)
        # find left index, and if left index is last element of nums or not equal to target, no point in proceeding
        if left_index == len(nums) or nums[left_index] != target:
            return [-1, -1]

        # repeat the same search for right hand side of the target element if present in right side of the array
        return [left_index, self.helper_binary_search(nums, target, False) - 1]

    def helper_binary_search(self, nums, target, left):
        low = 0
        high = len(nums)
        # simple binary search for finding the index of an element as required
        while low < high:
            mid = (low + high) // 2

            if nums[mid] > target or (left and target == nums[mid]):
                high = mid
            else:
                low = mid + 1

        return low

my_range = Solution()
print(my_range.searchRange([5,8,8,9,10,11],8))

'''
Time complexity O(log(n)) - n is the number of elements in array
space complexity O(1) 
'''