def binarySearchleft(nums, target, l, h):
    while(l<=h):
        mid = (l + h) // 2
        if nums[mid] == target:
            if mid==0:
                return mid
            if nums[mid]>nums[mid-1]:
                return mid
            else:
                h = mid - 1
        elif nums[mid]>target:
            h= mid - 1
        else:
            l = mid + 1    
    return -1

def binarySearchright(nums, target, l, h):
    while(l <= h):
        mid = (l + h) // 2
        if nums[mid] == target:
            if mid == len(nums)-1:
                return mid
            if nums[mid] < nums[mid+1]:
                return mid
            else:
                l = mid + 1
        elif nums[mid] > target:
            h = mid - 1
        else:
            l = mid + 1
    return -1


def searchRange(nums, target):
    result = [-1, -1]
    result[0]= binarySearchleft(nums,target,0,len(nums)-1)
    result[1] = binarySearchright(nums,target,0,len(nums)-1)
    return result

nums = [5,7,7,8,8,10]
target = 6

print(searchRange(nums, target))