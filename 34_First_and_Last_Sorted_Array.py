# Time complexity: O(log(n))
# space: O(1)
class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if( len(nums) == 0):
            return [-1,-1]
        # if(len(nums) == 1):

        low= 0
        high = len(nums) - 1
        
        first = self.searchfirst(nums,low,high,target)
        print('first', first)
        if ( first == -1):
            return [-1,-1]
        last = self.searchlast(nums,low,high,target)

        return [first, last]


    def searchfirst(self,nums,low,high,target):
        while(low <= high):
            mid = low + (high-low)//2
            print('mid for first', mid)
            if (nums[mid] == target):
                if((mid == 0) or (nums[mid] != nums[mid-1])):
                    return mid
                else:
                    high = mid -1
            if (nums[mid] < target):
                low = mid + 1
            if (nums[mid] > target):
                high = mid -1
        return -1
    
    def searchlast(self,nums,low,high,target):
        while(low <= high):
            mid = low + (high-low)//2
            if (nums[mid] == target):
                if((mid == high) or (nums[mid] != nums[mid+1])):
                    return mid
                else:
                    low = mid +1
            if (nums[mid] < target):
                low = mid + 1
            if (nums[mid] > target):
                high = mid -1
        return -1
        
