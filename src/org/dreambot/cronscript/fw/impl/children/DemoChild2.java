package org.dreambot.cronscript.fw.impl.children;

import org.dreambot.cronscript.fw.Node;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        1-12-2015
 * API:         http://dreambot.org/javadocs/
 */
public class DemoChild2 extends Node {

    @Override
    public int priority() {
        return 2;
    }

    @Override
    public boolean valid() {
        return false;
    }

    @Override
    public int run() {
        /***
         * getClient().doStuff();
         */
        return 100;
    }
}
