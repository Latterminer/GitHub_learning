package jianzhi_offer;

public class NextTreeNode {
    public TreeNode3 getNextTreeNode(TreeNode3 currentNode){
        if (currentNode.right != null){
            return currentNode.right;
        }
        else if ( currentNode.father.left == currentNode){
            return currentNode.father;
        }
        else {
            while (currentNode.father.left != currentNode){
                currentNode = currentNode.father;
            }
            return currentNode.father;
        }
    }
}

class TreeNode3{
    public int data;
    public TreeNode3 father = null;
    public TreeNode3 left = null;
    public TreeNode3 right = null;
    public TreeNode3(int data) {
        this.data = data;
    }

    public TreeNode3(int data, TreeNode3 father, TreeNode3 left, TreeNode3 right) {
        this.data = data;
        this.father = father;
        this.left = left;
        this.right = right;
    }
}
