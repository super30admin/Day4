class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        lrange = self.leftindex(nums,target)
        if lrange == -1:
            return[-1,-1]
        else:
            rrange = self.rightindex(nums,target)
            return [lrange,rrange]

    def leftindex(self,nums,target):
        left,right = 0, len(nums)-1
        l = -1
        while left <= right :
            mid = left + (right-left) //2
            if nums[mid] == target:
                l = mid
                right = mid-1
            elif nums[mid] < target:
                left = mid+1
            else:
                right = mid-1
        return l
                
    def rightindex(self,nums,target):
        left,right = 0, len(nums)-1
        r = -1
        while left <= right :
            mid = left + (right-left) //2
            if nums[mid] == target:
                r = mid
                left = mid+1
            elif nums[mid] < target:
                left = mid+1
            else:
                right = mid-1
        return r