package week03;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class ConstructBinaryTree {

    private int[] inorder; // 中序遍历数组
    private int[] postorder; // 后序遍历数组

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.inorder=inorder;
        this.postorder=postorder;
        // 递归调用，四个参数分别是：后续遍历的开始、结束；中序遍历的开始、结束
        return build(0,postorder.length-1,0,inorder.length-1);
    }

    // 思想：后续遍历的最后一个值是 根节点
    // 中序遍历 根节点左侧的是 左子树，根节点右侧的是 右子树
    private TreeNode build(int l1,int r1,int l2,int r2) { // 四个参数分别是：后续遍历的开始、结束；中序遍历的开始、结束
        if (l1 > r1) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[r1]);// 后续遍历的最后一个值是 根节点
        int mid = l2;
        while (inorder[mid] != root.val) { // 相等的时候，mid就是root在中序遍历中的位置
            mid++;
        }
        // 中序序列 (l2...mid-1, mid , mid+1,r2)
        root.left = build(l1, l1 -1 + (mid - l2), l2, mid - 1);
        root.right = build(l1 + (mid - l2) , r1-1, mid + 1, r2);
        return root;
    }

    public static void main(String[] args) {
        int inorder[] =new int[]{9,3,15,20,7}; // 中序遍历
        int postorder[] =new int[]{9,15,7,20,3};// 后序遍历
        ConstructBinaryTree s= new ConstructBinaryTree();
        TreeNode treeNode = s.buildTree(inorder, postorder);
        System.out.println(treeNode.val);
    }
}
