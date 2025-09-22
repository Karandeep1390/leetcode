class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] arr = s.toCharArray();
        char[] array = t.toCharArray();
        int i=0;

        for(int j=0;j<array.length && i<arr.length;j++){
            if(arr[i]==array[j]){
                i++;
            }
        }

        return i == arr.length;
        
    }
}