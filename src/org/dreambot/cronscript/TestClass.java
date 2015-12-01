package org.dreambot.cronscript;


import org.dreambot.cronscript.fw.Node;
import org.dreambot.cronscript.fw.NodeManager;
import org.dreambot.cronscript.fw.ParentNode;
import org.dreambot.cronscript.fw.impl.DemoParent;
import org.dreambot.cronscript.fw.impl.DemoParent2;
import org.dreambot.cronscript.fw.impl.children.DemoChild;
import org.dreambot.cronscript.fw.impl.children.DemoChild2;

/**
 * Project:     Dreambot
 * Author:      Articron
 * Date:        1-12-2015
 * API:         http://dreambot.org/javadocs/
 */
public class TestClass {


    public static void main(String... args) {
        NodeManager manager = new NodeManager();
        manager.addParents(
                new DemoParent().registerChildren(new DemoChild2(), new DemoChild()),
                new DemoParent2().registerChildren(new DemoChild())
        );
        ParentNode parent = manager.getParentByClassname("testparent");
        for (Node children : parent.getChildren()) {
            System.out.println(children.getClass().getSimpleName());
        }
        parent.removeChildren(parent.getChildByClassname("childtest"));
        for (Node children : parent.getChildren()) {
            System.out.println(children.getClass().getSimpleName());
        }
    }
}
