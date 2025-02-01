package org.example;

import javax.swing.*;

public class AppJOptionPane {

    public AppJOptionPane() {
        //initJOptionPane();
        //initShowDialog();
        //initInputDialog();
        initSecretMessage();
    }


    private void initJOptionPane() {
        JOptionPane.showMessageDialog(
                null,
                "This is message about error 1!",
                "Test first.",
                JOptionPane.PLAIN_MESSAGE);

        JOptionPane.showMessageDialog(
                null,
                "This is message about error 2!",
                "Test second.",
                JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(
                null,
                "This is message about error 3!",
                "Third test.",
                JOptionPane.QUESTION_MESSAGE);

        JOptionPane.showMessageDialog(
                null,
                "This is message about error 4!",
                "Forth test.",
                JOptionPane.WARNING_MESSAGE);

        JOptionPane.showMessageDialog(
                null,
                "This is message about error 5!",
                "Fifth test.",
                JOptionPane.ERROR_MESSAGE);
    }

    private void initShowDialog() {
        int result = JOptionPane.showConfirmDialog(
                null,
                "You have skill for programing?",
                "Dialog title.",
                JOptionPane.YES_NO_CANCEL_OPTION);
        System.out.println("Answer result: " + result);
    }

    private void initInputDialog() {
        String result = JOptionPane.showInputDialog("What's you favorite book?");
        System.out.println("Answer result: " + result);
    }

    private void initSecretMessage() {
        String[] responses = {"Good!", "This is true?", "Good luck!"};
        JOptionPane.showOptionDialog(
                null,
                "You are human?",
                "Title dialog secret message.",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.INFORMATION_MESSAGE,
                new ImageIcon("src/main/resources/icons8-java-64.png"),
                responses,
                0);

    }
}
