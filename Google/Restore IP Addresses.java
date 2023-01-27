class Solution {
    public List<String> restoreIpAddresses(String s) {
        ans = new ArrayList<>();
        int n = s.length();
        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                for(int k = j + 1; k < n; k++){
                    String s1 = s.substring(0, i + 1);
                    String s2 = s.substring(i + 1, j + 1);
                    String s3 = s.substring(j + 1, k + 1);
                    String s4 = s.substring(k + 1);
                    // System.out.println(s1 + "." + s2 + "." + s3 + "." + s4);
                    if(valid(s1) && valid(s2) && valid(s3) && valid(s4)){
                        ans.add(s1 + "." + s2 + "." + s3 + "." + s4);
                    }
                }
            }
        }
        return ans;
    }
    public boolean valid(String s){
        try{
            int temp = Integer.parseInt(s);
            if(temp > 255)
                return false;
            int ind = 0;
            if(temp == 0 && s.length() == 1)
                return true;
            
            if(s.charAt(0) == '0')
                return false;
                
            
            return true;
        } catch(Exception e){
            return false;
        }
    }
    
    List<String> ans;
}
