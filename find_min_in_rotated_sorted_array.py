# Time Complexity:- O(log(n))
# Space Complexity:- O(1)
# Idea:- This was extremely tricky. My observation was correct but i was messing up setting the low and hi values.
# The key observation is that when we find that a part of the array(low-mid/mid-hi) is sorted the minimum element 
# can lie in low-mid if mid-hi is sorted but if not it will definitely lie in mid+1-hi
class Solution:
    def findMin(self, nums: List[int]) -> int:
        low=0
        hi=len(nums)-1
        while(low<hi):
            mid=(low+hi)>>1
            # check mid-hi first the entire array may not be rotated and is just sorted in ascending order
            if nums[mid]<nums[hi]:
                hi=mid
            else:
                # was keeping low=mid which gave TLE,need to be careful here
                low=mid+1
        return nums[low]