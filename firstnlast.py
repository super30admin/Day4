class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if(len(nums) == 0):
            return [-1,-1]
        if (target < nums[0] or target > nums[len(nums) - 1]):
            return [-1,-1]
        first = self.bsleft(nums,target)
        if(first == -1):
            return [-1,-1]
        last = self.bsright(nums,target)
        return [first,last]

        
    def bsleft(self,nums,target):
        low = 0
        high = len(nums) - 1
        while(low<=high):
            mid = int(low + (high - low)/2)
            if(nums[mid]==target):
                if(mid == 0 or nums[mid-1]<nums[mid]):
                    return mid
                else:
                    high = mid -1
            elif(target < nums[mid]):
                high = mid -1
            else:
                low = mid + 1
        return -1
    
    def bsright(self,nums,target):
        low = 0
        high = len(nums) - 1
        while(low<=high):
            mid = int(low + (high - low)/2)
            if(nums[mid]==target):
                if(mid == len(nums) -1 or nums[mid+1]>nums[mid]):
                    return mid
                else:
                    low = mid + 1
            elif(target < nums[mid]):
                high = mid -1
            else:
                low = mid + 1
        return -1