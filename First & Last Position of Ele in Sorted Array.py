# Time Complexity : O(log n)
# Space Complexity : O(1)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach
def searchRange(nums,target):
    if nums == None or len(nums) == 0:
        return [-1,-1]
    n = len(nums)
    if nums[0] > target or nums[n-1] < target:
        return [-1,-1]

    first = binarySearchFirst(nums,target)
    if first == -1:
        return [-1,-1]
    last = binarySearchLast(nums,first,n-1,target)
    return [first,last]

def binarySearchFirst(nums,target):
    low =0
    high = len(nums)-1
    while low<=high:
        mid =low + (high - low) // 2
        if nums[mid] == target:
            if mid == 0 or nums[mid] > nums[mid-1]:
                return mid
            else:
                high = mid -1

        elif nums[mid] < target:
            low = mid + 1

        else:
            high = mid - 1
    return -1

def binarySearchLast(nums,low,high,target):
    while low <= high:
        mid = low + (high - low) // 2
        if nums[mid] == target:
            if(mid == len(nums) - 1 or nums[mid] < nums[mid+1]):
                return mid
            else:
                low = mid + 1 #move to the right
        elif nums[mid] < target:
            low = mid + 1
        else:
            high = mid -1
    return -1


nums = [5,7,7,8,8,10]
target = 8
print(searchRange(nums,target))