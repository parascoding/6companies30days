class Solution {
    public int totalFruit(int[] a) {
        Map<Integer, Integer> hm = new HashMap<>();
        int low = 0, high = 0;
        int n = a.length;
        int max = 0;
        while(high < n){
            while(low < high && hm.size() > 2){
                int temp = a[low];
                hm.put(temp, hm.get(temp) - 1);
                if(hm.get(temp) == 0)
                    hm.remove(temp);
                low++;
            }
            hm.put(a[high], hm.getOrDefault(a[high], 0) + 1);
            if(hm.size() < 3)
                max = Math.max(max, high - low + 1);
            high++;
        }
        return max;
    }
}
