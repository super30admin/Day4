# Time Complexity : log(N) Binary Search on nums
# Space Complexity : O(1) no extra memory allocated, only constant variables are used
# 162. Find Peak Element

def findPeakElement(nums) -> int:
    if len(nums) == 1:
        return 0
    low, high = 0, len(nums) - 1
    while low <= high:
        mid = low + (high - low)//2
        if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums)-1 or nums[mid] > nums[mid + 1]):
            return mid
        if nums[mid] < nums[mid+1]:
            low = mid + 1
        else:
            high = mid - 1


nums = [1,2,1,3,5,6,4]
print(findPeakElement(nums))