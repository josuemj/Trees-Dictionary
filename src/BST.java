import java.util.ArrayList;

public class BST implements Tree{
    private Node root;

    private class Node {
        String key;
        String translation;
        Node left, right;

        public Node(String key, String translation) {
            this.key = key;
            this.translation = translation;
        }
    }

    // Insert the given key-value pair into the tree
    @Override
    public void insert(String key, String value) {
        root = insert(root, key, value);
    }

    // Insert the given key-value pair into the subtree rooted at x
    private Node insert(Node x, String key, String value) {
        if (x == null) {
            return new Node(key, value);
        }

        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = insert(x.left, key, value);
        } else if (cmp > 0) {
            x.right = insert(x.right, key, value);
        } else {
            x.translation = value;
        }
        return x;
    }

    // Search for the given key in the tree and return the translation
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

    @Override
    public void setNodes(ArrayList<String> translation) {

        for(int i = 0;i<translation.size();i++){
            System.out.println(translation.get(i));

        }
    }
}
