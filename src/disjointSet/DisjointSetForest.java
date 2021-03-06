package disjointSet;

import org.jetbrains.annotations.NotNull;
import utils.Graph;

public class DisjointSetForest {
    public static void makeSet(@NotNull Graph.Vertex x) {
        x.p = x;
        x.rank = 0;
    }

    public static void union(Graph.Vertex x, Graph.Vertex y) {
        link(findSet(x), findSet(y));
    }

    private static void link(@NotNull Graph.Vertex x, @NotNull Graph.Vertex y) {
        if (x.rank > y.rank) y.p = x;
        else {
            x.p = y;
            if (x.rank == y.rank) y.rank++;
        }
    }

    public static Graph.Vertex findSet(@NotNull Graph.Vertex x) {
        if (x != x.p) x.p = findSet(x.p);
        return x.p;
    }
}
