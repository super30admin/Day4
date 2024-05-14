#time complexity: O(log n)-binary search
# space complexity: O(1)-constant space
# Approach: if mid is lesser than its neighbours return mid
# if mid is greater than element at low, then we are supposed to move right-so left pointer = mid+1
# else we have to move left side, so right = mid-1
# we again search if element at low is lesser than element right-return element if true.

class Solution:
    def findMin(self, nums: List[int]) -> int:
        n = len(nums)
        l = 0
        r = n-1
        if nums[l] <= nums[r]:
            return nums[l]
        while(l <= r):
            mid = l + ((r - l)//2)
            if(nums[l]<=nums[r]):
                return nums[l]
            if((mid == 0 or nums[mid]<nums[mid-1]) and ( mid == n-1 or nums[mid]<nums[mid+1])):
                return nums[mid]
            elif(nums[mid]>=nums[l]):
                l = mid + 1
            else:
                r = mid - 1
               
            
            
        
            
                
        