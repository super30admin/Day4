# Time Complexity : O(lg n)
# Space Complexity : O(1) no additional space
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this :
#   mental hurdle: choosing the side with the dip is a mental leap

# Approach:
# Do a binary search on nums
# Min element will be the mid such that nums[mid-1] > nums[mid] < nums[mid+1]
# if mid isn't min element
#   go right if nums[mid] > nums[high] (because interval [mid, high] is out of order and contains the dip)
#   else go left

findMin = (nums) ->
  low = 0
  high = nums.length-1

  while(low<=high)
    mid = Math.floor(low + (high-low)/2)

    if nums[mid-1] > nums[mid] < nums[mid+1]
      return nums[mid]
    else if nums[mid] > nums[high]
      low = mid + 1
    else
      high = mid - 1

  -1
