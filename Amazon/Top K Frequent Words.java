class Solution {
    public List<String> topKFrequent(String[] s, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
            new Comparator<Pair>(){
                public int compare(Pair p1, Pair p2){
                    if(p1.freq == p2.freq){
                        return -p1.s.compareTo(p2.s);
                    }
                    return p1.freq - p2.freq;
                }
            }
        );
        Map<String, Integer> hm = new HashMap<>();
        for(String x : s){
            hm.put(x, hm.getOrDefault(x, 0) + 1);
        }
        for(Map.Entry<String, Integer> e : hm.entrySet()){
            if(pq.size() < k){
                pq.add(new Pair(e.getKey(), e.getValue()));
            } else{
                if(pq.peek().freq < e.getValue()){
                    pq.remove();
                    pq.add(new Pair(e.getKey(), e.getValue()));
                } else if(pq.peek().freq == e.getValue()){
                    if(pq.peek().s.compareTo(e.getKey()) > 0){
                        pq.remove();
                        pq.add(new Pair(e.getKey(), e.getValue()));
                    }
                }
            }
        }
        List<String> ans = new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.remove().s);
        }
        Collections.reverse(ans);
        return ans;
    }
    static class Pair{
        String s;
        int freq;
        Pair(String s, int freq){
            this.s = s;
            this.freq = freq;
        }
        public String toString(){
            return s +" "+freq;
        }
    }
}
