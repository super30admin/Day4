class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        # if len(nums)<=1:
        #     return nums[0] if nums[0] == target
        #finding left side first and then right side
        left = 0
        right = len(nums)-1
        ans_left = float("inf")
        while(left<=right):
            mid = left + (right-left)//2
            if nums[mid]>=target:
                if nums[mid] == target:
                    ans_left = min(ans_left,mid)
                right = mid-1
            else:
                left = mid+1
        
        left = 0
        right = len(nums)-1
        ans_right = -1
        while(left<=right):
            mid = left + (right-left)//2
            if nums[mid]<=target:
                if nums[mid] == target:
                    ans_right = max(ans_right,mid)
                left = mid+1
            else:
                right = mid-1
        if ans_right == -1:
            return [-1,-1]
        return [ans_left,ans_right]
        #Time Complexity: O(logn+logn) = O(logn)
        #Space: O(1)