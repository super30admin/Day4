class Solution:
    def findMin(self, nums):
        i = 0 
        j = len(nums)- 1 
        while i < j:
            mid = (i+j)//2 
            if nums[mid] > nums[j]:
                i = mid + 1 
            else:
                j = mid 
        return nums[i]

if __name__ == "__main__":
    nums = [3,4,5,1,2]
    s = Solution()
    print(s.findMin(nums))