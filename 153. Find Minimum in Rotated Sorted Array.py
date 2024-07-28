# Do binary search, try to find the pivot point (till where our array is sorted)
# if our mid point is less than the right point, that means our lowest value exists on the right.
# In case array was rotated n times, we can directly check and return the first index of our array as lowest value

# time complexity O log n


class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        result = nums[0]

        l, r = 0, len(nums) -1

        while(l <= r):

            if nums[l] < nums[r]:
                return min(result, nums[l])

            m = l + (r - l ) //2
            
            result = min(result, nums[m])

            if(nums[l] <= nums[m]):
                l = m + 1
                
            else:
                r = m -1
        
        return result
