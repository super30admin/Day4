def bins_left(nums, target):
        ''' bins Function definition. '''
        low, high = 0, len(nums)-1
        while low <= high:
            mid = low + (high - low)//2
            if nums[mid] == target:
                if (mid == 0 or nums[mid-1] != target):
                    return mid
                else:
                    high = mid - 1
            elif target > nums[mid]:
                low = mid + 1
            else:
                high = mid - 1
        return -1
def bins_right(idx, nums, target):
    ''' bins Function definition. '''
    low, high = 0, len(nums)-1
    while low <= high:
        mid = low + (high - low)//2
        if nums[mid] == target:
            if mid == len(nums)-1 or nums[mid+1] != target:
                return mid
            else:
                low = mid + 1
        elif target > nums[mid]:
            low = mid + 1
        else:
            high = mid - 1
    return -1
def searchRange(nums: list[int], target: int) -> list[int]:
    # Perform multiple binary searches. Find the first occurences. If it's not the first occurence but there's another one it must exist to the left. Then run another bin search with high set to mid-1 (we stop once the left element is smaller than the element we're looking for)
    # Last occurence of x has a condition that the element after x will be >x but not ==x, while the first occurence has a condition that the element before it will be smaller than x.
    if not nums or not len(nums):
        return [-1,-1]
    if len(nums) == 1:
        if target == nums[0]:
            return [0,0]
        else:
            return [-1,-1]
    elif target < nums[0] or target > nums[-1]:
        return [-1,-1]
    left_occ = bins_left(nums, target) # Run binary search on the left of the array to figure out the first occurence.  
    if left_occ == -1:
        return [-1, -1]
    idx = left_occ
    right_occ = bins_right(idx, nums, target) # Run binary search on the right of the array to figure out the last occurence.
    return [left_occ, right_occ]

print(searchRange([1,2,3,3,3,3,4,5,6,7], 3))
print(searchRange([1,2,3,3,3,3,4,4,4,4,4,5,6,7], 4))
