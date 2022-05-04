/*
 * Created by JFormDesigner on Tue May 03 14:08:50 CST 2022
 */

package SalseItem.SalsePanel;

import SalseItem.ItemandCar.user_car;
import SqlShare.ConnectionHandler;

import java.awt.*;
import java.sql.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class ShopCar extends JDialog {
    user_car UseCar;
    static Object k;
    String FoodTypeSave="";
    public ShopCar(user_car UseCar,String FoodTypeSave) {
        this.FoodTypeSave = FoodTypeSave;
        this.UseCar = UseCar;
        k=UseCar;
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        this.setTitle("购物车");
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        button1 = new JButton();
        button2 = new JButton();
        label4 = new JLabel();
        textField1 = new JTextField();
        textField2 = new JTextField();
        textField3 = new JTextField();
        textField4 = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u5546\u54c1ID:");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(20, 30), label1.getPreferredSize()));

        //---- label2 ----
        label2.setText("\u5546\u54c1\u540d\u79f0\uff1a");
        contentPane.add(label2);
        label2.setBounds(new Rectangle(new Point(20, 65), label2.getPreferredSize()));

        //---- label3 ----
        label3.setText("数量");
        contentPane.add(label3);
        label3.setBounds(new Rectangle(new Point(20, 95), label3.getPreferredSize()));

        //--- button2---
        button2.setText("取消");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(190, 175), button2.getPreferredSize()));
        button2.addActionListener(a->{
            this.setVisible(false);
        });

        ImageIcon image= new ImageIcon(FoodTypeSave);
        image.setImage(image.getImage().getScaledInstance(130,100,Image.SCALE_DEFAULT));
        JLabel FoodJL = new JLabel(image);
        this.add(FoodJL);  //添加进Panel
        FoodJL.setBounds(new Rectangle(new Point(250, 30), FoodJL.getPreferredSize()));

        //---- button1 ----
        button1.setText("\u786e\u8ba4");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(120, 175), button1.getPreferredSize()));
        button1.addActionListener(a->{
            try {
                conn= ConnectionHandler.getConn();
                String sql = "insert into user_car values(?,?,?,?,?,?,?)";
                String sql1 = "select user_id,user_name from currentuser where loginNum = 1"; // 取第一行，退出登录后该临时数据表数据清除
                //记录当前登录信息
                ResultSet rs = null;
                Statement stmt = null;
                stmt =conn.createStatement();
                rs = stmt.executeQuery(sql1);
                while(rs.next()){
                     id=rs.getInt(1);
                     name = rs.getString(2);
                    System.out.println("ID:" + id);
                    System.out.println("Name:" + name);
                    System.out.println("添加购物车成功");
                }
                PreparedStatement pstmt=conn.prepareStatement(sql);
                pstmt.setNull(1,UseCar.getColnum());
                pstmt.setInt(2, Integer.parseInt(textField1.getText()));
                pstmt.setString(3,textField2.getText());
                pstmt.setFloat(4, Float.parseFloat(textField4.getText()));
                pstmt.setInt(5, Integer.parseInt(textField3.getText()));
                pstmt.setInt(6,id);
                pstmt.setString(7,name);
                pstmt.executeUpdate();//真正执行sql语句
                this.setVisible(false);
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("新增购物车失败");
            }
        });
        //---- label4 ----
        label4.setText("商品价格");
        contentPane.add(label4);
        label4.setBounds(new Rectangle(new Point(20, 120), label4.getPreferredSize()));
        contentPane.add(textField1);
        textField1.setBounds(110, 25, 110, textField1.getPreferredSize().height);
        contentPane.add(textField2);
        textField1.setText(String.valueOf(UseCar.getId()));
        textField2.setBounds(110, 60, 110, textField2.getPreferredSize().height);
        textField2.setText(UseCar.getTitle());
        contentPane.add(textField3);
        textField3.setBounds(110, 95, 110, textField3.getPreferredSize().height);
        contentPane.add(textField4);
        textField3.setText(String.valueOf(UseCar.getNum()));
        textField4.setBounds(110, 130, 110, textField4.getPreferredSize().height);
        textField4.setText(String.valueOf(UseCar.getPrice()));
        contentPane.setPreferredSize(new Dimension(400, 300));
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    //加入购物车界面显示
    public void ShowFood(String FoodUrl){
        ImageIcon image = new ImageIcon(FoodUrl);
        image.setImage(image.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
        JLabel FoodJL = new JLabel(image);
        this.add(FoodJL);  //添加进Panel
        FoodJL.setBounds(new Rectangle(new Point(230, 100), FoodJL.getPreferredSize()));
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JButton button1;
    private JButton button2;
    private JLabel label4;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    Connection conn=null;
    int id=0;
    String name="";
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Container container = frame.getContentPane();
        JButton jButton = new JButton();
        jButton.setBounds(10,10,100,20);
        jButton.addActionListener(a->
        {
            new ShopCar(new user_car(1,2,"w",3,3,3,"w"),"你大爷").setVisible(true);
        });
        container.add(jButton);
        frame.setTitle("测试shopCat对话框");
        frame.pack();
        frame.setVisible(true);
        frame.setBounds(200,200,200,200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
