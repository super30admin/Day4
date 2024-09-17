class Solution:
    def findMin(self, nums: List[int]) -> int:
        
        left = 0
        right = len(nums)-1
        
        # base condition: if teh list is sorted --> return the left most/ smallest number
        if nums[left] < nums[right]:
            return nums[left]
        
        if len(nums) == 1:
            return nums[0]
        
        while right>= left:
            # midpoint
            mid = (left+right)//2
            

            
            # deciding our left and right pointers
            if nums[0] < nums[mid]  :
                left = mid+1
            else:
                right = mid-1
            
            # return the smaller of the vals            
            if nums[mid] > nums[mid+1]:
                return nums[mid+1]
            
            if nums[mid] < nums[mid-1]:
                return nums[mid]