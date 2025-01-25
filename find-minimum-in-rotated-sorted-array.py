# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

start, end = 0, len(nums) - 1

while start <= end:
    mid = start + ((end - start) // 2)
    if nums[mid] <= nums[-1]:
        end = mid - 1
    else:
        start = mid + 1

return nums[start]