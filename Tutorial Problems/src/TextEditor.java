import javax.swing.*;

public class TextEditor {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Simple Text Editor");
        frame.setSize(600, 400);

        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        frame.add(scrollPane);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");

        JMenuItem newItem = new JMenuItem("New");
        JMenuItem clearItem = new JMenuItem("Clear");
        JMenuItem exitItem = new JMenuItem("Exit");

        fileMenu.add(newItem);
        fileMenu.add(clearItem);
        fileMenu.add(exitItem);

        JMenu editMenu = new JMenu("Edit");

        JMenuItem cutItem = new JMenuItem("Cut");
        JMenuItem copyItem = new JMenuItem("Copy");
        JMenuItem pasteItem = new JMenuItem("Paste");

        editMenu.add(cutItem);
        editMenu.add(copyItem);
        editMenu.add(pasteItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        frame.setJMenuBar(menuBar);

        newItem.addActionListener(e -> {
            textArea.setText("");
        });

        clearItem.addActionListener(e -> {
            textArea.setText("");
        });

        exitItem.addActionListener(e -> {
            System.exit(0);
        });

        cutItem.addActionListener(e -> {
            textArea.cut();
        });

        copyItem.addActionListener(e -> {
            textArea.copy();
        });

        pasteItem.addActionListener(e -> {
            textArea.paste();
        });

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}