package Laboratorio8.EjercicioPropuesto4;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.Graph;
import org.jgrapht.alg.visualization.VisualizationImageServer;
import org.jgrapht.ext.JGraphXAdapter;

import javax.swing.*;
import java.awt.*;

public class BTree<T extends Comparable<T>> {

    // Método para visualizar el árbol B
    public void visualizeTree() {
        Graph<String, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);

        // Añadir los nodos y las aristas
        addNodesAndEdges(graph, root);

        // Usamos JGraphT para crear un visualizador
        VisualizationImageServer<String, DefaultEdge> vv = new VisualizationImageServer<>(new JGraphXAdapter<>(graph), new Dimension(800, 600));

        // Personalizar el color de los nodos (negro)
        vv.getRenderContext().setVertexFillPaintTransformer(v -> Color.BLACK);  // Color de fondo de los nodos
        vv.getRenderContext().setVertexLabelTransformer(v -> v);  // Etiquetas de los nodos son los valores
        vv.getRenderContext().setEdgeLabelTransformer(e -> ""); // Sin etiquetas en las aristas

        // Personalizar el color de las aristas (negro)
        vv.getRenderContext().setEdgeDrawPaintTransformer(e -> Color.BLACK);  // Color de las aristas

        // Crear la ventana de visualización
        JFrame frame = new JFrame("Árbol B");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(vv));
        frame.pack();
        frame.setVisible(true);
    }

    // Método auxiliar para añadir nodos y aristas recursivamente
    private void addNodesAndEdges(Graph<String, DefaultEdge> graph, BNode<T> node) {
        if (node == null) {
            return;
        }

        // Convertimos el nodo a una representación de String
        String nodeLabel = node.isLeaf ? "Leaf: " + node.numKeys : "Internal: " + node.numKeys;
        graph.addVertex(nodeLabel);

        // Agregar las claves como etiquetas
        String keyLabel = "";
        for (int i = 0; i < node.numKeys; i++) {
            keyLabel += node.keys[i] + " ";
        }
        graph.addVertex(keyLabel); // Añadir claves como un nodo

        // Conectar el nodo con sus hijos
        for (int i = 0; i < node.numKeys + 1; i++) {
            if (node.children[i] != null) {
                String childLabel = node.children[i].isLeaf ? "Leaf: " + node.children[i].numKeys : "Internal: " + node.children[i].numKeys;
                graph.addVertex(childLabel);
                graph.addEdge(nodeLabel, childLabel);
                addNodesAndEdges(graph, node.children[i]);
            }
        }
    }
}

