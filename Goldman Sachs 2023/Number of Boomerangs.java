class Solution {
    public int numberOfBoomerangs(int[][] a) {
        int n = a.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            Map<Integer, Integer> hm = new HashMap<>();
            for(int j = 0; j < n; j++){
                if(i == j)
                    continue;
                int d = dist(a[i], a[j]);
                hm.put(d, hm.getOrDefault(d, 0) + 1);
            }
            for(Map.Entry<Integer, Integer> e : hm.entrySet()){
                if(e.getValue() > 1)
                    count += (e.getValue() * (e.getValue() - 1));
            }
        }
        return count;
    }
    static int dist(int p1[], int p2[]){
        return (p1[1] - p2[1]) * (p1[1] - p2[1]) + (p1[0] - p2[0]) * (p1[0] - p2[0]);
    }
}
