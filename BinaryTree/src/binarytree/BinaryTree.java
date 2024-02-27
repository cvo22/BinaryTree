/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binarytree;

/**
 *
 * @author Гамаюнов Иван
 */
// Класс BinaryTree реализует структуру данных бинарное дерево.
public class BinaryTree {

    // Внутренний класс Node представляет узел дерева.
    private static class Node {
        private Object data;
        private Node left;
        private Node right;

        public Node(Object data) {
            this.data = data;
        }
    }

    // Корень дерева.
    private Node root;

    // Размер дерева.
    private int size;

    // Добавляет элемент в дерево.
    public void add(Object data) {
        root = add(root, data);
        size++;
    }

    // Рекурсивно добавляет элемент в дерево.
    private Node add(Node node, Object data) {
        if (node == null) {
            return new Node(data);
        }
        if ((Integer) data < (Integer) node.data) {
            node.left = add(node.left, data);
        } else {
            node.right = add(node.right, data);
        }
        return node;
    }

    // Удаляет элемент из дерева.
    public void remove(Object data) {
        root = remove(root, data);
        size--;
    }

    // Рекурсивно удаляет элемент из дерева.
    private Node remove(Node node, Object data) {
        if (node == null) {
            return null;
        }
        if ((Integer) data < (Integer) node.data) {
            node.left = remove(node.left, data);
        } else if ((Integer) data > (Integer) node.data) {
            node.right = remove(node.right, data);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }
            node.data = findMin(node.right).data;
            node.right = remove(node.right, node.data);
        }
        return node;
    }

    // Находит минимальный элемент в дереве.
    private Node findMin(Node node) {
        if (node.left == null) {
            return node;
        }
        return findMin(node.left);
    }

    // Проверяет, содержит ли дерево элемент.
    public boolean contains(Object data) {
        return contains(root, data);
    }

    // Рекурсивно проверяет, содержит ли дерево элемент.
    private boolean contains(Node node, Object data) {
        if (node == null) {
            return false;
        }
        if ((Integer) data < (Integer) node.data) {
            return contains(node.left, data);
        } else if ((Integer) data > (Integer) node.data) {
            return contains(node.right, data);
        } else {
            return true;
        }
    }

    // Возвращает размер дерева.
    public int size() {
        return size;
    }

    // Проверяет, пусто ли дерево.
    public boolean isEmpty() {
        return size == 0;
    }

    // Очищает дерево.
    public void clear() {
        root = null;
        size = 0;
    }

    // Выводит дерево в консоль.
    public void print() {
        print(root);
    }

    // Рекурсивно выводит дерево в консоль.
    private void print(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        print(node.left);
        print(node.right);
    }

    // Пример использования бинарного дерева.
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        // Добавляем элементы в дерево.
        tree.add(10);
        tree.add(5);
        tree.add(15);
        tree.add(2);
        tree.add(7);
        tree.add(12);
        tree.add(20);

        // Выводим дерево в консоль.
        System.out.println("Дерево:");
        tree.print();

        // Удаляем элемент из дерева.
        tree.remove(15);

        // Выводим дерево в консоль.
        System.out.println("Дерево после удаления элемента 15:");
        tree.print();

        // Проверяем, содержит ли дерево элемент.
        System.out.println("Дерево содержит элемент 7? " + tree.contains(7));

        // Возвращаем размер дерева.
        System.out.println("Размер дерева:");
        System.out.println(tree.size());

        // Проверяем, пусто ли дерево.
        System.out.println("Дерево пусто? " + tree.isEmpty());

        // Очищаем дерево.
        tree.clear();

        // Проверяем, пусто ли дерево.
        System.out.println("Дерево пусто? " + tree.isEmpty());
    }
}
