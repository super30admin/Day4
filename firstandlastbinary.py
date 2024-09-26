#Time complexity :O(logN)
#Space complexity:O(1)
class Solution:
    
    def BinarySearchOne(self,nums,target):
        low=0
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid]==target:
                #Checking if we found the middle element or not
                if (mid==0 or nums[mid]>nums[mid-1]):
                    return mid
                else:
                    #Doing binary search till we find the first occurence of our target
                    high=mid-1
            elif nums[mid]>target:
                high=mid-1
            else:
                low=mid+1
        return -1
    def BinarySearchTwo(self,nums,target):
        low=lowforlast
        high=len(nums)-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid]==target:
                # #Checking if we found the middle element or not
                if (mid==len(nums)-1 or nums[mid]<nums[mid+1]):
                    return mid
                else:
                    #Doing binary search till we find the last occurence of our target
                    low=mid+1
            elif nums[mid]>target:
                high=mid-1
            else:
                low=mid+1
        return -1
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        global lowforlast
        if nums==None or len(nums)==0:
            #Checking for edge cases
            return [-1,-1]
        if nums[0]>target or nums[len(nums)-1]<target:
            return [-1,-1]
        first=self.BinarySearchOne(nums,target)
        if first==-1:
            return [-1,-1]
        lowforlast=first
        last=self.BinarySearchTwo(nums,target)
        return [first,last]
        