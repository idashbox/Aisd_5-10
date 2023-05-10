package tree.demo;

import tree.BinaryTreePainter;
import util.SwingUtils;

import javax.swing.*;
import java.awt.*;

public class TreeDemoFrame extends JFrame {
    private JPanel panelMain;
    private JButton buttonMakeTree;
    private JSplitPane splitPaneMain;
    private JPanel panelPaintArea;

    private JPanel paintPanel = null;

    BinaryTreeRandom.Node tree1 = null;


    public TreeDemoFrame() {
        this.setTitle("Двоичные деревья");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();


        splitPaneMain.setDividerLocation(0.5);
        splitPaneMain.setResizeWeight(1.0);
        splitPaneMain.setBorder(null);

        paintPanel = new JPanel() {
            private Dimension paintSize = new Dimension(0, 0);

            @Override
            public void paintComponent(Graphics gr) {
                super.paintComponent(gr);
                paintSize = BinaryTreePainter.paint(tree1, gr);
                if (!paintSize.equals(this.getPreferredSize())) {
                    SwingUtils.setFixedSize(this, paintSize.width, paintSize.height);
                }
            }
        };
        JScrollPane paintJScrollPane = new JScrollPane(paintPanel);
        panelPaintArea.add(paintJScrollPane);

        buttonMakeTree.addActionListener(actionEvent -> {
            try {
                BinaryTreeRandom.Node tree1 = BinaryTreeRandom.generateRandomBinaryTree(0, 100, 0.5, 0.5, 10);
                this.tree1 = tree1;
                repaintTree();
            } catch (Exception ex) {
                SwingUtils.showErrorMessageBox(ex);
            }
        });


    }
    /**
     * Перерисовка дерева
     */
    public void repaintTree() {
        paintPanel.repaint();
    }
}
