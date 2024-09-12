# Time Complexity : O(lg n)
# Space Complexity : O(1) no additional space
# Did this code successfully run on Leetcode : Yes!
# Any problem you faced while coding this :
#    the case of finding your target i didn't do correctly at first
#       if target = mid there are 2 conditions to handle
#       originally i just handled target = mid AND nothing left or right

# Approach:
# have 1 binary search subroutines, 1 that binary searches left, 1 that goes right
# return [left result, right result]

searchRange = (nums, target) ->
  li = leftMost(nums, 0, nums.length-1, target)
  ri = rightMost(nums, 0, nums.length-1, target)

  [li, ri]

leftMost = (nums, low, high, target) ->
  while low<= high
    mid = Math.floor(low + (high - low)/2)

    if nums[mid] == target
      if mid == 0 or nums[mid-1] != target
        return mid
      high = mid - 1
    else if target < nums[mid]
      high = mid - 1
    else
      low = mid + 1

  -1

rightMost = (nums, low, high, target) ->
  while low<= high
    mid = Math.floor(low + (high - low)/2)

    if nums[mid] == target
      if mid == nums.length-1 or nums[mid+1] != target
        return mid
      low = mid + 1
    else if target < nums[mid]
      high = mid - 1
    else
      low = mid + 1

  -1
