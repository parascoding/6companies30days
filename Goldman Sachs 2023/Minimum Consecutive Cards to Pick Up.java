class Solution {
    public int minimumCardPickup(int[] a) {
        Map<Integer, Integer> hm = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int n = a.length;
        for(int i = 0; i < n; i++){
            if(hm.containsKey(a[i])){
                min = Math.min(min, i - hm.get(a[i]) + 1);
            }
            hm.put(a[i], i);
        }
        if(min == Integer.MAX_VALUE)
            min = -1;
        return min;
    }
}
