package Archived.DS3_Tree;

public class BSTree extends Tree{
    public BSTree(int val){
        super(val);

    }
    Node search(int val){
        // the node with the VAL;
        // Average case: O(log(n)), Worst case: O(n)
        return searchHelper(this.node, val);
    }
    private Node searchHelper(Node node, int VAL){
        // recursive method for finding node with val
        // Average case: O(log(n)), Worst case: O(n)
        if(node == null)
            return null;
        if(node.val == VAL)
            return node;
        else if(node.val > VAL)
            return searchHelper(node.right, VAL);
        else
            return searchHelper(node.left, VAL);
    }

    void add(int val){
        // add new val
        // Average case: O(log(n)), Worst case: O(n)
        addHelper(this.node, val);
    }

    private Node addHelper(Node node, int VAL){
        // recursive method for adding VAL
        // Average case: O(log(n)), Worst case: O(n)
        if(node == null)
            return new Node(VAL);
        if(node.val == VAL)
            return node;
        if(node.val < VAL)
            node.right = addHelper(node.right, VAL);
        else if(node.val > VAL)
            node.left = addHelper(node.left, VAL);
        return node;

    }

    void delete(int val){
        // delete the given value;
        // Average case: O(log(n)), Worst case: O(n)
        deleteHelper(this.node, val);
    }

    private Node deleteHelper(Node node, int VAL){
        // recursive method for deleting a node with given method;
        // Average case: O(log(n)), Worst case: O(n)
        if(node == null)
            return node;
        // find the node
        if(node.val < VAL){
            node.right = deleteHelper(node.right, VAL);
        }else if(node.val > VAL){
            node.left = deleteHelper(node.left, VAL);
        }else{
            // if the node has 0 or 1 child;
            if(node.left == null)
                return node.right;
            else if(node.right == null)
                return node.left;

            // if the node has 2 children;
            // copy the inorder successor value (i.e. the next smallest value )
            node.val = minValue(node.right);
            // delete the next successor node;
            node.right = deleteHelper(node.right, node.val);
        }
        return node;
    }

    private int minValue(Node node) {
        // find the min value of the (sub)tree.
        // Average case: O(log(n)), Worst case: O(n)
        int minv = node.val;
        while (node.left != null) {
            minv = node.left.val;
            node = node.left;
        }
        return minv;
    }
    
    Node lowestCommonAncestor(Node p, Node q) {
        int p_val = p.val;
        int q_val = q.val;
        int small_val = Math.min(p_val, q_val);
        int large_val = Math.max(p_val, q_val);
        Node curr = this.node;
        while(curr != null){

            if(curr.val < small_val) curr = curr.right;
            else if(curr.val > large_val) curr = curr.left;
            else return curr;

        }
        return null;
    }
}
