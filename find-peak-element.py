# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

if len(nums) == 1:
    return 0
if nums[0] > nums[1]:
    return 0
if nums[-1] > nums[-2]:
    return len(nums) - 1

start, end = 1, len(nums) - 2

while start <= end:
    mid = start + ((end - start) // 2)
    if nums[mid-1] < nums[mid] > nums[mid+1]:
        return mid
    if nums[mid-1] > nums[mid] < nums[mid+1]:
        end = mid - 1
    
    if nums[mid-1] < nums[mid] < nums[mid+1]:
        start = mid + 1
    
    if nums[mid-1] > nums[mid] > nums[mid+1]:
        end = mid - 1