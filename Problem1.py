# Time complexity: O(log n)
# Space complexity: O(1)
# Did this code successfully run on Leetcode : yes
# Any problem you faced while coding this : No

# binary search till finding first element
# then binary search again from first element to find last element

def binarySearchFirst(self, nums, low, high, target):
    while low <= high:
        mid = low + (high - low) // 2
        if nums[mid] == target:
            # see if mid  is first  idx
            if mid == 0 or nums[mid]!= nums[mid - 1]:
                return mid
            else:
                high = mid - 1
        elif mid > 0 and nums[mid] > target:
            high = mid - 1
        else:
            low = mid + 1
    return -1

def binarySearchLast(self, nums, low, high, target):
    
    while low <= high:
        
        mid = low + (high - low) // 2
        if nums[mid] == target:
            # see if mid  is last idx
            if mid == len(nums) -1 or nums[mid]!= nums[mid + 1]:
                return mid
            else:
                low = mid +1
        elif nums[mid] < target:
            low = mid + 1
        else:
                high = mid - 1  
    return -1

def searchRange(self, nums: List[int], target: int) -> List[int]:
    if not nums:
        return [-1,-1]

    low = 0
    high = len(nums) - 1
    if target < nums[low] or nums[high]< target:
        return [-1, -1]
    
    first = self.binarySearchFirst(nums, low, high, target)
    if first == -1:
        return [-1, -1]

    last = self.binarySearchLast(nums, first, high, target)
    return [first, last]