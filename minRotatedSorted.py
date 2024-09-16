# Time Complexity: O(logn), where n is the number of elements in the list nums.
# Space Complexity: O(1), we don't use any additional array to store auxiliary data. 
def minRotatedSorted(nums: list[int]) -> int:
    '''minRotatedSorted Function definition. '''
    # Key observations:
    # 1. The minimum element will be in the unsorted part:
        # a. [8,9,1,2,3,4,5,6,7]
        # b. [3,4,5,1,2]
    # 2. For the smallest element, it will be larger than both it's neighbors.
    if not nums or not len(nums):
        return -1
    if nums[0] < nums[-1]:
        return nums[0]
    l = 0
    h = len(nums)-1
    while l <= h:
        mid = l + (h-l)//2
        if nums[l] <= nums[h]:
            return nums[l]
        if (mid == len(nums)-1 or nums[mid] < nums[mid+1]) and (mid == 0 or nums[mid] < nums[mid-1]):
            return nums[mid]
        elif nums[l] <= nums[mid]:
            l = mid+1
        else:
            h = mid-1
    return -1

print(minRotatedSorted([3,4,5,6,7,8,9,1,2]))
print(minRotatedSorted([8,9,1,2,3,4,5,6,7]))
print(minRotatedSorted([4,5,6,7,0,1,2]))
print(minRotatedSorted([3,4,5,1,2]))
print(minRotatedSorted([11,13,15,17]))
print(minRotatedSorted([2,1]))