def binaryFirst(nums):
    low = 0
    high = len(nums)-1
    while(low<=high):
        mid = low + (high-low)//2
        if nums[mid]==target:
            if mid==low or nums[mid]>nums[mid-1]:
                return mid
            else:
                high = mid - 1
        elif target<nums[mid]:
            high = mid - 1
        else:
            low = mid + 1
    return -1
def binaryLast(nums):
    low = 0
    high = len(nums)-1
    while(low<=high):
        mid = low + (high-low)//2
        if nums[mid]==target:
            if mid==high or nums[mid]<nums[mid+1]:
                return mid
            else:
                low = mid + 1
        elif target<nums[mid]:
            high = mid - 1
        else:
            low = mid + 1
    return -1
first = binaryFirst(nums)
last = binaryLast(nums)
return [first,last]
            