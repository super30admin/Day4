"""
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
Description:
This problem was asked at LinkedIn. Given an sorted array, find the first and last position of a given element.
Your algorithm's runtime complexity must be O(log n). If the target is not found in the array, return [-1, -1].
Input: nums = [5,7,8,9,9,10], target = 9

Approach-We will do two binary searches, first will be for finding the first index and in the second will be finding
the last index. In the first binary search we will see that if the mid is the target and if the element on the left side is smaller than
the target then we will be sure that mid is the firstposition of target, else if the element on the left side is equal to target we will keep moving
left that is high=mid-1; if the nums[mid]>target , we know that the first position will lie on the left side so we do high =mid-1, else
the target will be on the right side so we will ove right. The second binary search will start from low =firstindex and will be mirror image
of the first binary search.

Time Complexity: O(logn)
Space Complexity: O(1) we are not using any auxilary data structure
"""

class Solution:

    def firstandlastpositionofTarget(self, nums, target):

        if not nums or len(nums)==0 or target<nums[0] or target > nums[len(nums)-1]:
            return [-1,-1]
        firstIndex=self.binarysearchFirst(nums,target)
        if firstIndex==-1:
            return [-1,-1]
        lastIndex = self.binaryseaarchTwo(nums, target, firstIndex)
        if lastIndex==-1:
            return [-1,-1]
        return [firstIndex, lastIndex]

    def binarysearchFirst(self, nums, target):
        low=0
        high=len(nums)-1
        while low<=high:
            mid=(low+high)//2
            if nums[mid]==target:
                if mid==0 or nums[mid-1]<nums[mid]:
                    return mid
                else:
                    high=mid-1 ###keep moving left
            elif nums[mid]>target:
                high=mid-1
            else:
                low= mid+1
        return -1

    def binaryseaarchTwo(self, nums, target, firstIndex):
        low = firstIndex
        print("the first index called from function two is", low)
        high = len(nums) - 1
        while low <= high:
            mid = (low + high) // 2
            if nums[mid] == target:
                if mid == len(nums)-1 or nums[mid + 1] > nums[mid]:
                    return mid
                else:
                    low = mid + 1  ###keep moving right
            elif nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
        return -1

        # low=0
        # high=len(nums)-1
        #
        # ##binary search 1- to find the first index
        #
        # while(low<=high):
        #     mid = (low + high) // 2
        #     print(mid)
        #     if nums[0] == target:
        #         firstindex=0
        #     if nums[mid]==target:
        #         if nums[mid-1]<nums[mid]:
        #             firstindex=mid
        #         else:
        #             high=mid-1
        #
        # while(low<=high):
        #     mid=(low+high)//2
        #     print(mid)
        #     if nums[len(nums)-1]==target:
        #         lastindex=len(nums)-1
        #     if nums[mid]==target:
        #         if nums[mid+1]>nums[mid]:
        #             lastindex=mid
        #         else:
        #             low=mid+1
        #
        #
        # return [firstindex, lastindex]




            #
            # if nums[mid]<target:
            #     low=mid+1

        ## binary search 2

        ###brute force
        # i=0
        # while nums[i]!=target:
        #     i+=1
        # j=len(nums)-1
        # while nums[j]!=target:
        #     j-=1
        # return [i,j]



nums=[1,2,3,4,7,8,9,9,9,10]
target=9
solve=Solution()
print(solve.firstandlastpositionofTarget(nums, target))





