package com.reacher.avltree;

public class AVLTree<T extends Comparable<T>> {
	
    private Node root;    // 根结点

    /**
     * 获取某子树的高度
     * @param root
     * @return
     */
    private int height(Node root) {
        return null == root ? 0 : root.height;
    }

    /**
     * 获取AVL树的高度
     * @return
     */
    public int height() {
        return height(this.root);
    }

    /**
     * 前序遍历"AVL树"
     * @param tree
     */
    public void inOrder() {
    	inOrder(this.root);
    }
    
    private void inOrder(Node root) {
    	if(null == root) {
    		return;
    	}
    	inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    /**
     * (非递归实现)查找"AVL树"中值为data的节点
     * @param root
     * @param key
     * @return
     */
    public Node search(T key) {
        return search(root, key);
    }
    
    private Node search(Node root, T data) {
        while (null != root) {
            int cmp = data.compareTo(root.data);
            if(0 == cmp) {
            	return root;
            }
            root = 0 > cmp ? root.left : root.right;
        }
        return null;
    }

    /**
     * 左单旋转
     * @param root
     * @return 旋转后的根节点
     */
    private Node leftRotation(Node root) {
        Node p = root.left;
        
        root.left = p.right;
        p.right = root;

        root.height = AVLTreeUtils.max(height(root.left), height(root.right)) + 1;
        p.height = AVLTreeUtils.max(height(p.left), root.height) + 1;
        
        return p;
    }

    /**
     * 右单旋转
     * @param root
     * @return 旋转后的根节点
     */
    private Node rightRotation(Node root) {
        Node p = root.right;

        root.right = p.left;
        p.left = root;

        root.height = AVLTreeUtils.max( height(root.left), height(root.right)) + 1;
        p.height = AVLTreeUtils.max( height(p.right), root.height) + 1;

        return p;
    }

    /**
     * 先右再左
     * @param root
     * @return　旋转后的根节点
     */
    private Node leftRightRotation(Node root) {
    	
        root.left = rightRotation(root.left);

        return leftRotation(root);
    }

    /**
     * 先左再右
     * @param root
     * @return
     */
    private Node rightLeftRotation(Node root) {
    	
        root.right = leftRotation(root.right);

        return rightRotation(root);
    }
    
    public void insert(T data) {
        this.root = insert(this.root, data);
    }

    /**
     * 将结点插入到AVL树中
     * @param root AVL树的根结点
     * @param node 插入的结点的键值
     * @return 根节点
     */
    private Node insert(Node root, T data) {
    	if(null == root) {
    		return new Node(data);
    	}
		int cmp = data.compareTo(root.data);
		if(0 == cmp) {
        	System.out.println("不允许添加相同的节点");
        	return root;
        }
		if(0 > cmp) {//将节点插入到左子树
        	root.left = this.insert(root.left, data);
        	if(1 < this.height(root.left) - this.height(root.right)) {//判断是否平衡
        		if(data.compareTo(root.left.data) < 0) {
        			root = this.leftRotation(root);
        		} else {
        			root = this.leftRightRotation(root);
        		}
        	}
        } else {
        	root.right = this.insert(root.right, data);
        	if(1 < this.height(root.right) - this.height(root.left)) {//判断是否平衡
        		if(data.compareTo(root.right.data) > 0) {
        			root = this.rightRotation(root);
        		} else {
        			root = this.rightLeftRotation(root);
        		}
        	}
        }
    	root.height = AVLTreeUtils.max(height(root.left), height(root.right)) + 1;
    	
    	return root;
    }
    
    private class Node {
        private T data;
        private Node left;
        private Node right;
        private int height;

        public Node(T data) {
            this.data = data;
            this.height = 1;
        }
    }
}
