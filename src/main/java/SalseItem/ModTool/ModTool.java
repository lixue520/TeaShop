/*
 * Created by JFormDesigner on Tue May 03 22:19:48 CST 2022
 */

package SalseItem.ModTool;

import SalseItem.ItemandCar.user_car;
import SqlShare.ConnectionHandler;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

/**
 * @author unknown
 */
public class ModTool extends JDialog {
    public user_car car;
    public ModTool(user_car car) {
        this.car = car;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        label4 = new JLabel();
        label5 = new JLabel();
        label6 = new JLabel();
        label7 = new JLabel();
        textField1 = new JTextField();
        label8 = new JLabel();
        label9 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();

        //======== this ========
        setTitle("ModCar");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u6dfb\u52a0\u5e8f\u53f7\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(35, 25), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText(String.valueOf(car.getColnum()));
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(120, 25), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("\u5546\u54c1\u540d\u79f0\uff1a");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(35, 55), label3.getPreferredSize()));

        //---- label4 ----
        label4.setText(car.getTitle());
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(120, 55), label4.getPreferredSize()));

        //---- label5 ----
        label5.setText("\u5546\u54c1\u5355\u4ef7\uff1a");
        contentPane.add(label5);
        label5.setBounds(new Rectangle(new Point(35, 85), label5.getPreferredSize()));

        //---- label6 ----
        label6.setText(String.valueOf(car.getPrice()));
        contentPane.add(label6);
        label6.setBounds(new Rectangle(new Point(120, 85), label6.getPreferredSize()));

        //---- label7 ----
        label7.setText("\u5546\u54c1\u6570\u91cf:");
        contentPane.add(label7);
        label7.setBounds(new Rectangle(new Point(35, 140), label7.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(105, 135, 140, textField1.getPreferredSize().height);
        textField1.setText(String.valueOf(car.getNum()));
        //---- label8 ----
        label8.setText("\u5f53\u524d\u987e\u5ba2\uff1a");
        contentPane.add(label8);
        label8.setBounds(new Rectangle(new Point(35, 110), label8.getPreferredSize()));

        //---- label9 ----
        label9.setText(car.getUser_name());
        contentPane.add(label9);
        label9.setBounds(new Rectangle(new Point(120, 110), label9.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u5220\u9664\u6b64\u6761");
        contentPane.add(button1);
        button1.setBounds(50, 185, 87, button1.getPreferredSize().height);
        button1.addActionListener(a->{
            try {
                conn = ConnectionHandler.getConn();
                //删除当前选择的购物序号对应的订单
                String sql = "DELETE FROM user_car WHERE colnum=?;";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, Integer.parseInt(label2.getText()));
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        //---- button2 ----
        button2.setText("\u786e\u5b9a");
        contentPane.add(button2);
        button2.setBounds(140, 185, 90, button2.getPreferredSize().height);
        button2.addActionListener(
                a->{
                    try {
                        conn = ConnectionHandler.getConn();
                        //删除当前选择的购物序号对应的订单
                        String sql = "update user_car u set u.num=? where u.colnum=?";
                        PreparedStatement pstmt = conn.prepareStatement(sql);
                        pstmt.setInt(2,Integer.parseInt(label2.getText()));
                        pstmt.setInt(1,Integer.parseInt(textField1.getText()));
                        System.out.println("colnum:" + label2.getText());
                        System.out.println("num:" + textField1.getText());
                        pstmt.executeUpdate();
                        ConnectionHandler.closeConnection();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }
        );
        //---- button3 ----
        button3.setText("\u53d6\u6d88");
        contentPane.add(button3);
        button3.setBounds(235, 185, 100, button3.getPreferredSize().height);
        button3.addActionListener(a->{
            this.setVisible(false);  //退出对话框
        });
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
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JTextField textField1;
    private JLabel label8;
    private JLabel label9;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    Connection conn = null;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        //测试代码
        JFrame jf=new JFrame();
        Container container = jf.getContentPane(); //将窗体转换为容器
        JButton jb = new JButton("弹出对话框");
        jb.setBounds(10,10,100,20);
        jb.addActionListener(a->{
            //new ModTool().setVisible(true);
        });
        container.add(jb);//将按钮添加到容器中，这点非常重要，不然无法显示
        //设置容器的结构的特性
        jf.setTitle("这是窗体转化为容器");
        jf.setSize(200,200);//设置容器的大小
        jf.setVisible(true);//使窗体可见
        //设置窗体的关闭模式
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
