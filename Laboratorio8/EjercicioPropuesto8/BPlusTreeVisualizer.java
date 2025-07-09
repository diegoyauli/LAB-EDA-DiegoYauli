package Laboratorio8.EjercicioPropuesto8;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class BPlusTreeVisualizer<T extends Comparable<T>> extends JPanel {
    private final BPlusTree<T> tree;
    private final int nodeWidth = 60;
    private final int nodeHeight = 30;
    private final int verticalGap = 50;
    private final int horizontalGap = 20;

    public BPlusTreeVisualizer(BPlusTree<T> tree) {
        this.tree = tree;
        setPreferredSize(new Dimension(1200, 800));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (!tree.isEmpty()) {
            drawNode(g, tree.getRoot(), getWidth() / 2, 30, getWidth() / 4);
        }
    }

    private void drawNode(Graphics g, BPlusNode<T> node, int x, int y, int offset) {
        Graphics2D g2 = (Graphics2D) g;

        // Dibujar nodo (rectángulo con claves)
        int totalKeyWidth = node.keys.size() * nodeWidth;
        int startX = x - totalKeyWidth / 2;

        for (int i = 0; i < node.keys.size(); i++) {
            int rectX = startX + i * nodeWidth;
            g2.setColor(Color.LIGHT_GRAY);
            g2.fillRect(rectX, y, nodeWidth, nodeHeight);
            g2.setColor(Color.BLACK);
            g2.drawRect(rectX, y, nodeWidth, nodeHeight);
            g2.drawString(node.keys.get(i).toString(), rectX + 20, y + 20);
        }

        // Dibujar hijos si no es hoja
        if (!node.isLeaf) {
            int childX = x - (node.children.size() - 1) * offset / 2;
            for (int i = 0; i < node.children.size(); i++) {
                BPlusNode<T> child = node.children.get(i);
                int childCenterX = childX + i * offset;
                int childY = y + verticalGap;

                // Línea del padre al hijo
                g2.drawLine(x, y + nodeHeight, childCenterX, childY);

                // Recursivo
                drawNode(g2, child, childCenterX, childY, offset / 2);
            }
        }
    }
}

