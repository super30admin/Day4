# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

start, end = 0, len(nums) - 1

while start <= end:
    mid = start + ((end - start) // 2)

    if nums[mid] < target:
        start = mid + 1
    else:
        end = mid - 1

if start == len(nums) or nums[start] != target:
    return [-1, -1]

leftmost_idx = start

end = len(nums) - 1

while start <= end:
    mid = start + ((end - start) // 2)

    if nums[mid] <= target:
        start = mid + 1
    else:
        end = mid - 1

return [leftmost_idx, end]