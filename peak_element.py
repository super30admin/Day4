#162. Find Peak Element
#time = 
#space = 

def peak_element(nums):
    left , right = 0, len(nums) -1

    while left<right:
        mid = (left+right) // 2

        if nums[mid] < nums[mid+1]:
            left = mid + 1
        else:
            right = mid
    return left

nums = [1, 2, 1, 3, 5, 6, 4]
print(peak_element(nums))

