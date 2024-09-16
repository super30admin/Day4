# Time Complexity: O(logn), where n is the number of elements in the list nums.
# Space Complexity: O(1), we don't use any additional array to store auxiliary data. 
def findPeakElement(nums: list[int]) -> int:
    l = 0
    h = len(nums) - 1
    while l <= h:
        m = l + (h-l)//2
        if (m == 0 or nums[m] > nums[m-1]) and (m == len(nums)-1 or nums[m] > nums[m+1]):
            return m
        elif m != 0 and nums[m-1] > nums[m]:
            h = m - 1
        elif m != len(nums)-1 and nums[m+1] > nums[m]:
            l = m + 1
    return -1

print(findPeakElement([1,2,3,4,5,6]))