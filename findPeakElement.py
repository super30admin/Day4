class Solution:
    def findPeakElement(self, nums):
        i = 0 
        j = len(nums)-1
        
        while i < j:
            mid1 = (i+j) //2 
            mid2 = mid1 + 1 
            if nums[mid1] < nums[mid2]:
                i = mid2 
            else:
                j = mid1 
        return i
        
if __name__ == "__main__":
    
    nums = [1,2,1,3,5,6,4]
    s = Solution()
    res = s.findPeakElement(nums)
    print(res)
    