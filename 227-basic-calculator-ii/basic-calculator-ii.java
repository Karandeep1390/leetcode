class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();

        int num = 0;
        char operator = '+';

        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            if(Character.isDigit(ch)) {
                num = num * 10 + (ch-'0');
            }

            if(isOperator(ch) || i == s.length() - 1) {
                if(operator == '+') st.push(num);
                else if (operator == '-') st.push(-num);
                else if (operator == '*') st.push(st.pop() * num);
                else if (operator == '/') st.push(st.pop() / num);

                num = 0;
                operator = ch;
            }
        }

        int ans = 0;

        while(!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}