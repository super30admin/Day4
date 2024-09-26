class Solution:
    def peakIndexInMountainArray(self, A: List[int]) -> int:
        left=1
        right=len(A)-2
        while left<=right:
            if A[left]>A[left-1] and A[left]>A[left+1]:
                return left
            if A[right]>A[right-1] and A[right]>A[right+1]:
                return right
            left+=1
            right-=1