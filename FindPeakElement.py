# Time complexity: O(log n)
# Space complexity: O(1)
# Did this run successfully on Leetcode: Yes
# Any problem solving this: No, after class concept was clear

def findPeak(nums):
    low, high = 0, len(nums)-1
    while low <= high:
        mid = (low+high)//2
        if (mid == 0 or nums[mid-1] < nums[mid]) and (mid == len(nums)-1 or nums[mid] > nums[mid+1]):
            return mid
        elif nums[mid] < nums[mid+1]:
            low = mid+1
        else:
            high = mid-1
    return -1


print(findPeak([1, 2, 1, 3, 4, 5, 6]))
print(findPeak([1, 2, 3, 1]))
