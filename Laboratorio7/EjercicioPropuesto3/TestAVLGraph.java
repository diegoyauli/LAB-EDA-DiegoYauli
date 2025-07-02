package Laboratorio7.EjercicioPropuesto3;

import org.graphstream.graph.*;
import org.graphstream.graph.implementations.*;

public class TestAVLGraph {
    public static void main(String[] args) {
        System.setProperty("org.graphstream.ui", "swing");

        AVLTree<Integer> avl = new AVLTree<>();

        int[] datos = {10, 25, 30, 45, 12, 80, 2, 35, 24}; // orden de inserción
        for (int dato : datos) avl.insert(dato);

        displayGraph(avl.getRoot());
    }

    public static <T extends Comparable<T>> void displayGraph(NodeAVL<T> root) {
        Graph graph = new SingleGraph("AVL Tree");
        graph.setAttribute("ui.stylesheet", styleSheet());
        addNodes(graph, root, null, "");
        graph.display();
    }

    private static <T extends Comparable<T>> void addNodes(Graph graph, NodeAVL<T> node, NodeAVL<T> parent, String label) {
        if (node == null) return;

        String nodeId = node.getId();
        if (graph.getNode(nodeId) == null) {
            graph.addNode(nodeId).setAttribute("ui.label", nodeId);
        }

        if (parent != null) {
            String parentId = parent.getId();
            String edgeId = parentId + "-" + nodeId;
            if (graph.getEdge(edgeId) == null) {
                graph.addEdge(edgeId, parentId, nodeId, true).setAttribute("ui.label", label);
            }
        }

        addNodes(graph, node.left, node, "L");
        addNodes(graph, node.right, node, "R");
    }

    private static String styleSheet() {
        return """
            node {
                fill-color: blue;
                size: 30px;
                text-size: 18px;
                shape: circle;
                text-alignment: above;
                text-color: white;
            }
            edge {
                text-size: 14px;
                fill-color: black;
                arrow-shape: arrow;
                arrow-size: 10px, 5px;
            }
            """;
    }
}


