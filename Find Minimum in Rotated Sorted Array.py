# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


def findMin(nums):
    if nums == None or len(nums) == 0:
        return 0
    
    low = 0
    high = len(nums)-1

    while(low <= high):
        if nums[low] <= nums[high]: # already sorted
            return nums[low]
        mid = low + (high -low) // 2
        if (mid == 0  or nums[mid] < nums[mid-1]) and (mid == len(nums) - 1 or nums[mid] < nums[mid+1]):
            return nums[mid]

        elif nums[low] <= nums[mid]:
            low = mid + 1  #goto unsorted side
        
        else:
            high = mid - 1
    return -1

nums = [2,3,4,5,0, 1]
print(findMin(nums))