'''
Time Complexity: O(logn)
Space Complexity: O(1)
'''
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low = 0
        high = len(nums)-1
        while(low<=high):
            mid = (low+high)//2
            if(nums[mid]>=nums[low] and nums[mid]<=nums[high]):
                return nums[low]
            elif(nums[mid]<nums[low]):
                high = mid
            elif(nums[mid]>nums[high]):
                if(low == mid and mid+1==high):
                    low = mid+1
                else:
                    low = mid
        return -1