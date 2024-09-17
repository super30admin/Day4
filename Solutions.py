


#Problem 1: (https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/)

'''
1. I will be using 3 binary searches, first to check if target is in the array, if it is present, call helper functions to get first and last indexes
2. if the target is not in array, return [-1,-1]
'''
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        start=0
        end= len(nums)-1

        while(start<=end):
            mid= (start+ end)//2

            if nums[mid]==target:
                return [self.leftIndex(nums, 0, mid, target), self.rightIndex(nums, mid, end, target)]
            else:
                if nums[mid]> target:
                    end=mid-1
                else:
                    start=mid+1
        return [-1,-1]

    
    def leftIndex(self,nums, start, end, target):

        while(start<=end):
            mid= (start+ end)//2

            if nums[mid]<target:
                start=mid+1
            elif nums[mid-1]<target:
                return mid
            else:
                end=mid-1
        return left

    def rightIndex(self,nums, start, end, target):

        while(start<end):
            mid= (start+end)//2

            if nums[mid]>target:
                end=mid-1
            elif nums[mid+1]>target:
                return mid
            else:
                start=mid+1
        return right


'''
1. used binary search with an extra condition to check if the nums[mid+1] element smaller than nums[mid], If yes, that's the position where array id rotated
'''


#Problem 2: (https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        start=0
        end=len(nums)-1
        if start==end:
            return nums[start]

        if nums[start]<nums[end]:
            return nums[start]

        while start<=end:
            mid= (end+start)//2

            if nums[mid]>nums[mid+1]:
                return nums[mid+1]
            else:
                if nums[mid]<nums[start]:
                    end=mid-1
                else:
                    start=mid+1


'''
1. linear search while checking for conditions at elements before and after the current element
'''
#Problem 3: (https://leetcode.com/problems/find-peak-element/)

class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        
        length=len(nums)-1

        if length==0:
            return 0

        i=0
        while(i<=length):

            if i==0: #handling the edge case
                if nums[i+1]<nums[i]:
                    return 0
            if i==length and nums[i-1]<nums[i]:  #handling the edge case
                return i

            if nums[i]>nums[i-1] and nums[i]>nums[i+1]: #generic case
                return i

            i+=1

        return -1