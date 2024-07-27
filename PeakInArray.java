//TC: O(log N)
//SC: O(1)
//Approach: Climb the higher mountain -> find the higher number and move towards it

public class PeakInArray {
    public int findPeakElement(int[] n) {
        int l = 0; int h = n.length-1;

        while(l<=h){
            int mid = l + (h-l)/2;
            if( 
                (mid == 0 || n[mid] > n [mid-1]) 
                &&
                (mid == n.length -1 || n[mid] > n[mid+1])
            ){
                return mid;
            }
            //move towards higher number
            else if (mid>0 && n[mid-1] > n[mid]) h= mid -1;
            else l = mid+1;
        }

        return -1;
    }
}
