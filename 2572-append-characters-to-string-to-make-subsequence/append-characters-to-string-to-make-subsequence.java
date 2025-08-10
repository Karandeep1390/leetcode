class Solution {
    public int appendCharacters(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();

        int sIndex = 0, tIndex = 0;

        while(sIndex < sLength && tIndex < tLength) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                tIndex++;
            }

            sIndex++;
        }

        return tLength - tIndex;
    }
}