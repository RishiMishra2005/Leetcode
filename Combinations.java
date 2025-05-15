import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return new AbstractList() {
            List<List<Integer>> result;

            private void init() {
                result = new ArrayList<>();
                List<Integer> temp = new ArrayList<>();
                solve(n, 1, k, result, temp);
            }

            @Override
            public int size() {
                if (result == null) {
                    init();
                }
                return result.size();
            }

            @Override
            public Object get(int index) {
                return result.get(index);
            }
        };
    }


    private void solve(int n, int current, int k, List<List<Integer>> result, List<Integer> temp) {
        if (k == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = current; i <= n; i++) {
            temp.add(i);
            solve(n, i + 1, k - 1, result, temp);
            temp.removeLast();
        }

    }
}


