class Solution {
    public int maxConsecutive(int b, int t, int[] s) {
        List<Integer> list = new ArrayList<>();
        for(int x : s)
            list.add(x);
        Collections.sort(list);
        int max = -1;
        int n = list.size();
        for(int i = 0; i < n - 1; i++){
            max = Math.max(max, list.get(i + 1) - list.get(i) - 1);
        }
        max = Math.max(max, list.get(0) - b);
        max = Math.max(max, t - list.get(n - 1));
        return max;
    }
}Maximum Consecutive Floors Without Special Floors
