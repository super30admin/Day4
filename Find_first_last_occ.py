##Created by Ashutosh Upadhye
##Space Complexity:O(Log(n)) Recurvsive binary search
##Time Complexity:O(Log(n))

class find_first_and_last_occurence:


    def find_first_occurence(self,a,low,high,x,n):

        if low <= high:
            mid = low + (high-low) // 2
            if (mid == 0 or x > a[mid-1]) and a[mid] == x: ##If middle is at zero or element is greater than mid-1 element. then check if mid is x.
                return mid
            if x > a[mid]: #If x is greater than a[mid] then recusively serarch right subarray
                return find_first_and_last_occurence.find_first_occurence(self, a, mid+1, high, x, n)
            else:##Else go for left subarray
                return find_first_and_last_occurence.find_first_occurence(self, a, low, mid-1, x, n)
        return -1

    def find_last_occurence(self, a, low, high, x, n):

        if low <= high:
            mid = low + (high - low) // 2
            if (mid == n-1 or x < a[mid + 1]) and a[mid] == x: ## If middle element is last or the element to be found is less than mid+1 element
                return mid
            if x < a[mid]:
                return find_first_and_last_occurence.find_last_occurence(self, a, low, mid - 1, x, n)##Recursively search for the left subarray
            else:
                return find_first_and_last_occurence.find_last_occurence(self, a, mid + 1, high, x, n)##Recursively search for the right subarray
        return -1

    def main(self):

        a = [2, 3, 4, 5, 5, 5, 5, 6, 7, 8]
        find = 5
        first_occurence = find_first_and_last_occurence.find_first_occurence(self, a, 0, len(a)-1, find, len(a))
        last_occurence = find_first_and_last_occurence.find_last_occurence(self, a, 0, len(a) - 1, find, len(a))
        print(first_occurence)
        print(last_occurence)

object = find_first_and_last_occurence().main()