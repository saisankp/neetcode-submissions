class Solution {

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, 0, target, new ArrayList<>(), res);
        return res;
    }

    private void dfs(int[] nums, int start, int remaining,
                     List<Integer> path, List<List<Integer>> res) {

        if (remaining == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (remaining < 0) {
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // if (nums[i] > remaining) continue;

            path.add(nums[i]);

            // NOTE: i (not i+1) because reuse allowed
            dfs(nums, i, remaining - nums[i], path, res);

            path.remove(path.size() - 1);
        }
    }
}