public class UnionFind {

    private final int[] myList;

    /* Creates a UnionFind data structure holding N items. Initially, all
       items are in disjoint sets. */
    public UnionFind(int N) {
        myList = new int[N];
        for (int i = 0; i < N; i++) {
            myList[i] = -1;
        }
    }

    /* Returns the size of the set V belongs to. */
    public int sizeOf(int v) {
        return -myList[find(v)];
    }

    /* Returns the parent of V. If V is the root of a tree, returns the
       negative size of the tree for which V is the root. */
    public int parent(int v) {
        return myList[v];
    }

    /* Returns true if nodes/vertices V1 and V2 are connected. */
    public boolean connected(int v1, int v2) {
        return find(v1) == find(v2);
    }

    /* Returns the root of the set V belongs to. Path-compression is employed
       allowing for fast search-time. If invalid items are passed into this
       function, throw an IllegalArgumentException. */
    public int find(int v) {

        if (v < 0 || v >= myList.length) {
            throw new IllegalArgumentException("Invalid index: " + v);
        }

        if (myList[v] < 0) {
            return v;
        }
        myList[v] = find(myList[v]);  /* 递归调用，将路上的所有节点改为最后找到的根节点 */
        return myList[v];
    }

    /* Connects two items V1 and V2 together by connecting their respective
       sets. V1 and V2 can be any element, and a union-by-size heuristic is
       used. If the sizes of the sets are equal, tie break by connecting V1's
       root to V2's root. Union-ing an item with itself or items that are
       already connected should not change the structure. */
    public void union(int v1, int v2) {
        if (!connected(v1, v2)) {
            if (sizeOf(v1) <= sizeOf(v2)) {
                myList[find(v2)] += myList[find(v1)];
                myList[find(v1)] = find(v2);
            } else {
                myList[find(v1)] += myList[find(v2)];
                myList[find(v2)] = find(v1);
            }
        }
    }

}
