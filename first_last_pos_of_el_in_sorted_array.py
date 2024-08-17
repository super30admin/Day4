class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:

# Your Sol 1 - binary range to get el and then expand both sides to get range - O(log(n)) + O(range) 

        # low = 0 
        # high = len(nums)-1
        # # mid = low + (high-low) // 2
        # find_tar =-1

        # while(low<=high):

        #     mid = low + (high-low) // 2

        #     # is target
        #     if nums[mid] == target :
        #         find_tar = mid
        #         break
        #     # target smaller 
        #     elif nums[mid] > target :
        #         high = mid - 1

        #     # target bigger
        #     else :
        #         low = mid + 1

        # if find_tar == -1 :
        #     return[-1,-1]
        # left, right = find_tar, find_tar
        # curr_left, curr_right = -1,-1

        # while((left >= 0 and nums[left] == target) or (right < len(nums) and nums[right] == target)):
            
        #     if left >= 0 and nums[left] == target :
        #         curr_left = left
        #         left = left - 1 
        #     if right < len(nums) and nums[right] == target :
        #         curr_right = right
        #         right = right + 1 
            
        # return [curr_left,curr_right]

        if len(nums) == 0 :
            return [-1,-1]

        elif len(nums) == 1:
            if nums[0] == target :
                return [0,0]
            else :
                return [-1,-1]

        low = 0 
        high = len(nums)-1
        # mid = low + (high-low) // 2
        find_tar =-1

        while(low<=high):

            mid = low + (high-low) // 2

            # is target
            if nums[mid] == target :
                find_tar = mid
                break
            # target smaller 
            elif nums[mid] > target :
                high = mid - 1

            # target bigger
            else :
                low = mid + 1

        if find_tar == - 1:
            return [-1,-1]

        # get start
        low = 0 
        high = find_tar
        curr_low = -1
        while(low<=high):
            mid = low + (high-low) // 2
            if nums[mid] == target :
                curr_low = mid
                low = low - 1
                if mid - 1 >= 0 and nums[mid-1] != target :
                    break
                elif mid - 1 < 0 :
                    break
            elif nums[mid] < target :
                low = mid + 1


        # get end    
        low = find_tar
        high = len(nums) - 1
        curr_high = find_tar
        while(low<=high):
            mid = low + (high-low) // 2
            if nums[mid] == target :
                curr_high = mid
                high = high + 1
                if mid + 1 < len(nums) and nums[mid+1] != target :
                    break
                elif mid + 1 >= len(nums):
                    break
            elif nums[mid] > target :
                high = mid - 1
        print([curr_low, curr_high])
        return [curr_low, curr_high]
            
        
