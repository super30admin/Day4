# time complexity: O(log n) - binary search
# space complexity: O(1)-constant time
# Approach: for first position, if there is a hit, we wil check the before element.
# if the before element is same, we reduce the right pointer to mid-1, since we want to move to left side
# we do the same for last position too, but we check with the next element.
# if its the same, we increase left pointer to mid+1 since we want to move right side
# if there is no hit, we perform normal binary search operations.. 




class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        n=len(nums)
        if n==0:
            return [-1, -1]
        if target < 0 or target > nums[n-1]:
            return [-1,-1]
        left = self.binary_search(nums,target,1)
        if left == -1:
            return [-1,-1]
        right = self.binary_search(nums,target,0)
        return [left,right]
        
    def binary_search(self,nums,target,left_bias):
        l,r=0,len(nums)-1
        index=-1
        while(l<=r):
            mid = (l+r)//2
            if target > nums[mid]:
                l=mid+1
            elif target<nums[mid]:
                r=mid-1
            else:
                index=mid
                if left_bias:
                    if mid == 0 or nums[mid-1]<nums[mid]:
                        return index
                    else:
                        r=mid-1
                else:
                    if mid == len(nums)-1 or nums[mid+1] > nums[mid]:
                        return index
                    else:
                        l=mid+1
        return index
                
