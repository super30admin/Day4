#Time complexity = 0(logn) + 0(logn) ~0(logn)
#Space Complexity = No extra space required.
class Solution(object):
    
    def find_first_index(self,nums,target):
            low = 0
            high = len(nums) - 1

            while low <= high:
                mid = int(low + (high - low)/2)
                if ((mid == 0 or nums[mid] > nums[mid -1]) and nums[mid] == target):
                    return mid
                if nums[mid] < target:
                    low = mid + 1
                elif nums[mid] >= target:
                    high = mid - 1
            return -1
   
    def find_last_index(self,nums,target):
        n = len(nums)
        low = 0 
        high = n - 1

        while low<=high:
            mid = int(low +(high - low)/2)
            if (mid == n-1 or nums[mid] < nums[mid+1]) and nums[mid] == target:
                return mid
            if nums[mid] <= target:
                low = mid + 1
            else:
                high = mid - 1

    def searchRange(self, nums, target):
        n = len(nums)
        if n == 0:
            return -1,-1
        
        if target < nums[0] or target > nums[-1]:
            return -1,-1
        index1 = self.find_first_index(nums,target)

        if index1 == -1:
            return -1,-1
        
        index2 = self.find_last_index(nums,target)
        print(index1)
        return index1,index2
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        