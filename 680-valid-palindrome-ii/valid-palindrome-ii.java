class Solution {
    public boolean validPalindrome(String s) {
        int startingIndex = 0;
        int endingIndex = s.length()-1;

        while (startingIndex < endingIndex) {
            if (s.charAt(startingIndex) != s.charAt(endingIndex)) {
                return isPalindrome(s, startingIndex, endingIndex-1) || isPalindrome(s, startingIndex+1, endingIndex);
            }
            
            startingIndex++;
            endingIndex--;
        }
        
        return true;
    }

    private boolean isPalindrome(String s, int startIndex, int endIndex) {
        while (startIndex < endIndex) {
            if (s.charAt(startIndex) != s.charAt(endIndex)) {
                return false;
            }
            startIndex++;
            endIndex--;
        }

        return true;
    }
}