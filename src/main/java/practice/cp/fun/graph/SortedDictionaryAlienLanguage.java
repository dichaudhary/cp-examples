package practice.cp.fun.graph;

import java.util.Stack;

public class SortedDictionaryAlienLanguage {
    String[] sortedWords;
    int V;
    TopologicalSorting topologicalSorting;

    public SortedDictionaryAlienLanguage(String[] sortedWords, int V) {
        this.sortedWords = sortedWords;
        this.V = V;
        this.topologicalSorting = new TopologicalSorting(this.V, 0);
    }

    public Stack<Integer> getSortedVertices() {
        for (int i=0; i<sortedWords.length-1; i++) {
            for (int j=0; j<Math.min(sortedWords[i].length(),sortedWords[i+1].length()); j++) {
                if (sortedWords[i].charAt(j) != sortedWords[i+1].charAt(j)) {
                    if (topologicalSorting.adj.get(sortedWords[i+1].charAt(j)-'a').contains(sortedWords[i].charAt(j)-'a')) {
                        return null;
                    }
                    topologicalSorting.addEdge(sortedWords[ i ].charAt(j) - 'a', new Node(sortedWords[ i ].charAt(j) - 'a', sortedWords[ i + 1 ].charAt(j) - 'a', 0));
                    break;
                }
            }
        }
        Stack<Integer> topologicalStack = new Stack<Integer>();
        boolean[] visited = new boolean[ V ];
        for (int v=0; v<V; v++) {
            if (!visited[v]) {
                this.topologicalSorting.topologicalSortingUtil(v, visited, topologicalStack);
            }
        }
        return topologicalStack;
    }
}
