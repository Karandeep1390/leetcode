class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for(String s : operations) {
            if (s.charAt(0) == 'C') {
                if (st.size() > 0) {
                    st.pop();
                }
            } else if (s.charAt(0) == 'D') {
                if (st.size() > 0) {
                    st.push(2*st.peek());
                }
            } else if (s.charAt(0) == '+') {
                if(st.size() > 1) {
                    int val = st.pop();
                    int newVal = st.peek() + val;
                    st.push(val);
                    st.push(newVal);
                }
            } else {
                st.push(Integer.parseInt(s));
            }
        }

        int ans = 0;
        while(st.size() > 0) {
            ans += st.pop();
        }

        return ans;
    }
}