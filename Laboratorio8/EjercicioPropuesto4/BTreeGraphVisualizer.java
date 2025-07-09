package Laboratorio8.EjercicioPropuesto4;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.visualization.VisualizationViewer;
import javax.swing.*;
import java.awt.*;

public class BTreeGraphVisualizer {
    public static void main(String[] args) {
        BTree<Integer> bTree = new BTree<>(2);
        bTree.insert(10);
        bTree.insert(20);
        bTree.insert(5);
        bTree.insert(6);
        bTree.insert(12);
        bTree.insert(30);
        bTree.insert(7);
        
        SimpleGraph<String, DefaultEdge> graph = new SimpleGraph<>(DefaultEdge.class);
        
        // Create graph from BTree structure
        addGraphNodesAndEdges(bTree, graph);

        // Visualize graph
        VisualizationViewer<String, DefaultEdge> vv = new VisualizationViewer<>(new org.jgrapht.alg.visualization.FruchtermanReingoldLayout<>(graph));
        vv.setPreferredSize(new Dimension(600, 600));

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(vv));
        frame.pack();
        frame.setVisible(true);
    }

    // Method to add nodes and edges based on BTree structure
    private static void addGraphNodesAndEdges(BTree<Integer> bTree, SimpleGraph<String, DefaultEdge> graph) {
        // Traverse the BTree and add nodes and edges accordingly
        // (Convert BTree structure to graph representation)
    }
}

