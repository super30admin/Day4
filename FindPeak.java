/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package findpeak;

/**
 *
 * @author Samartha_Swaroop
 */
public class FindPeak {
    public int findPeakElement(int[] nums) {
        int l = 0, h = nums.length-1;
        while(l < h){
            int mid = (l + h) / 2;
            if(nums[mid] < nums[mid + 1])
                l = mid + 1;
            else
                h = mid;
         }
        return l;
    }
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
