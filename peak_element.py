"""
time complexity: O(log n)
space complexity: O(1)
"""


def peak_element(nums):
    l, r = 0, len(nums) - 1

    while l <= r:
        mid = (l + r) // 2
        if (mid == 0 or nums[mid - 1] < nums[mid]) and (mid == len(nums) - 1 or nums[mid] > nums[mid + 1]):
            return mid
        elif nums[mid] < nums[mid + 1]:
            l = mid + 1
        else:
            r = mid - 1


nums = [1, 2, 3, 1]
print(
    f"the peak element is {nums[peak_element(nums)]} at index {peak_element(nums)}")
