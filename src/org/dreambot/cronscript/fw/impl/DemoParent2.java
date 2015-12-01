package org.dreambot.cronscript.fw.impl;

import org.dreambot.cronscript.fw.ParentNode;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        1-12-2015
 * API:         http://dreambot.org/javadocs/
 */
public class DemoParent2 extends ParentNode {

    @Override
    public int priority() {
        return 2;
    }

    @Override
    public boolean valid() {
        return true;
    }
}
