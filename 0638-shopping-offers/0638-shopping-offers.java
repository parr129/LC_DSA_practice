import java.util.*;

class Solution {
    Map<List<Integer>, Integer> memo = new HashMap<>();

    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        return dfs(price, special, needs);
    }

    int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        if (memo.containsKey(needs)) return memo.get(needs);

        int res = 0;
        for (int i = 0; i < needs.size(); i++)
            res += needs.get(i) * price.get(i);

        for (List<Integer> sp : special) {
            List<Integer> nxt = new ArrayList<>();
            int i = 0;
            for (; i < needs.size(); i++) {
                if (needs.get(i) < sp.get(i)) break;
                nxt.add(needs.get(i) - sp.get(i));
            }
            if (i == needs.size())
                res = Math.min(res, sp.get(i) + dfs(price, special, nxt));
        }

        memo.put(needs, res);
        return res;
    }
}