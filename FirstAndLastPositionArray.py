class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        '''
        time complexity: O(log(n))
        space complexity: O(1)
        Difficulty: Handling edge cases
        '''
        # 2 cases, find left and find right
        if(len(nums)==0):
            return [-1,-1]
        
        beg = 0
        end = len(nums)-1
        mid = (beg + end)//2
        while(beg<=end):
            mid = (beg + end)//2
            if (mid==0 or (nums[mid-1]<nums[mid])) and (nums[mid]==target):
                print(mid)
                break
            if(nums[mid]>=target):
                end = mid - 1 
            elif(nums[mid]<target):
                beg = mid + 1
        left = -1
        if(nums[mid]==target):
            left = mid
        else:
            return [-1,-1]
        beg = left+1
        end = len(nums)-1
        mid = (beg + end)//2
        while(beg<=end):
            mid = (beg + end)//2
            if (mid==len(nums)-1 or(nums[mid]<nums[mid+1])) and (nums[mid]==target):
                break
            if(nums[mid]<=target):
                beg = mid + 1
            elif(nums[mid]>target):
                end = mid - 1
        if(nums[mid]==target):
            return [left, mid]
        else:
            return [left,left]