package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/

public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {

    Entry<String> root;
    List<Entry<String>> list;

    public CustomTree() {
        this.root = new Entry<>("0");
        root.parent = root;
        list = new ArrayList<>();
        list.add(root);
    }

    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String set(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, String element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String remove(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean add(String elementName) {
        // Создаем новую сущность
        Entry<String> newEntry = new Entry<>(elementName);
        // Возможность добавления
        boolean availableAdd = false;
        // Проходимся по списку
        for (Entry<String> entry : list ) {
            if (entry.isAvailableToAddChildren()) {
                if (entry.availableToAddLeftChildren) {
                    entry.leftChild = newEntry;
                    entry.availableToAddLeftChildren = false;
                    newEntry.parent = entry;
                    availableAdd = true;
                    newEntry.countDeepLeft = entry.countDeepLeft + 2;
                    break;
                } else if (entry.availableToAddRightChildren) {
                    entry.rightChild = newEntry;
                    entry.availableToAddRightChildren = false;
                    newEntry.parent = entry;
                    availableAdd = true;
                    newEntry.countDeepLeft = entry.countDeepLeft + 1;
                    break;
                }
            }
        }

        if (!availableAdd) {
            int maxDeep = 0;
            for (Entry<String> entry : list) {
                if (entry.countDeepLeft > maxDeep) {
                    maxDeep = entry.countDeepLeft;
                }
            }
            for (Entry<String> entry : list) {
                if (entry.countDeepLeft == maxDeep) {
                    entry.leftChild = newEntry;
                    entry.availableToAddLeftChildren = false;
                    newEntry.parent = entry;
                    newEntry.countDeepLeft = entry.countDeepLeft + 2;
                }
            }
        }
        return list.add(newEntry);
    }

    @Override
    public boolean remove(Object o) {
        // Если объект не принадлежит к String кидаем исключение
        if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }
        // Проходимя по циклу
        for (Entry<String> entry : list) {
            // Если имя совпадает с текущим
            if (entry.getName().equals(o)) {
                // Удаляем детей и из листа
                removeChild(entry);
                list.remove(entry);
                break;
            }
        }
        return true;
    }

    private void removeChild(Entry<String> entry) {
        // Если левый не null и есть в списке
        if (entry.leftChild != null && list.contains(entry.leftChild)) {
            // Удаляем рекурсивно
            removeChild(entry.leftChild);
        }
        // Если правый не null и есть в списке
        if (entry.rightChild != null && list.contains(entry.rightChild)) {
            // Удаляем рекурсивно
            removeChild(entry.rightChild);
        }
        // Удаляем из листа
        list.remove(entry);
    }

    @Override
    public int size() {
        // Размер списка без учета корня
        return list.size() - 1;
    }

    public String getParent(String elementName) {
        for (Entry<String> entry : list) {
            if (!entry.getName().equals("0")) {
                if (entry.getName().equals(elementName) && entry.parent != null) {
                    return entry.parent.getName();
                }
            }

        }
        return null;
    }

    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren, availableToAddRightChildren;
        Entry<T> parent, leftChild, rightChild;
        int countDeepLeft;

        public Entry(String elementName) {
            this.elementName = elementName;
            availableToAddLeftChildren = true;
            availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren || availableToAddRightChildren;
        }

        public String getName() {
            return elementName;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "elementName='" + elementName + '\'' +
                    '}';
        }
    }
}
