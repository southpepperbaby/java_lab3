package ru.rasov.tree;

// Задача 2.4. Бинарное дерево поиска.
// Каждый узел хранит число; слева числа меньше или равные, справа больше.
// Сам объект Node, созданный в main, это корень всего дерева.
public class Node {

    private int value;
    private boolean hasValue; // false, пока значение ещё не задано
    private Node parent;
    private Node left;
    private Node right;

    public Node() {
    }

    // Добавление значения
    public void add(int newValue) {
        if (!hasValue) {          // узел пустой: просто кладём сюда
            value = newValue;
            hasValue = true;
            return;
        }
        if (newValue > value) {  
            if (right == null) {
                right = new Node();
                right.parent = this;
            }
            right.add(newValue);
        } else {                  
            if (left == null) {
                left = new Node();
                left.parent = this;
            }
            left.add(newValue);
        }
    }

    // Есть ли значение в этом узле или в его потомках
    public boolean contains(int searched) {
        return find(searched) != null;
    }

    // Ищем узел с нужным значением, идём влево или вправо как при добавлении
    private Node find(int searched) {
        if (!hasValue) {
            return null;
        }
        if (searched == value) {
            return this;
        }
        if (searched > value) {
            return (right == null) ? null : right.find(searched);
        } else {
            return (left == null) ? null : left.find(searched);
        }
    }

    // Удаление значения. Возвращает true, если что-то удалили.
    public boolean remove(int removed) {
        Node node = find(removed);
        if (node == null) {
            return false;
        }
        node.removeThisNode();
        return true;
    }

    private void removeThisNode() {
        // Случай 1: два потомка. Берём самое маленькое число из правой ветки,
        // кладём его сюда, а тот узел удаляем (у него максимум один потомок).
        if (left != null && right != null) {
            Node min = right;
            while (min.left != null) {
                min = min.left;
            }
            value = min.value;
            min.removeThisNode();
            return;
        }

        // Случай 2: потомков 0 или 1. Ставим единственного потомка на наше место.
        Node child = (left != null) ? left : right;

        if (parent == null) {
            // это корень, его объект заменить нельзя, поэтому копируем потомка в себя
            if (child == null) {
                hasValue = false; // дерево стало пустым
            } else {
                value = child.value;
                left = child.left;
                right = child.right;
                if (left != null) left.parent = this;
                if (right != null) right.parent = this;
            }
            return;
        }

        // обычный узел: родитель теперь указывает на нашего потомка вместо нас
        if (parent.left == this) {
            parent.left = child;
        } else {
            parent.right = child;
        }
        if (child != null) {
            child.parent = parent;
        }
    }

    // Обход в глубину, левая ветка первой: левое поддерево, сам узел, правое поддерево.
    // Обход выдаёт числа по возрастанию.
    @Override
    public String toString() {
        if (!hasValue) {
            return "";
        }
        String result = "";
        if (left != null) {
            result += left.toString() + " ";
        }
        result += value;
        if (right != null) {
            result += " " + right.toString();
        }
        return result;
    }
}
