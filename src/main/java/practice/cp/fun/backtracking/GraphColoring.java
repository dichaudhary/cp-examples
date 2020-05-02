package practice.cp.fun.backtracking;

public class GraphColoring {
    int V;
    int[][] graph;
    int[] color;
    int m;

    public GraphColoring(int[][] graph, int[] color, int V, int m) {
        this.V = V;
        this.graph = graph;
        this.color = color;
        this.m = m;
    }

    public int[] colorGraph() {
        colorGraphUtil(0);
        return this.color;
    }

    private boolean colorGraphUtil(int v) {
        if (v>=V) {
            return true;
        }
        for (int i=1; i<=m; i++) {
            if(isSafe(v, i)) {
                this.color[v] = i;
                if (colorGraphUtil(v+1)) {
                    return true;
                }
                this.color[v] = 0;
            }
        }
        return false;
    }

    private boolean isSafe(int v, int color) {
        if (v >= V) {
            return true;
        }
        for (int i=0; i<V; i++) {
            if (graph[v][i] == 1 && this.color[i] == color) {
                return false;
            }
        }
        return true;
    }
}
