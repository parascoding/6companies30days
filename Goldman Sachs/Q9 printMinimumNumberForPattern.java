class Solution{
    static String printMinNumberForPattern(String s){
        Stack<Integer> st=new Stack<>();
        StringBuilder sb=new StringBuilder("");
        for(int i=0;i<=s.length();i++){
            st.push(i+1);
            if(i==s.length()||s.charAt(i)=='I')
            {
                while(!st.isEmpty()){
                    sb.append(String.valueOf(st.pop()));
                }
            }
        }
        return sb.toString();
    }
}
