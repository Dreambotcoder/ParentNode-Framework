package org.dreambot.cronscript.fw;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        1-12-2015
 * API:         http://dreambot.org/javadocs/
 */
public abstract class ParentNode extends Node implements Comparator<Node> {

    private List<Node> childList;

    public ParentNode() {
        childList = new ArrayList<>();
    }

    @Override
    public int compare(Node o1, Node o2) {
        return o1.priority() - o2.priority();
    }

    public ParentNode registerChildren(Node... children) {
        for (Node child : children) {
            if (!childList.contains(child)) {
                childList.add(child);
            }
        }
        childList.sort(this);
        return this;
    }

    public void removeAllChildren() {
        childList.clear();
    }

    public Node getChildByClassname(String name) {
        return childList.stream()
                .filter(Objects::nonNull)
                .filter(child -> child.getClass().getSimpleName().equalsIgnoreCase(name))
                .findFirst()
                .get();
    }

    public void removeChildren(Node... children) {
        for (Node child : children) {
            if (childList.contains(child)) {
                childList.remove(child);
            }
        }
        childList.sort(this);
    }


    public Node[] getChildren() {
        return childList.toArray(new Node[childList.size()]);
    }

    public int run() {
        return childList.stream()
                .filter(Objects::nonNull)
                .filter(Node::valid)
                .findFirst()
                .get()
                .run();
    }

}
