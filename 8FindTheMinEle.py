"""
LC:153
#T:O(n)
Assumed that elements before mid and after are sorted.
Compare lowest of both i.e left_low and right_low
"""

class Solution:
    def findMin(self, nums: List[int]) -> int:
        l=0
        arr=nums
        h=len(arr)-1
        mid = int((l+h)/2)
        minele=arr[mid]

        #print(l,r,mid)
        if arr[l]<arr[mid]:
            minele=arr[l]
        if arr[mid+1]<minele:
            minele=arr[mid+1]
        return minele
