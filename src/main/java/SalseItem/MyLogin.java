package SalseItem;

import SalseItem.SalsePanel.MySalse;
import SqlShare.ConnectionHandler;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
/*
 * Created by JFormDesigner on Sat Apr 02 15:41:52 CST 2022
 */


/**
 * @author 1
 */
public class MyLogin extends JFrame {
    public MyLogin() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        textField1 = new JTextField("guet");
        label2 = new JLabel();
        textField2 = new JTextField("guet1234");
        button1 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u7528\u6237\u540d\uff1a");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(115, 90), label1.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(185, 85, 100, textField1.getPreferredSize().height);

        //---- label2 ----
        label2.setText("\u5bc6\u7801\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(120, 125), label2.getPreferredSize()));
        contentPane.add(textField2);
        textField2.setBounds(185, 120, 100, textField2.getPreferredSize().height);

        //---- button1 ----
        button1.addActionListener(
                (e) -> {
                    /*
                    1、拿到登录界面的用户名和密码
                    2、去和数据库中的用户名和密码比对
                    3、创建了数据库和表
                    4、添加一条记录
                    INSERT INTO sys_user (id,name,password) VALUES(1111,'guet','guet1234');
                     */
                    String username = textField1.getText();
                    String password = textField2.getText();


                    Connection conn = null;
                    // 拼sql，容易有注入攻击
                    String sql = "SELECT * FROM sys_user WHERE name='" + username + "' AND password='" + password + "'";
                    System.out.println(sql);
                    String LoginSql = "insert into currentuser(user_id,user_name) values(?,?)";
                    String UserCheckSql = "Select id from sys_user where name='"+username+"'";
                    ResultSet rs = null;//结果集：内存，存储了查询到的数据；内存区有一个游标，执行完查询的时候，不指向任何记录
                    Statement stmt = null;//语句对象，容易产生注入攻击
                    ResultSet rs1 = null;  // 查ID用，避免游标冲突
                    Statement stmt1 = null;
                    int ID=0;  //记录当前ID
                    try {
                        conn = ConnectionHandler.getConn();
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery(sql);
                        if (rs.next()) {//让游标向下移动一次
                            System.out.println("sign in is success");
                            this.setVisible(false);
                            //记录当前登录信息
                            stmt1 = conn.createStatement();
                            rs1 = stmt1.executeQuery(UserCheckSql);
                            while(rs1.next()){
                                ID=rs.getInt(1);
                                System.out.println("ID:" + ID);
                            }
                            PreparedStatement pstmt = conn.prepareStatement(LoginSql);
                            pstmt.setInt(1,ID);
                            pstmt.setString(2,username);
                            pstmt.executeUpdate();//真正执行sql语句
                            Frame frame = new Frame("MySales");
                            frame.add(new MySalse(this),BorderLayout.CENTER);
                            frame.setLocationRelativeTo(getOwner());
                            frame.pack();
                            frame.setVisible(true);
                        } else {
                            System.out.println("wrong user name or password");
                        }
                        ConnectionHandler.closeConnection();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
        );
        button1.setText("\u767b\u5f55");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(170, 185), button1.getPreferredSize()));


        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);//设置组件可见
    }

    private JLabel label1;
    private JTextField textField1;
    private JLabel label2;
    private JTextField textField2;
    private JButton button1;

    public static void main(String[] args) {
        new MyLogin();
    }
}
