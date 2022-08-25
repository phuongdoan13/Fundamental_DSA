package Archived.DS3_Tree;
class Node {
    int val;
    Node left;
    Node right;
    public Node(int val){
        this.val = val;
    }
    public Node(int val, Node left, Node right){
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Tree{
    Node node;
    public Tree(int val){
        this.node = new Node(val);
    }
    boolean isFullBinaryTree(Node node){
        // Check if a tree is a full binary tree
        // O(n)
        if(node == null) return true;
        if(node.left == null && node.right == null) 
            return true;
        if(node.left != null && node.right != null) 
            return isFullBinaryTree(node.right) && isFullBinaryTree(node.left);
        return false;
    }
    
    boolean isCompleteBinaryTree(Node node){
        // Check if a tree is a complete binary tree
        // O(n)
        int numberOfNodes = this.countNumberOfNode(node);
        return checkCompleteBinaryTree(node, 0, numberOfNodes);
    }
    
    int countNumberOfNode(Node node){
        // Count the number of nodes in a tree
        // O(n)
        if(node == null)
            return 0;
        return (1 + countNumberOfNode(node.left) + countNumberOfNode(node.right));
    }
    
    boolean checkCompleteBinaryTree(Node node, int index, int numberOfNodes){
        // Recursive helper function to check a complete binary tree;
        // O(n)
        if(node == null)
            return true;
        
        if(index >= numberOfNodes)
            return false;
        
        return checkCompleteBinaryTree(node.left, 2 * index + 1, numberOfNodes) && checkCompleteBinaryTree(node.right, 2 * index + 2, numberOfNodes);
    }
    
    void inorderTraversal(Node node){
        if(node == null) return;
        inorderTraversal(node.left);
        System.out.print(node.val + " ");
        inorderTraversal(node.right);
    }

    void preorderTraversal(Node node){
        if(node == null) return;
        System.out.print(node.val + " ");
        inorderTraversal(node.left);
        inorderTraversal(node.right);
    }

    void postorderTraversal(Node node){
        if(node == null) return;
        inorderTraversal(node.left);
        inorderTraversal(node.right);
        System.out.print(node.val + " ");
    }
    public static void main(String[] args) {
        System.out.println("Normal Tree");
        Tree tree = new Tree(1);
        tree.node.left = new Node(2);
        tree.node.right = new Node(3);
        tree.node.left.right = new Node(5);
        tree.node.left.left = new Node(4);
        tree.node.right.left = new Node(6);
        System.out.println(tree.countNumberOfNode(tree.node));      
        System.out.println(tree.isFullBinaryTree(tree.node));
        System.out.println(tree.isCompleteBinaryTree(tree.node));   
        tree.inorderTraversal(tree.node);System.out.println();
        tree.preorderTraversal(tree.node);System.out.println();
        tree.postorderTraversal(tree.node);System.out.println();
        

        System.out.println("BST");
        BSTree bst = new BSTree(4);
        bst.add(3);
        bst.add(1);
        bst.add(8);
        bst.add(0);
        bst.add(3);
        bst.add(100);
        // bst.inorderTraversal(bst.node); System.out.println();
        // bst.delete(3);
        // bst.inorderTraversal(bst.node); System.out.println();
        bst.lowestCommonAncestor(bst.node.left, bst.node.right);


        
    }
}