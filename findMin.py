# Time complexity : O(logn)
# Space complexity : O(1)
class Solution:
    def findMin(self, nums: List[int]) -> int:
        if nums is None or len(nums) <= 0:
            return False
        
        
        def findMinElement(nums: List[int]) -> int:
           
            l = 0
            h = len(nums) - 1
            if nums[l] < nums[h]:
                return nums[l]
            while l <= h  :
                m = (l + h) //2
                if nums[l] < nums[h]:
                    return nums[l]

                # Check if mid elemnt is the peak
                if (m ==0 or nums[m] < nums[m -1] )and (m == len(nums) - 1 or nums[m] < nums[m + 1]):
                    return nums[m]

                # If we are in sorted part, go to unsorted part or next part
                elif nums[m] >= nums[l]:
                    l = m + 1
                else:
                    h = m -1
            return None
        m = findMinElement(nums)
        #print("va,",m)
        return m
