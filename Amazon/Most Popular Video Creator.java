class Solution {
    public List<List<String>> mostPopularCreator(String[] c, String[] id, int[] v) {
        int n = c.length;
        List<List<String>> ans = new ArrayList<>();
        Map<String, Long> hm = new HashMap<>();
        long max = 0;
        Map<String, Pair> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            hm.put(c[i], hm.getOrDefault(c[i], 0l) + v[i]);
            if(hm.get(c[i]) > max){
                max = hm.get(c[i]);
            }
            Pair pair = map.get(c[i]);
            if(pair == null){
                map.put(c[i], new Pair(id[i], v[i]));
            } else{
                if(v[i] > pair.view){
                    map.put(c[i], new Pair(id[i], v[i]));
                } else if(v[i] == pair.view){
                    if(id[i].compareTo(pair.name) < 0){
                        map.put(c[i], new Pair(id[i], v[i]));
                    }
                }
            }
        }
        for(Map.Entry<String, Long> e : hm.entrySet()){
            if(e.getValue() == max){
                List<String> temp =new ArrayList<>();
                temp.add(e.getKey());
                temp.add(map.get(e.getKey()).name);
                ans.add(new ArrayList<>(temp));
            }
            
        }
        return ans;
        
    }
    static class Pair{
        String name;
        long view;
        Pair(String name, long view){
            this.name = name;
            this.view = view;
        }
    }
}
