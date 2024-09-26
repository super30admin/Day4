def findMin(self, nums):
    """
    :type nums: List[int]
    :rtype: int
    """
    low = 0
    high = len(nums) - 1

    while low < high:
        mid = low + (-low + high) / 2
        if nums[mid] < nums[mid - 1]:
            return nums[mid]
        if nums[mid] > nums[mid + 1]:
            return nums[mid + 1]
        if nums[mid] < nums[high]:
            high = mid
        else:
            low = mid + 1
    return nums[low]

# time complexity- O(logn)
# space complexity- O(1)