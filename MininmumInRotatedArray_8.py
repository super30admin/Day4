# Time complexity - O(log(N))
# passed all tests in leetcode
# First I tried with comparing low and mid but couldnt come to a solution so tried with high and mid comparision
# and it worked, finding out why couldnt i work with low and mid.
def findMin(self, nums):
    low = 0
    high = len(nums) - 1
    while low < high:
        mid = low + (high - low) // 2
        if nums[mid] < nums[high]:
            # the minimum is in the left part, so search in left subarray
            high = mid
        elif nums[mid] > nums[high]:
            # the minimum is in the right part, serach in right subarray
            low = mid + 1
    return nums[low]