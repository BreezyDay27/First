import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MigLayoutTest extends JPanel
{
    private MigLayoutTest()
    {
        JFrame frame = new JFrame("MigLayout Test");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setContentPane(new JScrollPane(getPage()));
        frame.getContentPane().setMinimumSize(new Dimension(650, 336));
        frame.getContentPane().setPreferredSize(new Dimension(890, 562));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private JPanel getPage()
    {
        JPanel panel = new JPanel(new MigLayout("fill, wrap 3, debug", "[][][grow, fill]"));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // To add buttons directly to panel uncomment the commented out lines below and comment out each line that references listButtonPanel
        JPanel listButtonPanel = new JPanel(new MigLayout("ins 0, wrap 1, aligny top"));
        Dimension btnSize = new Dimension(105, 25);
        JButton addBtn = new JButton("Add");
        addBtn.setPreferredSize(btnSize);
        listButtonPanel.add(addBtn);
        // panel.add(addBtn, "spany 4, split 8, flowy");

        JButton removeBtn = new JButton("Remove");
        removeBtn.setPreferredSize(btnSize);
        listButtonPanel.add(removeBtn);
        // panel.add(removeBtn);

        JButton copyBtn = new JButton("Copy");
        copyBtn.setPreferredSize(btnSize);
        listButtonPanel.add(copyBtn);
        // panel.add(copyBtn)

        panel.add(listButtonPanel, "spany 2, aligny top, hmax 100%");

        JTextField txtField = new JTextField();
        JLabel label = new JLabel("Property 1");
        label.setLabelFor(txtField);
        panel.add(label, "alignx right");
        panel.add(txtField);

        JComboBox comboBox = new JComboBox(new String[] {"cbx itm 1", "cbx itm 2", "cbx itm 3"});
        comboBox.setEditable(true);
        comboBox.setSelectedItem("");
        label = new JLabel("ComboBox Property");
        label.setLabelFor(comboBox);
        panel.add(label, "alignx right");
        panel.add(comboBox);

        panel.add(new JLabel("A big JList"), "spanx 2, grow");
        panel.add(new JLabel("A big JTextArea"));

        JList list = new JList(new DefaultListModel());
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setVisibleRowCount(-1);
        String[] names = new String[] {"Stuff to", "fill this", "JList..."};
        DefaultListModel model = (DefaultListModel)list.getModel();
        for (String name : names)
            model.addElement(name);
        JScrollPane scroller = new JScrollPane(list);
        scroller.setMinimumSize(new Dimension(213, 100));
        scroller.setPreferredSize(new Dimension(213, 100));
        panel.add(scroller, "spanx 2, grow, pushy");

        JTextArea textArea = new JTextArea();
        scroller = new JScrollPane(textArea);
        scroller.setPreferredSize(new Dimension(100, 100));
        panel.add(scroller, "grow, pushy");

        return panel;
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() { new MigLayoutTest(); }
        });
    }
}