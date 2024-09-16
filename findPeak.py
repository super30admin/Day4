#Time Complexity:O(log n)
#Space Complexity:O(1)
#1. Calculate mid index
#2. check if the mid element is greater its previous one and next one. 
#3. If yes, return mid index. 
#4. Check if right index is greater then mid index, if yes, it means the greater value might be present towards right hence shift the low pointer to mid+1
# if no, shift high pointer to mid-1.
#5. Check which of the nums[l] and nums[r] is high and return that respective index.
class Solution:
    def findPeakElement(self, nums):
      
        l=0
        r=len(nums)-1
        while l<r-1:
            mid=l+(r-l)//2
            if nums[mid+1]<nums[mid]>nums[mid-1]:
                return mid
            if nums[mid]<nums[mid+1]:
                l=mid+1
            else:
                r=mid-1
        if nums[l]>=nums[r]:
            return l
        else:
            return r
