# running time O(log n)
def searchRange(nums, target):
    first, last = -1, -1
    if(nums == None or len(nums) == 0):
        return (first, last)
    low, high = 0, len(nums) -1
    if(nums[low] > target or nums[high] < target):
        return (first, last)
    first = binarySearchFirst(nums, target)
    
    if(first == -1):
        return (first, last)
    last = binarySearchLast(nums, target, first)    
    return (first, last)

#find the first appearance in the array
def binarySearchFirst(nums, target):
    low, high = 0, len(nums) -1
    while(low <= high):
        mid = low + (high-low)//2
        if(nums[mid] == target):
            if(mid == 0 or nums[mid -1] < nums[mid]):
                return mid;
            else:
                high = mid -1
        elif (nums[mid] < target):
            low = mid + 1
        else:
            high = mid -1
    
    return -1

#find the last appearance in the array
def binarySearchLast(nums, target, first):
    low, high = first, len(nums) -1
    while(low <= high):
        mid = low + (high-low)//2
        if(nums[mid] == target):
            if(mid == len(nums) -1 or nums[mid+1] > nums[mid]):
                return mid;
            else:
                low = mid +1
        elif (nums[mid] < target):
            low = mid + 1
        else:
            high = mid -1
    return -1


print(searchRange([1,2,3,3,3,4,5,6], 3))
print(searchRange([1,2,3,3,3,4,5,6], 8))
print(searchRange([1,2,3,3,3,4,5,6], 0))