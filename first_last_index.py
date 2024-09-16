"""
Approach recursively seach the sorted array for an element using binary search. 
Once you find it recursively search for the left most index and right most index using similar startegy.

Time complexity = O(n)

Run on leet code
"""

class Solution(object):
    def searchRange(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: List[int]
        """
        if not nums :
            return [-1,-1]
        
        l = self.binsearch_l(0, len(nums)-1,target,nums)
        r = self.binsearch_r(0, len(nums)-1,target,nums)
        return [l,r]
        
        
    def binsearch_l(self,l,r,k,arr) :

        if (l > r ) :
            return -1
        
        if (l == r)  :
            return -1 if (arr[l] != k) else  l

        m = l + (r-l)/2
        

        if arr[m] == k :
            sl = self.binsearch_l(l,m-1,k,arr)
            return m if (sl == -1) else sl

        if arr[m] > k :
            return self.binsearch_l(l,m-1,k,arr)

        if arr[m] < k :
            return self.binsearch_l(m+1,r,k,arr)


    def binsearch_r(self,l,r,k,arr) :

        if (l > r ) :
            return -1
        
        if (l == r) :
            return -1 if arr[l] != k else  l

        m = l + (r-l)/2

        if arr[m] == k :
            sl = self.binsearch_r(m+1,r,k,arr)
            return m if sl == -1 else sl

        if arr[m] > k :
            return self.binsearch_r(l,m-1,k,arr)

        if arr[m] < k :
            return self.binsearch_r(m+1,r,k,arr)
