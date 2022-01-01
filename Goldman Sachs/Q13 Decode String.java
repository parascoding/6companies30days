class Solution{
    static String decodedString(String s){
        Stack<Integer> intStack=new Stack<>();
        Stack<StringBuilder> strStack = new Stack<>();
        StringBuilder sb=new StringBuilder("");
        int k=0;
        char ch[]=s.toCharArray();
        for(char c:ch){
            if(c>='0'&&c<='9'){
                k=k*10+(int)(c-'0');
            } else if(c=='['){
                intStack.push(k);
                strStack.push(sb);
                k=0;
                sb=new StringBuilder("");
            } else if(c==']'){
                StringBuilder temp=sb;
                sb=strStack.pop();
                for(int i=intStack.pop();i>0;i--)
                    sb.append(temp);
            } else{
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
