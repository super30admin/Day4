# 34. Find First and Last Position of Element in Sorted Array
# Time Complexity: O(log(n))
# Approach: left_binary serch searches first occurence and right_binary_search for last occurence
# added two elements to avoid index error. can be made better :(
class Solution:
    def l_b_search(self,nums,left,right,target):
        answer = -1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                if nums[mid-1] != target:
                    answer = mid
                    break
                else:
                    right = mid - 1
            elif nums[mid] > target:
                right = mid - 1
            elif nums[mid] < target:
                left = mid + 1
        return answer
    def r_b_search(self,nums,left,right,target):
        answer = -1
        while left <= right:
            mid = (left + right) // 2
            if nums[mid] == target:
                if nums[mid+1] != target:
                    answer = mid
                    break
                else:
                    left = mid + 1
            elif nums[mid] > target:
                right = mid - 1
            elif nums[mid] < target:
                left = mid + 1
        return answer
    
    def searchRange(self, nums: List[int], target: int) -> List[int]:        
        nums.append(target-1)
        nums.insert(0,target-1)
        if self.l_b_search(nums,0,len(nums)-1,target) == -1:
            return [-1,-1]
        else:
            return [self.l_b_search(nums,0,len(nums)-1,target)-1,self.r_b_search(nums,0,len(nums)-1,target)-1]
        