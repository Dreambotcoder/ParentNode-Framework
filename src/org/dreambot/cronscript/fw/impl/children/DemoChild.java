package org.dreambot.cronscript.fw.impl.children;

import org.dreambot.cronscript.fw.Node;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        1-12-2015
 * API:         http://dreambot.org/javadocs/
 */
public class DemoChild extends Node {

    @Override
    public int priority() {
        return 1;
    }

    @Override
    public boolean valid() {
        return true;
    }

    @Override
    public int run() {
        /**
         * getClient().doStuff();
         */
        return 666;
    }
}
