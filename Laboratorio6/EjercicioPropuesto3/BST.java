package Laboratorio6.EjercicioPropuesto3;

import org.graphstream.graph.Graph;
import org.graphstream.graph.implementations.SingleGraph;
import org.graphstream.ui.view.Viewer;

public class BST<E extends Comparable<E>> {
    private Node<E> root;

    public BST() {
        root = null;
    }

    public void insert(E x) {
        root = insertRec(root, x);
    }

    private Node<E> insertRec(Node<E> node, E x) {
        if (node == null) return new Node<>(x);

        int cmp = x.compareTo(node.getData());
        if (cmp < 0) {
            node.setLeft(insertRec(node.getLeft(), x));
        } else if (cmp > 0) {
            node.setRight(insertRec(node.getRight(), x));
        }
        return node;
    }

    public int size() {
        return size(root);
    }

    private int size(Node<E> node) {
        if (node == null) return 0;
        return 1 + size(node.getLeft()) + size(node.getRight());
    }

    public int rank(E key) {
        return rank(key, root);
    }

    private int rank(E key, Node<E> node) {
        if (node == null) return 0;
        int cmp = key.compareTo(node.getData());
        if (cmp < 0) return rank(key, node.getLeft());
        else if (cmp > 0) return 1 + size(node.getLeft()) + rank(key, node.getRight());
        else return size(node.getLeft());
    }

    public int depth(E key) {
        return depth(key, root, 1);
    }

    private int depth(E key, Node<E> node, int level) {
        if (node == null) return 0;
        if (node.getData().compareTo(key) == 0) return level;

        int left = depth(key, node.getLeft(), level + 1);
        if (left != 0) return left;

        return depth(key, node.getRight(), level + 1);
    }

    public void printTreeGraph() {
        String style =
            "node {" +
            "   text-alignment: right;" +
            "   text-offset: 10px, 0px;" +
            "   size: 15px, 15px;" +
            "   fill-color: #66ccff;" +
            "   text-size: 14px;" +
            "}";

        System.setProperty("org.graphstream.ui", "swing");
        Graph graph = new SingleGraph("Binary Search Tree");
        graph.setAttribute("ui.stylesheet", style);

        buildGraph(root, graph);

        Viewer viewer = graph.display();
        viewer.disableAutoLayout();
    }

    private void buildGraph(Node<E> x, Graph graph) {
        if (x == null) return;

        String id = x.getData().toString();
        org.graphstream.graph.Node n = graph.addNode(id);
        n.setAttribute("ui.label", id);
        n.setAttribute("x", rank(x.getData()));
        n.setAttribute("y", depth(x.getData()) * -1);

        if (x.getLeft() != null) {
            String leftId = x.getLeft().getData().toString();
            graph.addEdge(id + "-" + leftId, id, leftId);
            buildGraph(x.getLeft(), graph);
        }

        if (x.getRight() != null) {
            String rightId = x.getRight().getData().toString();
            graph.addEdge(id + "-" + rightId, id, rightId);
            buildGraph(x.getRight(), graph);
        }
    }
}
