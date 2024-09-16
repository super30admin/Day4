
def findPeakElement(nums):
        n = len(nums)

        if n == 0:
            return -1

        if n == 1:
            return 0

        if nums[0] > nums[1]:
            return 0

        if nums[n-1] > nums[n-2]:
            return n-1
        low = 0 
        high = n - 1



        while low<=high:
            mid = int(low + (high - low)/2)

            if nums[mid] > nums[mid-1] and nums[mid] > nums[mid+1]:
                return mid

            elif nums[mid-1] < nums[mid]:
                low = mid 
            else:
                high = mid 
        return -1

#nums = [1,2,3,1]
nums = [1,2]
print(findPeakElement(nums))