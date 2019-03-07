package com.syeedode.acommonsencetoalgorithmdatastructure.trees;


import java.util.Objects;

public class TreeService<T extends Comparable<T>> {
    private NodeInTree<T> root;

    public NodeInTree<T> insertData(T dataValue, NodeInTree<T> node) {
        if(nodeNotValid(node)) {
            node = new NodeInTree<>(dataValue, null, null);
        } else {
            if(dataValue.compareTo(node.data) <= 0) {
                if(Objects.isNull(node.left)){
                    node.left = new NodeInTree<>(dataValue, null, null);
                } else {
                    insertData(dataValue,node.left);
                }
            } else {
                if(Objects.isNull(node.right)) {
                    node.right = new NodeInTree<>(dataValue, null, null);
                } else {
                    insertData(dataValue, node.right);
                }
            }
        }
        return node;
    }

    public NodeInTree<T> searchData(T valueToSearchFor, NodeInTree<T> node) {
        if(isDataSetInvalid(valueToSearchFor, node)){
            return null;
        }

        if(valueToSearchFor.compareTo(node.data) == 0) {
            return node;
        } else if(valueToSearchFor.compareTo(node.data) < 0) {
            return searchData(valueToSearchFor, node.left);
        } else {
            return searchData(valueToSearchFor, node.right);
        }
    }

    public NodeInTree<T> deleteNode(T valueToDelete, NodeInTree<T> node) {

        if(isDataSetInvalid(valueToDelete, node)) {
            return null;
        } else if(valueToDelete.compareTo(node.data) < 0) {
            node.left = deleteNode(valueToDelete, node.left);
            return node;
        } else if(valueToDelete.compareTo(node.data) > 0) {
            node.right = deleteNode(valueToDelete, node.right);
            return node;
        } else {

            if(Objects.isNull(node.left)) {
                return node.right;
            } else if(Objects.isNull(node.right)) {
                return node.left;
            } else {
                node.right = lift(node.right, node);
                return node;
            }
        }
    }

    public NodeInTree<T> lift(NodeInTree<T> node, NodeInTree<T> nodeToDelete) {
        if(Objects.nonNull(node.left)) {
            node.left = lift(node.left, nodeToDelete);
            return node;
        } else {
            nodeToDelete.data = node.data;
            return node.right;
        }
    }

    public NodeInTree<T> personalDeleteNode(T valueToDelete, NodeInTree<T> node) {
        NodeInTree<T> nodeToDelete = new NodeInTree(Integer.valueOf(3), null, null);

        if(isDataSetInvalid(valueToDelete, node)) {
            return null;
        }

        if(valueToDelete.equals(node.data)) {
            if(nodeNotValid(node.left)) {
                return node.right;
            } else if (nodeNotValid(node.right)) {
                return node.left;
            }
        }

        return nodeToDelete;
    }

    private NodeInTree<T> assignSuccessor(NodeInTree<T> nodeToBeDeleted) {
        if(nodeNotValid(nodeToBeDeleted.left) && nodeNotValid(nodeToBeDeleted.right)) {
            return null;
        } else if(nodeIsValid(nodeToBeDeleted.right)) {
        }
        return new NodeInTree(Integer.valueOf(300), null, null);
    }

    private boolean isDataSetInvalid(T data, NodeInTree<T> node) {
        return Objects.isNull(data) || Objects.isNull(node) || Objects.isNull(node.data);
    }

    private static boolean nodeIsValid(NodeInTree node) {
        return Objects.nonNull(node) && Objects.nonNull(node.data);
    }

    public static boolean nodeNotValid(NodeInTree node) {
        return !nodeIsValid(node);
    }

    public NodeInTree<T> personalDeleteNode_backup(T valueToDelete, NodeInTree<T> node) {
        NodeInTree<T> nodeToDelete = new NodeInTree(Integer.valueOf(3), null, null);

        if(isDataSetInvalid(valueToDelete, node)) {
            return null;
        }

        if(valueToDelete.compareTo(node.data) < 0) {
            if(nodeIsValid(node.left) && valueToDelete.equals(node.left.data)) {
                nodeToDelete = node.left;
                node.left = assignSuccessor(node.left);
            } else {
                return personalDeleteNode(valueToDelete, node.left);
            }
        } else if(valueToDelete.compareTo(node.data) > 0) {
            return personalDeleteNode(valueToDelete, node.right);
        }

        return nodeToDelete;
    }
}
