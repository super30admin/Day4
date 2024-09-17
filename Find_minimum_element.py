##Created by Ashutosh Upadhye
##Space Complexity:O(Lsog(n)) Recurvsive binary search
##Time Complexity:O(Log(n))


## This code works on leetcode

class minimum_element:

    def binary_search(self, a, low, high):

##Here we use a modified version of binary search. No need to use the condition of if(low<high) since we are checking multiple regions for peaks.

        if a is None: return None

        if high == low: return a[low] #If only one element

        if low - high == 1: return min(a[low], a[high]) ##If there are two elements, select minimum of both

        mid = low + (high - low) // 2
        ##Compute the mid

        if a[low] < a[high]: ##Directly compare a[low] with a[high].Return a[low] if it is lower.
            return a[low]

        if a[mid] > a[low]:
            minimum_element.binary_search(self, a, mid, high) ## If in a rotated sorted array a[mid] > a[low], then search in the right subarray

        return minimum_element.binary_search(self, a, low, mid)##Else search for the left subarray



    def main(self):
        a = [5,6,7,8,9,0,1,2]
        element = minimum_element.binary_search(self, a, 0, len(a)-1)
        print(element)


object = minimum_element().main()