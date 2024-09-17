def findMin(nums):  
        low = 0
        high = len(nums)-1
        
        if low == high:
            return nums[low]
        if nums[high]>nums[low]:
            return nums[0]
        
        while low<=high:
            mid = (low+high)//2
            if mid<high and nums[mid+1]<nums[mid]:
                return nums[mid+1]
            if mid>low and nums[mid] <nums[mid-1]:
                return nums[mid]
            if nums[high] > nums[mid]:
                high = mid-1
            else:
                low = mid+1

nums = [5, 6, 7, 8, 9, 10, 1, 2, 3]
findMin(nums)