package leet.Solution2019_2;

//990
public class EqualityEquation {
    /**
     * Given an array equations of strings that represent relationships between variables,
     * each string equations[i] has length 4 and takes one of two different forms: "a==b" or "a!=b".
     * Here, a and b are lowercase letters (not necessarily different) that represent one-letter variable names.
     * <p>
     * Return true if and only if it is possible to assign integers to variable names
     * so as to satisfy all the given equations.
     * <p>
     * <p>
     * <p>
     * Example 1:
     * <p>
     * Input: ["a==b","b!=a"]
     * Output: false
     * Explanation: If we assign say, a = 1 and b = 1, then the first equation is satisfied,
     * but not the second.  There is no way to assign the variables to satisfy both equations.
     * Example 2:
     * <p>
     * Input: ["b==a","a==b"]
     * Output: true
     * Explanation: We could assign a = 1 and b = 1 to satisfy both equations.
     * Example 3:
     * <p>
     * Input: ["a==b","b==c","a==c"]
     * Output: true
     * Example 4:
     * <p>
     * Input: ["a==b","b!=c","c==a"]
     * Output: false
     * Example 5:
     * <p>
     * Input: ["c==c","b==d","x!=z"]
     * Output: true
     * <p>
     * x == x -> ignore
     */
    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            while (this.parent[x] != x) {
                x = this.parent[x];
            }
            return x;
        }

        public void union(int x, int y) {
            this.parent[find(x)] = find(y);
        }
    }

    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for (String e : equations) {
            if (e.charAt(1) == '=') { // x == x
                char c1 = e.charAt(0), c2 = e.charAt(3);
                uf.union(c1 - 'a', c2 - 'a');
            }
        }
        for (String e : equations) {
            String op = e.substring(1, 3);
            char c1 = e.charAt(0), c2 = e.charAt(3);
            if (op.equals("==")) {
                if (uf.find(c1 - 'a') != uf.find(c2 - 'a')) return false;
            } else if (op.equals("!=")) {
                if (uf.find(c1 - 'a') == uf.find(c2 - 'a')) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strings = {
                "a==b", "b==c", "a!=c"
        };
        System.out.println(new EqualityEquation().equationsPossible(strings));
    }
}
