class Solution:
    def findPeakElement(self, nums: List[int]) -> int:
        low = 0
        high = len(nums) - 1

        while(low<high) :

            mid = low + ((high - low) // 2)

            if ((mid - 1 >= 0) and (nums[mid-1] < nums[mid])) and ((mid+1 <= len(nums) - 1)  and (nums[mid+1] < nums[mid])) :

                return mid

            elif nums[mid+1] > nums[mid] :
                low = mid + 1 

            else :
                high = mid 

        
        mid = low + ((high - low) // 2)

        # Explore why this was needed
        return mid

