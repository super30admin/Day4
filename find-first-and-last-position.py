"""
Runtime Complexity:
O(log n)- binary search takes O(log n) time because we divide the array into half and search in left and right subarrays by further spliting them,this goes on until log n levels where 'n' is the number of elements.
Yes, the code worked on leetcode.
Space Complexity: O(1)- no new array or data structure is created to carry out the operations.
The idea of the algorithm is to split the array and find the mid, then check if the previous element is lesser than mid so that to know the mid is the first occurence else we move left and search.
If target is smaller than mid than we decrement high  to mid-1 else we increment low to mid+1. We do the same search for last occurence but in the oppsoite way by checking the next element to mid.
"""



class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        if target not in nums:
            return [-1,-1]
        if target<nums[0] and target>len(nums):
            return [-1,-1]
        first_occurence = self.BinarySearchFirst(nums,target)
        if first_occurence ==-1:
            return [-1,-1]
        last_occurence = self.BinarySearchLast(nums,target)
        return [first_occurence,last_occurence]
    def BinarySearchFirst(self,nums,target):
        low = 0
        high = len(nums)
        while (low<=high):
            mid = (low+high)//2
            if nums[mid]== target:
                #check if its the first occurence by moving left
                if( mid == 0 or nums[mid-1]<nums[mid]):
                    return mid
                else:
                    high = mid-1
            else:
                if target< nums[mid]:
                    high = mid-1
                else:
                    low = mid+1
    def BinarySearchLast(self,nums,target):
        low = 0
        high = len(nums)
        while (low<=high):
            mid = (low+high)//2
            if nums[mid]== target:
                #check if its the last occurence by moving right
                if( mid == len(nums)-1 or nums[mid+1]>nums[mid]):
                    return mid
                else:
                    low = mid+1
            else:
                if target< nums[mid]:
                    high = mid-1
                else:
                    low = mid+1
