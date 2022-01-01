class Solution {
    public List<List<String>> Anagrams(String[] s) {
        // ans=new ArrayList<>();
        hm=new HashMap<>();
        for(int i=0;i<s.length;i++){
            char ch[]=new char[26];
            for(int j=0;j<s[i].length();j++)
                ch[(int)(s[i].charAt(j)-'a')]++;
            
            String temp=new String(ch);
            if(!hm.containsKey(temp))
                hm.put(temp,new ArrayList<>());
            hm.get(temp).add(s[i]);
        }
        return new ArrayList<>(hm.values());
    }
    private Map<String,List<String>> hm;
}
