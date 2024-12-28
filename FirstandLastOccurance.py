class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        def binarySearch(nums,target,flag):
            left,right = 0,len(nums)-1
            while left <= right:
                mid = left + (right-left)//2
                if nums[mid] == target:
                    if flag == 0:
                        # searching first occurance
                        if mid == left or nums[mid-1] != nums[mid] :
                        # check value to left
                        # if mid == 0 or nums[mid-1] != nums[mid] :
                            return mid
                        else:
                            right = mid - 1
                    elif flag == 1:
                        # searching for last occurance
                        if mid == right or nums[mid+1] != nums[mid]:
                    # if mid == len(nums)-1 or nums[mid+1] != nums[mid]:
                            return mid
                        else:
                            left = mid +1
                elif nums[mid] < target:
                    left = mid +1
                else:
                    right = mid -1
            return -1

        
        if nums is None or len(nums) == 0 or target < nums[0] or target > nums[len(nums)-1] :
            return [-1,-1]
        # select flag as 0,1 for first and last positions correspondlingly.
        firstpos = binarySearch(nums,target,0)
        if firstpos == -1:
            return [-1,-1]
        lastpos = binarySearch(nums,target,1)
        return [firstpos,lastpos]
# TC : O(log n)
# SC : O(1)