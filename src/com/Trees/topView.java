package com.Trees;

import java.util.*;
import java.io.*;

class NodeTopView {
    NodeTopView left;
    NodeTopView right;
    int data;

    NodeTopView(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class topView {
    /*

    class NodeTopView
        int data;
        NodeTopView left;
        NodeTopView right;
    */
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void topView(NodeTopView root) {
        if(root != null)
            topViewCalc(root, 0);
        else
            return;

        TreeMap<Integer, Integer> sortedMap = new TreeMap<>(map);

        for(Map.Entry<Integer, Integer> entry : sortedMap.entrySet()){
            System.out.print(entry.getValue() + " ");
        }

    }

    public static void topViewCalc(NodeTopView root, int dist){
        if(!map.containsKey(dist)){

            map.put(dist, root.data);
        }
//        else{
//            if(root.left != null && !map.containsKey(dist-1)){
        if(root.left != null){
            topViewCalc(root.left, dist - 1);
        }
//            if(root.right != null && !map.containsKey(dist+1)){
        if(root.right != null){
            topViewCalc(root.right, dist + 1);
        }
//        }
    }

    public static NodeTopView insert(NodeTopView root, int data) {
        if(root == null) {
            return new NodeTopView(data);
        } else {
            NodeTopView cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(new FileInputStream(new File("input/dummy")));
        int t = scan.nextInt();
        NodeTopView root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }
}