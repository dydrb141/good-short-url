package com.example.multithreadstudy.ex01;

/**
 * @author YongKyu, Han
 */
public class BinarySerahTree {
	TreeNode root;

	public void insertTree(int number) {
		TreeNode newNode = new TreeNode(number);

		if (root == null) {
			root = newNode;
		} else {
			insertTree(number, root);
		}

	}

	public void insertTree(int number, TreeNode root) {
		if (number <= root.getData()) {
			if (root.leftTreeNode == null) {
				root.leftTreeNode = new TreeNode(number);
			} else {
				insertTree(number, root.leftTreeNode);
			}

		} else {
			if (root.rightTreeNode == null) {
				root.rightTreeNode = new TreeNode(number);
			} else {
				insertTree(number, root.rightTreeNode);
			}
		}
	}

	public boolean searchValue(int number) {
		TreeNode tempRoot = root;

		while (tempRoot != null) {
			if (tempRoot.getData() == number) {
				return true;
			}

			if (number <= root.getData())  {
				if (tempRoot.leftTreeNode != null && tempRoot.leftTreeNode.getData() == number) {
					return true;
				} else {
					tempRoot = tempRoot.leftTreeNode;
				}
			} else {
				if (tempRoot.rightTreeNode !=null && tempRoot.rightTreeNode.getData() == number) {
					return true;
				} else {
					tempRoot = tempRoot.rightTreeNode;
				}
			}
		}

		return false;
	}

	public void removeTree(int number, TreeNode treeNode) {
		//자식 노드를 찾음
		// 자식 노드가 없는 경우 :
		// 그냥 삭제

		// 자식 노드가 하나인 노드는 :
		// 1. 대상 노드 삭제, 2. 자식 노드를 삭제한 노드로 위치

		// 자식 노드가 하나 이상인 경우 :
		// 1. 대상 노드 삭제, 2. 삭제한 노드이 왼쪽 가지에서 최대 노드 찾음, 3. 삭제한 노드로 이동 시킴.

		//TreeNode treeNode = root;

		if (treeNode == null) {
			return;
		}

		treeNode = null;


		if (treeNode.getData() == number) {
			if (treeNode.leftTreeNode == null && treeNode.rightTreeNode == null) {
				treeNode = null;
			} else if (treeNode.leftTreeNode != null && treeNode.rightTreeNode == null) {
				treeNode = treeNode.leftTreeNode;
			} else if (treeNode.leftTreeNode == null && treeNode.rightTreeNode != null) {
				treeNode = treeNode.rightTreeNode;
			} else {
				TreeNode currentNode = treeNode;
				TreeNode topNode = null;

				while (currentNode != null) {
					if (currentNode.leftTreeNode.getData() >=  currentNode.rightTreeNode.getData()) {
						topNode = currentNode.leftTreeNode;
						currentNode = currentNode.leftTreeNode;
					} else {
						topNode = currentNode.rightTreeNode;
						currentNode = currentNode.rightTreeNode;
					}
				}

				treeNode = topNode;
			}

		} else {
			if (number <= treeNode.getData()) {
				removeTree(number, treeNode.leftTreeNode);
			} else {
				removeTree(number, treeNode.rightTreeNode);
			}
		}
	}


	public void reorderTree() {

	}

	public static void main(String[] args) {
		BinarySerahTree binarySerahTree = new BinarySerahTree();

		binarySerahTree.insertTree(15);
		binarySerahTree.insertTree(9);
		binarySerahTree.insertTree(3);
		binarySerahTree.insertTree(12);
		binarySerahTree.insertTree(1);
		binarySerahTree.insertTree(8);
		binarySerahTree.insertTree(4);
		binarySerahTree.insertTree(23);
		binarySerahTree.insertTree(17);
		binarySerahTree.insertTree(28);

		System.out.println(binarySerahTree.searchValue(28));

		binarySerahTree.removeTree(8, binarySerahTree.root);

	}

}
