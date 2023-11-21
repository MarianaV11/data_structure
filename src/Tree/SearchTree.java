package Tree;
public class SearchTree {
    private NodeAB root;

    public SearchTree() {
        root = null;
    }

    public void add(int element) {
        if(root == null) {
            root = new NodeAB(element);
        } else {
            add(element, root);
        }
    }

    private void add(int element, NodeAB root) {
        if(element == root.data) {
            root.count++;
        }

        if(element < root.data) {
            if(root.left == null) {
                root.left = new NodeAB(element);
            } else {
                add(element, root.left);
            }
        }

        if(element > root.data) {
            if(root.right == null) {
                root.right = new NodeAB(element);
            } else {
                add(element, root.right);
            }
        }
    }

    public boolean research(int element) {
        if(root == null) {
            return false;
        }
        return research(element, root);
    }

    private boolean research(int element, NodeAB root) {
        if(element == root.data) {
            return true;
        } else if(element < root.data) {
            if(root.left == null) return false;
            return research(element, root.left);
        } else if(element > root.data) {
            if(root.right == null) return false;
            return research(element, root.right);
        }

        return false;
    }

    public void remove(int element) {
        if(root != null) remove(element, root, null);
    }

    private void remove(int element, NodeAB root, NodeAB father) {
        if(element == root.data) {
            if(root.left == null && root.right == null) {
                if(root == father.left)
                    father.left = null;
                else
                    father.right = null;
            } else if(root.left != null && root.right == null) {
                if(root == father.left)
                    father.left = root.left;
                else
                    father.right = root.left;
            } else if(root.left == null && root.right != null) {
                if(root == father.left)
                    father.left = root.right;
                else
                    father.right = root.right;
            } else {
                root.data = lowerValue(root.right);
                remove(root.data, root.right, root);
            }
        } else if(element < root.data) {
            if(root.left != null)
                remove(element, root.left, root);
        } else {
            if(root.right != null)
                remove(element, root.right, root);
        }
    }

    private int lowerValue(NodeAB root) {
        if(root.left == null) return root.data;

        return lowerValue(root.left);
    }
    public void displayPostOrder() {
        if (root != null) {
            displayPostOrder(root);
            System.out.println();
        }
    }

    private void displayPostOrder(NodeAB root) {
        if (root.left != null) {
            displayPostOrder(root.left);
        }
        if (root.right != null) {
            displayPostOrder(root.right);
        }
        System.out.print(root.data + " ");
    }

    public void displayInOrder() {
        if (root != null) {
            displayInOrder(root);
            System.out.println();
        }
    }

    private void displayInOrder(NodeAB root) {
        if (root.left != null) {
            displayInOrder(root.left);
        }

        System.out.print(root.data + " ");

        if (root.right != null) {
            displayInOrder(root.right);
        }
    }

    public void displayPreOrder() {
        if (root != null) {
            displayPreOrder(root);
            System.out.println();
        }
    }

    private void displayPreOrder(NodeAB root) {
        System.out.print(root.data + " ");

        if (root.left != null) {
            displayPreOrder(root.left);
        }
        if (root.right != null) {
            displayPreOrder(root.right);
        }
    }
}
