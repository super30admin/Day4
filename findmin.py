# Time Complexity : log(N) Binary Search
# Space Complexity : O(1) no extra memory allocated, only constant variables are used
# 153. Find Minimum in Rotated Sorted Array

def findMin(nums) -> int:
    if len(nums) == 1:
        return nums[0]
    low, high = 0, len(nums) - 1
    while low <= high:
        mid = low + (high-low)//2
        # If we are already in a sorted array return lowest index element
        if nums[low] < nums[high]:
            return nums[low]
        # If mid is smaller than both its neighbors its the lowest number in array
        if (mid == 0 or nums[mid] < nums[mid-1]) and (mid == len(nums)-1 or nums[mid]< nums[mid+1]):
            return nums[mid]
        #Check which side is sorted
        if nums[mid] >= nums[low]: # left side is sorted
            low = mid + 1
        else:
            high = mid - 1
    return nums[mid]

nums= [4,5,6,7,0,1,2]
print(findMin(nums))
