/*
 * Created by JFormDesigner on Mon May 02 22:48:16 CST 2022
 */

package SqlShare;

import java.awt.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class SelectItem extends JFrame {
    public SelectItem() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField();
        label2 = new JLabel();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u6309\u5546\u54c1\u540d\u67e5\u8be2");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(35, 25), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(new Rectangle(new Point(140, 25), textField1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u6309");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(40, 80), label2.getPreferredSize()));

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
