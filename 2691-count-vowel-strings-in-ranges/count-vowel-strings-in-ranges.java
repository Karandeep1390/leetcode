class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;

        int [] pre = new int[n];

        for(int i=0;i<words.length;i++) {
            String word = words[i];
            boolean isFirstChar = isVowel(word.charAt(0));
            boolean isLastChar = isVowel(word.charAt(word.length()-1));

            if (isFirstChar && isLastChar) pre[i]++;
        }

        for(int i=1;i<n;i++) {
            pre[i] += pre[i-1];
        }
        
        int [] ans = new int[queries.length];
        int index = 0;
        for(int [] query : queries) {
            int l = query[0];
            int r = query[1];

            if(l == 0) {
                ans[index++] = pre[r];
            } else {
                ans[index++] = pre[r] - pre[l-1];
            }
        }

        return ans;
    }

    private boolean isVowel(char ch) {
        String vowels = "aeiou";
        return vowels.indexOf(ch) != -1;
    }
}