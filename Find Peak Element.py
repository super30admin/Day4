# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach


def peak(nums):
    if nums == 0 or len(nums) == 0:
        return -1

    low = 0
    high = len(nums) - 1
    while (low <= high):
        mid = low + (high - low ) // 2
        if (mid == 0 or nums[mid] > nums[mid-1]) and (mid == len(nums)-1 or nums[mid] >= nums[mid+1]):
            return mid
        #move right
        elif (mid > 0 and nums[mid-1] > nums[mid]):
            high = mid - 1
        #move left
        else:
            low =  mid + 1
    return mid

nums = [1,2,3,1]
print(peak(nums))
