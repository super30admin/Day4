def search(nums, target):
     # finding low and high index
    low = 0
    high = len(nums) - 1
    while low <= high:
        mid = low + (high - low) // 2 # calculating mid index
        if nums[mid] == target: # if target is equal to mid then return mid
            return mid
        elif nums[mid] >= nums[low]:
            # if mid is greater than low then
            # left array is sorted move towards left.
            if nums[low] <= target and nums[mid] >= target:
                # check if target lies in between sorted left part of array
                # if yes then do the binary search in sorted left part
                # else look for target in right half
                high = mid-1
            else:
                low = mid+1
        else: # if mid is less than high then right array is sorted,
            # move towards right
            if nums[mid] <= target and nums[high] >= target:
                # check if target lies in sorted right half
                # if yes then do the binary search in right part
                # else look for target in left half
                low = mid+1
            else:
                high = mid-1
    return -1

s = search([4,5,6,8, 0,1,2], 5)
print(s)