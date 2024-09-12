"""
702. Search in a Sorted Array of Unknown Size
TC - O(log n)
SC - O(1)
"""
# """
# This is ArrayReader's API interface.
# You should not implement it, or speculate about its implementation
# """
# class ArrayReader:
#    def get(self, index: int) -> int:

class Solution:
    def search(self, reader: 'ArrayReader', target: int) -> int:
        if reader.get(0) == target:
            return 0

        low = 0
        high = 1

        while reader.get(high) < target:
            low = high
            high = high * 2

        return self.binarySearch(reader, target, low, high)

    def binarySearch(self, reader: 'ArrayReader', target: int, low: int, high: int) -> int:
        while low <= high:
            mid = low + (high - low) // 2
            if reader.get(mid) == target:
                return mid
            if reader.get(mid) < target:
                low = mid + 1
            else:
                high = mid - 1
        return -1
