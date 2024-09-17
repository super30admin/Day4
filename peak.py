def findPeakElement(nums):
        low = 0
        high = len(nums)-1 
        while low < high: 
            mid = low + ((high - low) // 2)
            if mid == low and nums[mid] < nums[high]: 
                return high
            elif mid == high and nums[mid] < nums[low]:
                return low
            elif nums[mid - 1] < nums[mid] and nums[mid] > nums[mid + 1]:
                return mid
            elif nums[mid-1] < nums[mid]:
                low = mid
            else:
                high = mid            
        return low
nums = [5, 6, 7, 8, 9, 10, 1, 2, 3]
findPeakElement(nums)