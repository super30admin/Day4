#Submitted successfully to Leetcode
#Time com : O(logn)
#Space Com : O(1)
class Solution:
    def searchRange(self, nums, target):
        first,last = self.searchFirst(nums,target),self.searchLast(nums,target)
        return first,last


    def searchFirst(self,nums,target):
        first = -1
        low = 0
        high = len(nums)-1

        while low<=high:
            mid = (low+high)//2
            # If target == array mid elem
            if nums[mid] == target:
                #if array has one elem or prev elem of the mid is less than the target
                if low == mid or nums[mid-1] < target:
                    first = mid
                    break
                #if prev elem of mid is equal to target
                else:
                    high = mid -1
            #If target is > than mid then shit low to mid+1 elem
            elif nums[mid] < target:
                low = mid+1
            #If target is < than mid then shit high to mid-1 elem
            else:
                high = mid-1
        return first

    def searchLast(self,nums,target):
        last = -1
        low = 0
        high = len(nums)-1

        while low<=high:
            mid = (low+high)//2
            # If target == array mid elem
            if nums[mid] == target:
                #if array has one elem or next elem of the mid is more than the target
                if high == mid or nums[mid+1] > target:
                    last = mid
                    break
                #if next elem of mid is equal to target
                else:
                    low = mid+1
            #If target is > than mid then shit low to mid+1 elem
            elif nums[mid] < target:
                low = mid+1
            #If target is < than mid then shit high to mid-1 elem
            else:
                high = mid-1
        return last

s = Solution()
print(s.searchRange([5,7,8,9,9,10],9))
print(s.searchRange([5,7,7,8,8,10],8))
