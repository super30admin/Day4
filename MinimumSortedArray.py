class Solution:
    def findMin(self, nums: List[int]) -> int:
        if len(nums)==0:
            return -1
        if len(nums)==1:
            return nums[0]
        left=0
        right=len(nums)-1
        while(left<=right):
            mid=(left+right)//2
            if mid>0 and nums[mid]<nums[mid-1]:
                return nums[mid]
            elif nums[mid]>nums[right] and nums[left]<=nums[mid]:
                #unsorted right
                left=mid+1
            else:
                #unsorted left
                right=mid-1
        return nums[left]
 #space complexity is O(1)
 #time is O(logn)
