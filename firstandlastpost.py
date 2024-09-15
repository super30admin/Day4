class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n = len(nums)
        low, high = 0, n-1
        init = -1
        
        #search for element
        while low <= high:
            mid = (low+high)//2
            if nums[mid] == target:
                init = mid
                break
            elif target < nums[mid]:
                high = mid-1
            else:
                low = mid+1
            
        if init == -1:
            return [-1, -1]
        
        left = right = init
        
        #right boundry search
        low, high = init, n-1
        while low <= high:
            mid = (low+high)//2
            if nums[mid] == target and (mid+1 >= n or nums[mid+1] > nums[mid]):
                right = mid
                break
            elif nums[mid] > target:
                high = mid-1
            else:
                low = mid+1
                
        #left boundry search
        low, high = 0, init
        while low <= high:
            mid = (low+high)//2
            if nums[mid] == target and (mid-1 == -1 or nums[mid-1] < nums[mid]):
                left = mid
                break
            elif nums[mid] < target:
                low = mid+1
            else:
                high = mid-1
                
        return [left, right]