# Utilize binary search twice using a function
# first find the leftmost idx of target by shifting our right most pointer to left.
# first find the rightmost idx of target by shifting our left most pointer to right.

# time complexity O logn
# space complexity O(1)

class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

        leftIdx = self.binSearch(nums, target, True)
        rightIdx = self.binSearch(nums, target, False)

        return [leftIdx, rightIdx]
    
    def binSearch(self, nums, target, biasVar):

        l = 0
        r = len(nums)-1

        # initialize i to -1, it will return below this function if target not found
        i = -1
    
        while(l <= r):
        
            m = l + (r - l) //2
            if nums[m] > target:
                r = m -1
            elif nums[m] < target:
                l = m + 1
            
            else:
                i = m
                if biasVar:
                    r = m - 1
                else:
                    l = m + 1

        return i 

            





