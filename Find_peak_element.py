
##Created by Ashutosh Upadhye
##Space Complexity:O(Lsog(n)) Recurvsive binary search
##Time Complexity:O(Log(n))


##This code works on leetcode

class peak_element:

    def binary_search(self, a, low, high):

##Here we use a modified version of binary search. No need to use the condition of if(low<high) since we are checking multiple regions for peaks.
        mid = low + (high - low) // 2
        ##Compute the mid

        #Now check if the value at mid-1 is less than mid and if mid is on zero index. or check if value of mid is greater than mid + 1.
        #Append the index to the list.
        if mid == 0 or a[mid-1] <= a[mid] and mid == len(a)-1 or a[mid] >= a[mid+1]:
            return mid
        if mid > 0 and a[mid-1] > a[mid]:# If the mid+1 is greater than mid then peak exists on left side
            return peak_element.binary_search(self, a, low, mid-1)
        if mid < len(a)-1 and a[mid+1] > a[mid]:#Other wise look at right subarray.
             return peak_element.binary_search(self, a, mid+1, high)


    def main(self):
        a = [1, 5, 3, 20, 4, 1, 0]

        element = peak_element.binary_search(self, a, 0, len(a)-1)
        print(element)


object = peak_element().main()