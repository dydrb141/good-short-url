package com.example.multithreadstudy.ex01;

/**
 * @author YongKyu, Han
 */
public class TreeNode {
	int data;
	TreeNode leftTreeNode;
	TreeNode rightTreeNode;

	public TreeNode() {
		this.leftTreeNode = null;
		this.rightTreeNode = null;
	}

	public TreeNode(int data) {
		this.data = data;
		this.leftTreeNode = null;
		this.rightTreeNode = null;
	}

	public int getData() {
		return data;
	}
}
