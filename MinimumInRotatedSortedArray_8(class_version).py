def findMin(nums):
    low = 0
    high = len(nums) - 1
    while low <= high:
        mid = low + (high - low) // 2  # calculating mid
        if nums[low] < nums[high]: return nums[low] # if the array is sorted return nums[low]
        if ((mid == high or nums[mid] < nums[mid + 1]) and (mid == low or nums[mid] < nums[mid - 1])):
            # check if the mid is the minimum by checking both sides of elements of mid
            # And also verify the condition if mid is equal to high or low.
            # total there are 6 conditions to verify in above command.
            return nums[mid]
        elif nums[mid] < nums[high]:
            # if mid is less than high then right array is sorted, so find min in left subarray.
            high = mid - 1
        else:
            # if mid is greater than low then left array is sorted, so find min in right subarray.
            low = mid + 1
    return -1

fm = findMin([5,7,9,1,2,4])
print(fm)