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
                    1���õ���¼������û���������
                    2��ȥ�����ݿ��е��û���������ȶ�
                    3�����������ݿ�ͱ�
                    4�����һ����¼
                    INSERT INTO sys_user (id,name,password) VALUES(1111,'guet','guet1234');
                     */
                    String username = textField1.getText();
                    String password = textField2.getText();


                    Connection conn = null;
                    // ƴsql��������ע�빥��
                    String sql = "SELECT * FROM sys_user WHERE name='" + username + "' AND password='" + password + "'";
                    System.out.println(sql);
                    String LoginSql = "insert into currentuser(user_id,user_name) values(?,?)";
                    String UserCheckSql = "Select id from sys_user where name='"+username+"'";
                    ResultSet rs = null;//��������ڴ棬�洢�˲�ѯ�������ݣ��ڴ�����һ���αִ꣬�����ѯ��ʱ�򣬲�ָ���κμ�¼
                    Statement stmt = null;//���������ײ���ע�빥��
                    ResultSet rs1 = null;  // ��ID�ã������α��ͻ
                    Statement stmt1 = null;
                    int ID=0;  //��¼��ǰID
                    try {
                        conn = ConnectionHandler.getConn();
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery(sql);
                        if (rs.next()) {//���α������ƶ�һ��
                            System.out.println("sign in is success");
                            this.setVisible(false);
                            //��¼��ǰ��¼��Ϣ
                            stmt1 = conn.createStatement();
                            rs1 = stmt1.executeQuery(UserCheckSql);
                            while(rs1.next()){
                                ID=rs.getInt(1);
                                System.out.println("ID:" + ID);
                            }
                            PreparedStatement pstmt = conn.prepareStatement(LoginSql);
                            pstmt.setInt(1,ID);
                            pstmt.setString(2,username);
                            pstmt.executeUpdate();//����ִ��sql���
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
        this.setVisible(true);//��������ɼ�
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
