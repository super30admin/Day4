#Time Complexity: O(logn)

class Solution:
    def findMin(self, nums: List[int]) -> int:
        low=0
        high=len(nums)-1

        while low<=high:
            #if low<=high means array is sorted
            if nums[low]<=nums[high]:
                #return low directly as min
                return nums[low]
            # if low is not less than high then array is unsorted
            mid=low+(high-low)//2
           
            
            if (mid ==0 or nums[mid]<nums[mid-1]) and nums[mid]<nums[mid+1]:
                return nums[mid]
            #now check again if above case is not true then either of the half is again sorted and eliminate that half 
            elif nums[low]<=nums[mid]:
                # left half is sorted then move low
                low=mid+1
                # else right is sorted then move high 
            else:
                high=mid-1