package tree.demo;

import java.util.Random;

public class BinaryTreeRandom {
    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
        public int getValue() {
            return value;
        }
        public Node getLeft() {
            return left;
        }
        public Node getRight() {
            return right;
        }
    }

    private static Random rand = new Random();
    public static Node generateRandomBinaryTree(int minValue, int maxValue, double leftP, double rightP, int maxHeight) {
        if (maxHeight == 0 || rand.nextDouble() < 0.1) {
            return null;
        }
        int value = rand.nextInt(maxValue - minValue + 1) + minValue;
        Node node = new Node(value);
        if (rand.nextDouble() < leftP) {
            node.left = generateRandomBinaryTree(minValue, maxValue, leftP, rightP, maxHeight - 1);
        }
        if (rand.nextDouble() < rightP) {
            node.right = generateRandomBinaryTree(minValue, maxValue, leftP, rightP, maxHeight - 1);
        }
        return node;
    }

}

