class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        # Left number of the target element should be less than target
        # Right Number of the target element should be greater than target
        # Time complexity is O(logN)
        # Space complexity is O(1)
        def getLeftBound(nums,target,low,high):
            while(low <= high):
                mid = (low+high)//2
                if(nums[mid] == target and (mid == low or nums[mid-1] < target)):
                    return mid
                elif(target <= nums[mid]):
                    high = mid-1
                else:
                    low = mid+1
            return -1
        
        def getRightBound(nums,target,low,high):
            while(low <= high):
                mid = (low+high)//2
                if((nums[mid] == target) and (mid == high or nums[mid+1] > target)):
                    return mid
                elif(target < nums[mid]):
                    high = mid-1
                else:
                    low = mid+1
            return -1
        l = getLeftBound(nums,target,0,len(nums)-1)
        r = getRightBound(nums,target,0,len(nums)-1)
        return [l,r]