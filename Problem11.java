class Solution {
 public String[][] groupAnagrams(String[] input) {
          int[] alreadyChecked = new int[input.length];
          String[][] result= new String[input.length][];
          int noOfGroups=0;
          for(int i=0;i<input.length;i++){
             if(alreadyChecked[i]==0){
                 String[] tmp= new String[input.length];
                 int anagramsCt=0;
                 tmp[anagramsCt]=input[i];
                 for(int j=i+1;j<input.length;j++){
                     if(alreadyChecked[j]==0){
                         if(isAnagram(input[i],input[j])){
                             alreadyChecked[i]=1;
                             alreadyChecked[j]=1;
                             anagramsCt++;
                             tmp[anagramsCt]=input[j];
                         }
                     }
                 }
                 String[] anagramsArr = new String[anagramsCt+1];
                 for(int k=0;k<=anagramsCt;k++){
                     anagramsArr[k]=tmp[k];
                 }
                 result[noOfGroups]=anagramsArr;
                 noOfGroups++;
             }
          }
          
           String[][] finalResult = new String[noOfGroups][];
                 for(int k=0;k<noOfGroups;k++){
                     finalResult[k]=result[k];
                 }
 
          return finalResult;
    }
    
    private  boolean isAnagram(String str1,String str2){
        if(str1.toCharArray().length!=str2.toCharArray().length) return false;
        else{
            for(char ch: str2.toCharArray()){
                boolean isPresent=false;
                for(char ch1: str1.toCharArray()){
                    if(ch1==ch) isPresent=true;
                }
                if(!isPresent) return false;
            }
            return true;
        }
    }
}
    
