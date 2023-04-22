import java.util.ArrayList;
import java.util.HashMap;

public class SplayTree implements Tree{
    private SplayNode root;
    private class SplayNode {
        String key;
        String value;
        SplayNode left, right, parent;

        public SplayNode(String key, String value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }

    @Override
    public void insert(String key, String value) {
        if (root == null) {
            root = new SplayNode(key, value);
            return;
        }

        SplayNode node = search(key);
        if (key.compareTo(node.key) < 0) {
            node.left = new SplayNode(key, value);
            node.left.parent = node;
            splay(node.left);
        } else if (key.compareTo(node.key) > 0) {
            node.right = new SplayNode(key, value);
            node.right.parent = node;
            splay(node.right);
        } else {
            node.value = value;
            splay(node);
        }
    }

    @Override
    public String getTranslation(String key) {
        SplayNode node = search(key);
        if (node != null) {
            return node.value;
        }
        return null;
    }

    private SplayNode search(String key) {
        SplayNode node = root;
        while (node != null) {
            if (key.compareTo(node.key) < 0) {
                if (node.left == null) {
                    break;
                }
                node = node.left;
            } else if (key.compareTo(node.key) > 0) {
                if (node.right == null) {
                    break;
                }
                node = node.right;
            } else {
                break;
            }
        }
        splay(node);
        return node;
    }

    private void splay(SplayNode x) {
        while (x != root) {
            SplayNode parent = x.parent;
            if (parent == root) {
                if (x == parent.left) {
                    zig(x);
                } else {
                    zag(x);
                }
            } else {
                SplayNode grandparent = parent.parent;
                if (parent.left == x && grandparent.left == parent) {
                    zigzig(x);
                } else if (parent.right == x && grandparent.right == parent) {
                    zagzag(x);
                } else if (parent.right == x && grandparent.left == parent) {
                    zigzag(x);
                } else {
                    zigzag(x);
                }
            }
        }
    }

    private void zig(SplayNode x) {
        SplayNode parent = x.parent;
        parent.left = x.right;
        if (x.right != null) {
            x.right.parent = parent;
        }
        x.parent = null;
        x.right = parent;
        parent.parent = x;
        if (parent == root) {
            root = x;
        }
    }

    private void zag(SplayNode x) {
        SplayNode parent = x.parent;
        parent.right = x.left;
        if (x.left != null) {
            x.left.parent = parent;
        }
        x.parent = null;
        x.left = parent;
        parent.parent = x;
        if (parent == root) {
            root = x;
        }
    }

    private void zigzig(SplayNode x) {
        SplayNode parent = x.parent;
        SplayNode grandparent = parent.parent;
        SplayNode greatGrandparent = grandparent.parent;
        if (greatGrandparent != null) {
            if (greatGrandparent.left == grandparent) {
                greatGrandparent.left = x;
            } else {
                greatGrandparent.right = x;
            }
        }
        x.parent = greatGrandparent;
        parent.left = x.right;
        if (x.right != null) {
            x.right.parent = parent;
        }
        grandparent.left = parent.right;
        if (parent.right != null) {
            parent.right.parent = grandparent;
        }
        x.right = parent;
        parent.parent = x;
        x.left = grandparent;
        grandparent.parent = x;
        if (grandparent == root) {
            root = x;
        }
    }

    private void zagzag(SplayNode x) {
        SplayNode parent = x.parent;
        SplayNode grandparent = parent.parent;
        SplayNode greatGrandparent = grandparent.parent;
        grandparent.right = parent.left;
        if (parent.left != null) {
            parent.left.parent = grandparent;
        }
        if (greatGrandparent != null) {
            if (greatGrandparent.left == grandparent) {
                greatGrandparent.left = parent;
            } else {
                greatGrandparent.right = parent;
            }
        }
        parent.parent = greatGrandparent;
        parent.left = grandparent;
        grandparent.parent = parent;
        parent.right = x.left;
        if (x.left != null) {
            x.left.parent = parent;
        }
        x.parent = parent;
        grandparent.right = null;
        if (grandparent == root) {
            root = parent;
        }
    }

    private void zigzag(SplayNode x) {
        SplayNode parent = x.parent;
        SplayNode grandparent = parent.parent;
        SplayNode greatGrandparent = grandparent.parent;
        if (greatGrandparent != null) {
            if (greatGrandparent.left == grandparent) {
                greatGrandparent.left = x;
            } else {
                greatGrandparent.right = x;
            }
        }
        x.parent = greatGrandparent;
        grandparent.right = x.left;
        if (x.left != null) {
            x.left.parent = grandparent;
        }
        parent.left = x.right;
        if (x.right != null) {
            x.right.parent = parent;
        }
        x.left = grandparent;
        grandparent.parent = x;
        x.right = parent;
        parent.parent = x;
        if (grandparent == root) {
            root = x;
        }
    }

    @Override
    public void setNodes(ArrayList<String> translation) {
        for(int i = 0;i<translation.size();i++){
            System.out.println(translation.get(i));
        }
    }
}
