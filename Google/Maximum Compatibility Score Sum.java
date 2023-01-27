class Solution {
    public int maxCompatibilitySum(int[][] stu, int[][] ment) {
        perm = new ArrayList<>();
        boolean visited[] = new boolean[ment.length];
        findPermutation(ment.length, new ArrayList<>(), visited);
        int max = 0;
        for(List<Integer> list : perm){
            int temp = score(stu, ment, list);
            max = Math.max(max, temp);
        }
        return max;
    }
    public int score(int stu[][], int ment[][], List<Integer> perm){
        int ans = 0;
        for(int i = 0; i < stu.length; i++){
            ans += findScore(stu[i], ment[perm.get(i)]);
        }
        return ans;
    }
    public int findScore(int stu[], int ment[]){
        int ans = 0;
        for(int i = 0; i < stu.length; i++)
            ans += (stu[i] == ment[i] ? 1 : 0);
        return ans;
    }
    List<List<Integer>> perm;
    public void findPermutation(int n, List<Integer> list, boolean visited[]){
        if(list.size() == n){
            perm.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < n; i++){
            if(visited[i])
                continue;
            visited[i] = true;
            list.add(i);
            findPermutation(n, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}
