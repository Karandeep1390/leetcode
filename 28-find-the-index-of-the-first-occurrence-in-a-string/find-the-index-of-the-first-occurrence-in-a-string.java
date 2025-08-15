class Solution {
    public int strStr(String s, String t) {
        if (s.length() < t.length()) return -1;

        int sLength = s.length();
        int tLength = t.length();

        for(int i=0;i<=s.length()-t.length();i++) {
            int j=0;

            while(j<t.length() && s.charAt(i+j) == t.charAt(j)) j++;

            if(j == tLength) return i;
        }

        return -1;
    }
}