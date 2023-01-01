class Solution {
    public int evalRPN(String[] s) {
        Stack<Integer> st = new Stack<>();
        for(String x : s){
            if(!isOperand(x)){
                int num = Integer.parseInt(x);
                st.push(num);
            } else{
                int d2 = st.pop();
                int d1 = st.pop();
                int res;
                if(x.charAt(0) == '+')
                    res = d1 + d2;
                else if(x.charAt(0) == '-')
                    res = d1 - d2;
                else if(x.charAt(0) == '*')
                    res = d1 * d2;
                else
                    res = d1 / d2;
                st.push(res);
            }
        }
        return st.pop();
    }
    static boolean isOperand(String s){
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }
}
