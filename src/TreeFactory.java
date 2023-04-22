public class TreeFactory {
    public static Tree getTree(String treeType){
        if (treeType.equals("Splay Tree")){
            return new SplayTree();
        } else if(treeType.equals("RBT")){
            return new RBTTree();
        }else if(treeType.equals("BST")){
            return new BST();
        }
        return null;
    }
}
