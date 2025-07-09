package Laboratorio8.EjercicioPropuesto8;

import javax.swing.*;

public class ArbolBPlusVisualizer<T extends Comparable<T>> {
    public void mostrar(BPlusTree<T> tree) {
        JFrame frame = new JFrame("Visualización Árbol B+");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.getContentPane().add(new JScrollPane(new BPlusTreeVisualizer<>(tree)));
        frame.pack();
        frame.setVisible(true);
    }
}

