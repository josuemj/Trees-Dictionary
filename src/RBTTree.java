import java.util.ArrayList;

public class RBTTree implements Tree {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private Node root;

    // Red-Black Tree node class
    private class Node {
        String key;
        String translation;
        Node left, right;
        boolean color;

        public Node(String key, String translation) {
            this.key = key;
            this.translation = translation;
            this.color = RED;
        }
    }

    // Rotate left at node x
    private Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        y.color = x.color;
        x.color = RED;
        return y;
    }

    // Rotate right at node x
    private Node rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        y.color = x.color;
        x.color = RED;
        return y;
    }

    // Flip colors of node x and its two children
    private void flipColors(Node x) {
        x.color = !x.color;
        x.left.color = !x.left.color;
        x.right.color = !x.right.color;
    }

    // Return the value associated with the given key, or null if the key is not in the tree
    @Override
    public String getTranslation(String key) {
        Node x = root;
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.translation;
            }
        }
        return null;
    }

    // Insert the given key-value pair into the tree
    @Override
    public void insert(String key, String value) {
        root = put(root, key, value);
        root.color = BLACK;
    }

    // Insert the given key-value pair into the subtree rooted at x
    private Node put(Node x, String key, String value) {
        if (x == null) {
            return new Node(key, value);
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, value);
        } else if (cmp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.translation = value;
        }

        // Balance the tree by rotating and coloring nodes as necessary
        if (isRed(x.right) && !isRed(x.left)) {
            x = rotateLeft(x);
        }
        if (isRed(x.left) && isRed(x.left.left)) {
            x = rotateRight(x);
        }
        if (isRed(x.left) && isRed(x.right)) {
            flipColors(x);
        }

        return x;
    }

    // Returns true if the given node is red, false otherwise
    private boolean isRed(Node x) {
        if (x == null) {
            return false;
        }
        return x.color == RED;
    }

    @Override
    public void setNodes(ArrayList<String> translation) {

        for(int i = 0;i<translation.size();i++){
            System.out.println(translation.get(i));

        }
    }
}

