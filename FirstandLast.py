class Solution:
    def searchRange(self, nums, target):
        i = 0 
        j = len(nums) - 1 
        if not nums:
            return [-1,-1]
        left = self.binarySearchLeft(i,j,nums,target)
        right = self.binarySearchRight(i,j,nums,target)
        return [left,right]
        
    def binarySearchLeft(self,i,j,nums,target):
        while i <= j:
            mid = (i+j)//2
            if nums[mid] == target:
                if nums[mid] > nums[mid-1]:
                    return mid 
                else:
                    j = mid -1 
            elif nums[mid] > target:
                j = mid - 1
            else:
                i = mid + 1 
        return -1  
    
    def binarySearchRight(self,i,j,nums,target):
        while i <= j:
            mid = (i+j)//2
            
            if nums[mid] == target:
                if nums[mid] < nums[mid+1]:
                    return mid 
                else:
                    i = mid + 1 
            elif nums[mid] < target:
                i = mid + 1 
            else:
                j = mid - 1 
        return -1 

if __name__ == "__main__":
    nums = [1,2,3,4,8,8,8,8,9,10]
    s = Solution()
    res = s.searchRange(nums,8)
    print(res)