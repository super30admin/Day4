#Time comp-O(logn)
#space-O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        l=0
        h=len(nums)-1
        while l<=h:
            #if no roatation
            if nums[l]<=nums[h]:
                return nums[l]
            #if rotation found 
            #calculate mid
            mid=l+(h-l)//2
            #if next element from mid is greater
            if mid!=len(nums)-1 and nums[mid]>nums[mid+1]:
                return nums[mid+1]
            #if prev element of mid is greater
            if mid!=0 and nums[mid]<nums[mid-1]:
                return nums[mid]
            # sorted in left side so move to right side of the array
            if nums[mid]>nums[l]:
                l=mid+1
            else:
                 h=mid-1
            
                
                
