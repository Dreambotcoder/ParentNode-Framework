package org.dreambot.cronscript.fw;


/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        1-12-2015
 * API:         http://dreambot.org/javadocs/
 */
public abstract class Node extends MethodContainer {

    /**
     * Determines the order in the active node list
     * <p>
     * The lower the number, the higher the priority (example: 1 = #1 priority)
     * @return the priority
     */
    public abstract int priority();

    /**
     * The condition on which the run function of the Node has to run
     * @return {@code true} if and only if the node should be ran, {@code false} otherwise
     */
    public abstract boolean valid();

    /**
     * The action that will run if the Node is validated
     * @return The sleeptime after Node execution
     */
    public abstract int run();

}
