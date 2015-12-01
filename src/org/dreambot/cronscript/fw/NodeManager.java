package org.dreambot.cronscript.fw;

import java.util.*;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        1-12-2015
 * API:         http://dreambot.org/javadocs/
 */
public class NodeManager implements Comparator<ParentNode> {

    //Our list of parents currently present in the manager
    List<ParentNode> parentList;

    //Sleep if no valid nodes are found
    private final int LOOP_SLEEP = 666;

    public NodeManager() {
        parentList = new ArrayList<>();
    }

    /**
     * Adds parents to the manager
     * @param parents Parents to add to the manager
     */
    public void addParents(ParentNode... parents) {
        for (ParentNode parent : parents) {
            if (!parentList.contains(parent)) {
                parentList.add(parent);
            }
        }
    }

    /**
     * Removes parents from the manager
     * @param parents Parents to remove from the manager
     */
    public void removeParents(ParentNode... parents) {
        for (ParentNode parent : parents) {
            if (parentList.contains(parent)) {
                parentList.remove(parent);
            }
        }
    }

    /**
     * Gets all {@link org.dreambot.cronscript.fw.ParentNode}s currently in the manager
     * @return An array of all {@link org.dreambot.cronscript.fw.ParentNode}s currently in the manager
     */
    public ParentNode[] getParentNodes() {
        return parentList.toArray(new ParentNode[parentList.size()]);
    }

    /**
     * @param name the classname of the {@link org.dreambot.cronscript.fw.ParentNode} to grab
     * @return The {@link org.dreambot.cronscript.fw.ParentNode} in the manager with the given classname
     */
    public ParentNode getParentByClassname(String name) {
        return parentList.stream()
                .filter(Objects::nonNull)
                .filter(parent -> parent.getClass().getSimpleName().equalsIgnoreCase(name))
                .findFirst()
                .get();
    }


    /**
     * Call this in your onLoop in your main class
     * @return the loop cycle sleep time
     */
    public int onLoop() {
        for (ParentNode parent : parentList) {
            if (parent.valid()) {
                return parent.run();
            }
        }
        return LOOP_SLEEP;
    }

    @Override
    public int compare(ParentNode o1, ParentNode o2) {
        return o1.priority() - o2.priority();
    }
}
