/*
 * HalfNES by Andrew Hoffman
 * Licensed under the GNU GPL Version 3. See LICENSE file
 */
package com.grapeshot.halfnes;

import com.grapeshot.halfnes.ui.SwingUI;

import java.io.*;
import javax.swing.*;

public class halfNES {

    private halfNES() {}

    public static void main(String[] args) throws IOException {
        NESContext.setPrefs(new JavaPrefs());
        JInputHelper.setupJInput();
        try {
            UIManager.getSystemLookAndFeelClassName();
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            System.err.println("Could not set system look and feel. Meh.");
        }
        new SwingUI().start(args);
    }

}
