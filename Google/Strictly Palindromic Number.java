class Solution {
    public boolean isStrictlyPalindromic(int n) {
        for(int i = 2; i <= n - 2; i++){
            String s = findNInBaseB(n, i);
            if(!isPalindrome(s))
                return false;
        }
        return true;
    }
    private boolean isPalindrome(String s){
        int low = 0, high = s.length() - 1;
        while(low < high){
            if(s.charAt(low++) != s.charAt(high--))
                return false;
        }
        return true;
    }
    private String findNInBaseB(int n, int b){
        StringBuilder sb = new StringBuilder("");
        while(n > 0){
            int rem = n % b;
            sb.append(rem);
            n /= b;
        }
        return sb.toString();
    }
}
