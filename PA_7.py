#Leetcode 34 : Find First and Last Position of Element in Sorted Array
#Time Complexity : O(2logn) = O(logn)
#Space Complexity : O(1)
class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        ans = [-1,-1]
        if not nums:
            return ans
        ans[0] = self.getLeftMostIndex(nums,0,len(nums)-1,target)
        #print(ans[0])
        if ans[0] == -1:
            return ans
        ans[1] = self.getRightMostIndex(nums,ans[0],len(nums)-1,target)
        return ans
        
    def getLeftMostIndex(self,nums,low,high,target):
        while low <= high:
            mid = (low+high)//2
            if nums[mid] == target:
                if mid == 0 or nums[mid-1] != nums[mid]:
                    return mid
                else:
                    high = mid - 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

    def getRightMostIndex(self,nums,low,high,target):
        while low <= high:
            mid = (low+high)//2
            if nums[mid] == target:
                if mid == len(nums) - 1 or nums[mid+1] != nums[mid]:
                    return mid
                else:
                    low = mid + 1
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1