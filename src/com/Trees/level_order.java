package com.Trees;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

class NodeX{
    NodeX left,right;
    int data;
    NodeX(int data){
        this.data=data;
        left=right=null;
    }
}

class Solution{
    static void levelOrder(NodeX root){
        //Write your code here
        Queue<NodeX> q = new LinkedList<>();
        q.add(root);
        NodeX sp = new NodeX(-1);
        q.add(sp);
        StringBuilder s = new StringBuilder();

        while(!q.isEmpty()){
            NodeX temp = q.poll();
            if(temp != null && temp.data == -1 && temp.right == null && temp.left == null){
                q.add(sp);
                temp = q.poll();
                if(temp.data == -1){
                    break;
                }
            }
            if(temp != null) {
                s.append(temp.data);
                if (temp.left != null){
                    q.add(temp.left);
                }
                if (temp.right != null){
                    q.add(temp.right);
                }
            }
        }

        System.out.println(s.toString());
    }

    private static NodeX insert(NodeX root, int data){
        if(root==null){
            return new NodeX(data);
        }
        else{
            NodeX cur;
            if(data<=root.data){
                cur=insert(root.left,data);
                root.left=cur;
            }
            else{
                cur=insert(root.right,data);
                root.right=cur;
            }
            return root;
        }
    }
    
    public static void main(String args[]) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream(new File("input/dummy")));
        int T=sc.nextInt();
        NodeX root=null;
        while(T-->0){
            int data=sc.nextInt();
            root=insert(root,data);
        }
        levelOrder(root);
    }
}