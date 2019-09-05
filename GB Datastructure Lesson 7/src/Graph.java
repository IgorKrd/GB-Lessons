import java.util.*;

public class Graph {

    private final List<Vertex> vertexList;
    private final boolean[][] adjMat;

    private LinkedList<String> previousVertexList = new LinkedList<>();

    private int size;

    public Graph(int maxVertexCount) {
        this.vertexList = new ArrayList<>();
        this.adjMat = new boolean[maxVertexCount][maxVertexCount];
        this.size = 0;
    }

    public void addVertex(String label) {
        vertexList.add(new Vertex(label));
        size++;
    }

    public int getSize() {
        return size;
    }

    public void addEdges(String startLabel, String secondLabel, String... other) {
        addEdge(startLabel, secondLabel);
        for (String anotherLabel : other) {
            addEdge(startLabel, anotherLabel);
        }
    }


    public void addEdge(String startLabel, String finishLabel) {
        int startIndex = indexOf(startLabel);
        int finishIndex = indexOf(finishLabel);

        if (startIndex == -1 || finishIndex == -1) {
            throw new IllegalArgumentException("Invalid vertex labels");
        }
        adjMat[startIndex][finishIndex] = true;
        adjMat[finishIndex][startIndex] = true;

    }

    private int indexOf(String startLabel) {

        for (int i = 0; i < size; i++) {
            if (vertexList.get(i).getLabel().equals(startLabel)) {
                return i;
            }
        }
        return -1;
    }

    public void display() {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("Graph size is: " + getSize());
        for (int i = 0; i < size; i++) {
            System.out.print(vertexList.get(i));
            for (int j = 0; j < size; j++) {
                if (adjMat[i][j]) {
                    System.out.print(" -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
        System.out.println("++++++++++++++++++++++++++++++++++++++++++");
    }

    public void bfsFind(String startLabel, String findLabel) {

        int startIndex = indexOf(startLabel);
        int findIndex = indexOf(findLabel);

        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }
        if (findIndex == -1) {
            throw new IllegalArgumentException("Invalid findLabel: " + findLabel);
        }

        Queue<Vertex> queue = new ArrayDeque<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(queue, vertex);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());

            if (vertex == null) {
                queue.remove();

            } else if (!vertex.getLabel().equals(findLabel)) {
                queue.add(vertex);
                vertex.setVisited(true);
            } else {
                previousVertexList.add(vertex.getLabel());
                System.out.println("Кратчайший путь от г. " + findLabel + " до г. " + startLabel + " проходит через: ");

                printTheShortestWay();
                break;
            }
        }
        resetVertexState();
    }


    // обход в ширину

    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }
        Queue<Vertex> queue = new ArrayDeque<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(queue, vertex);

        while (!queue.isEmpty()) {
            vertex = getNearUnvisitedVertex(queue.peek());
            if (vertex != null) {
                visitVertex(queue, vertex);
            } else {
                queue.remove();
            }
        }
        resetVertexState();
    }

    private void resetVertexState() {
        for (Vertex vertex : vertexList) {
            vertex.setVisited(false);
        }
    }

    private void visitVertex(Queue<Vertex> queue, Vertex vertex) {
        System.out.println(vertex.getLabel());
        queue.add(vertex);
        vertex.setVisited(true);
    }

// обход в глубину

    public void dfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        Stack<Vertex> stack = new Stack<>();
        Vertex vertex = vertexList.get(startIndex);
        visitVertex(stack, vertex);

        while (!stack.isEmpty()) {
            vertex = getNearUnvisitedVertex(stack.peek());
            if (vertex != null) {
                visitVertex(stack, vertex);
            } else {
                stack.pop();
            }
        }
        resetVertexState();
    }

    // обход в глубину рекурсивным способом

    public void dfsRec(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Invalid startLabel: " + startLabel);
        }

        Vertex vertex = vertexList.get(startIndex);
        dfsRec(vertex);

        resetVertexState();
    }

    private void dfsRec(Vertex vertex) {
        if (vertex == null) {
            return;
        }

        System.out.println(vertex.getLabel());
        vertex.setVisited(true);

        Vertex current = vertex;

        while (current != null) {
            current = getNearUnvisitedVertex(vertex);
            dfsRec(current);
        }
    }

    private void visitVertex(Stack<Vertex> stack, Vertex vertex) {
        System.out.println(vertex.getLabel());
        stack.push(vertex);
        vertex.setVisited(true);
    }

    private Vertex getNearUnvisitedVertex(Vertex currentVertex) {

        int currentIndex = vertexList.indexOf(currentVertex);

        for (int i = 0; i < size; i++) {
            if (adjMat[currentIndex][i] && !vertexList.get(i).getVisited()) {

                if (!previousVertexList.contains(currentVertex.getLabel())) {
                    previousVertexList.add(currentVertex.getLabel());
                }
                return vertexList.get(i);
            }
        }
        return null;
    }

    public void printTheShortestWay() {

        while (previousVertexList.size() >= 2) {
            String currentLast = previousVertexList.getLast();
            String preCurrLast = previousVertexList.get(previousVertexList.size() - 2);

            if (adjMat[(vertexList.indexOf(vertexList.get(indexOf(currentLast))))][(vertexList.indexOf(vertexList.get(indexOf(preCurrLast))))]) {
                System.out.println(currentLast + " -> " + preCurrLast);
                previousVertexList.remove(previousVertexList.getLast());
            } else {
                previousVertexList.remove(preCurrLast);
            }
        }
    }
}

