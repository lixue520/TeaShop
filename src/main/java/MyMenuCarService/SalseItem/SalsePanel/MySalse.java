/*
 * Created by JFormDesigner on Tue May 03 11:00:17 CST 2022
 */

package MyMenuCarService.SalseItem.SalsePanel;

import MyMenuCarService.SalseItem.ItemandCar.user_car;
import MyMenuCarService.SalseItem.ItemandCar.Item;
import MyMenuCarService.SqlShare.ConnectionHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author unknown
 */
public class MySalse extends JPanel {

    Frame frame; //传入panel所在容器的Frame窗体对象便于利用panel中的按钮有Frame窗体的控制权
    public MySalse(Frame frame) throws SQLException {
       this.frame=frame;
        initComponents();
    }

    private void initComponents() throws SQLException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel(String.valueOf(JLabel.CENTER));
        scrollPane1 = new JScrollPane();
        scrollPane2 = new JScrollPane();
        table1 = new JTable();
        label2 = new JLabel();
        comboBox1 = new JComboBox();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        this.setPreferredSize(new Dimension(815,595));
        //======== this ========
        setLayout(null);

        //---- label1 ----
        label1.setText("\u5929\u5929\u83dc\u5355");
        add(label1);
        label1.setBounds(new Rectangle(new Point(220,20), label1.getPreferredSize()));
        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        add(scrollPane1);
        scrollPane1.setBounds(10, 45, 500, 100);
        DefaultTableModel tableModel = new DefaultTableModel(getDataFromDatabase(""), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table1.setModel(tableModel);

//        //======== scrollPane2 ========
//        {
//            scrollPane2.setViewportView(label3);
//        }
//        add(scrollPane2);
//        scrollPane2.setBounds(10,250,300,200);
//        label3.setText("商品图片：");
//        label3.setBounds(new Rectangle(new Point(15,250),label3.getPreferredSize()));

        // --- 显示菜品测试---
//        FoodLabel = new JLabel();
//        FoodLabel.setText("菜名："+"麻辣小龙瞎"+"类型："+"套餐1");  //从数据库中获取，每次点击菜单响应
//        this.add(FoodLabel); //添加进panel
//        FoodLabel.setBounds(new Rectangle(new Point(30,230), FoodLabel.getPreferredSize()));
//        ImageIcon image = new ImageIcon("src/main/java/ImageDemo/DavidNan.jpg");
//        image.setImage(image.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
//        label3 = new JLabel(image);
//        this.add(label3);  //添加进Panel
//        label3.setBounds(new Rectangle(new Point(30, 250), label3.getPreferredSize()));


        //---- label2 ----
        label2.setText("\u83dc\u5355\u5206\u7c7b");
        add(label2);
        label2.setBounds(new Rectangle(new Point(15, 180), label2.getPreferredSize()));
        add(comboBox1);
        comboBox1.setBounds(new Rectangle(70,180,70,25));
        comboBox1.addItem("全部");
        comboBox1.addItem("特饮");
        comboBox1.addItem("汉堡");
        comboBox1.addItem("套餐");
        comboBox1.addItem("薯条");
        comboBox1.addActionListener(a->{
            String str= String.valueOf(comboBox1.getSelectedItem());
            try {
                conn= ConnectionHandler.getConn();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("conn连接失效");
            }
            if(str.equals("全部")){
                System.out.println("all");
                try{
                    DefaultTableModel tableModel1 = new DefaultTableModel(getDataFromDatabase(""), head) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                table1.setModel(tableModel1);
                }catch (SQLException EX){
                    EX.printStackTrace();
                }

            }else if(str.equals("特饮")){
                System.out.println("special drink");
                String sql="SELECT * FROM item  where FoodType='drink'";
                try{
                    DefaultTableModel tableModel1 = new DefaultTableModel(getDataFromDatabase(sql), head) {
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    table1.setModel(tableModel1);
                }catch (SQLException EX){
                    EX.printStackTrace();
                }
            }else if(str.equals("汉堡")){
                System.out.println("Hamburger");
                String sql="SELECT * FROM item  where FoodType='Hamburger'";
                try{
                    DefaultTableModel tableModel1 = new DefaultTableModel(getDataFromDatabase(sql), head) {
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    table1.setModel(tableModel1);
                }catch (SQLException EX){
                    EX.printStackTrace();
                }
            }else if(str.equals("套餐")){
                System.out.println("combo");
                String sql="SELECT * FROM item  where FoodType='taocan'";
                try{
                    DefaultTableModel tableModel1 = new DefaultTableModel(getDataFromDatabase(sql), head) {
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    table1.setModel(tableModel1);
                }catch (SQLException EX){
                    EX.printStackTrace();
                }
            }else{
                System.out.println("fries");
                String sql="SELECT * FROM item  where FoodType='fries'";
                try{
                    DefaultTableModel tableModel1 = new DefaultTableModel(getDataFromDatabase(sql), head) {
                        public boolean isCellEditable(int row, int column) {
                            return false;
                        }
                    };
                    table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                    table1.setModel(tableModel1);
                }catch (SQLException EX){
                    EX.printStackTrace();
                }
            }
        });

        //---- button1 ----
        button1.setText("\u52a0\u5165\u8d2d\u7269\u8f66");
        add(button1);
        button1.setBounds(new Rectangle(new Point(170, 180), button1.getPreferredSize()));
        button1.addActionListener(
                (e)->{
                    int rowNo = table1.getSelectedRow();//获取所选的行号
                    int id=(int)table1.getValueAt(rowNo, 0);
                    String title=(String)table1.getValueAt(rowNo, 1);
                    Float price=(Float)table1.getValueAt(rowNo, 2);
                    String description=(String)table1.getValueAt(rowNo, 3);
                    int sales=(int)table1.getValueAt(rowNo, 4);
                    String img_url=(String)table1.getValueAt(rowNo, 5);
                    String FoodType=(String)table1.getValueAt(rowNo, 6);
                    System.out.println(id);
                    System.out.println(title);
                    System.out.println(price);
                    System.out.println(description);
                    System.out.println(sales);
                    System.out.println(img_url);
                    System.out.println(FoodType);
                    /*
                    * 法一：将拿到类型与表数据比对控制显示购物车界面与panel界面的图片显示
                    * 法二：算了去数据库写sql时间也挺实惠*/
                    ResultSet rs = null;
                    Statement stmt = null;
                    String FoodTypeSave=""; //记录查询到的信息

                    try {
                        conn=ConnectionHandler.getConn();
                        String sql = "select img_url from item where FoodType='"+FoodType+"'";
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery(sql);
                        if(rs.next()){
                            //让游标下移一次
                            System.out.println("Show the food:"+rs.getString(1));
                            FoodTypeSave = rs.getString(1);
                            //显示图片--代码有点问题--暂时不管
                            ImageIcon icon = new ImageIcon(rs.getString(1));
                            FoodJL = new JLabel("食物:",icon,JLabel.CENTER);
                            FoodJL.setHorizontalAlignment(SwingConstants.LEFT);
                            FoodJL.setHorizontalTextPosition(SwingConstants.CENTER);
                            FoodJL.setOpaque(true);
                            FoodJL.setBounds(100,200,300,300);
                            this.add(FoodJL);
                            //控制shopCar显示界面

                        }else{
                            System.out.println("该菜品暂无图片@管理员出来受罚");
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    /* Item item=new Item(id,title,price,description,sales,img_url,FoodType);*/
                    // 分表操作，默认每次行默认数量为1，手动修改数量，colnum初始设为1，事物提交自动增长
                    user_car UseCar=new user_car(1,id,title,price,1);
                    ShopCar car=new ShopCar(UseCar,FoodTypeSave);
                    car.setVisible(true);
                    //car.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                }
        );

        //---- button2 ----
        button2.setText("我的购物车");
        add(button2);
        button2.setBounds(new Rectangle(new Point(275, 180), button2.getPreferredSize()));
        button2.addActionListener(a->{
            try {
                ModShopCart modShopCar = new ModShopCart();
                modShopCar.setVisible(true);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        //---- button3 ----
        button3.setText("退出登录");
        add(button3);
        button3.setBounds(new Rectangle(new Point(390, 180), button3.getPreferredSize()));
        button3.addActionListener(a->{
            System.out.println("--------注销--------");
            System.out.println("清理用户登录信息");
            //清除当前用户登录信息，每次登录只能有一个用户，加入购物车时支付生成订单和完成订单需要
            // 若遇到多用户登录应用数据表更新脏读，再自己处理
            //获取当前Frame对象--并结束程序进程--下次登录数据表更新
            String sql = "DELETE FROM currentuser";
            try {
                conn = ConnectionHandler.getConn();
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.executeUpdate();
                ConnectionHandler.closeConnection();
                this.frame.setVisible(false);

            } catch (SQLException e) {
                e.printStackTrace();
            }


        });

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < getComponentCount(); i++) {
                Rectangle bounds = getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            setMinimumSize(preferredSize);
            setPreferredSize(preferredSize);
        }
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }
    public Object[][] getDataFromDatabase(String sql) throws SQLException {

        java.util.List<Item> list = new ArrayList<Item>();
        Connection conn = null;
        conn = ConnectionHandler.getConn();
        Statement stmt = null;
        String DelfaultSql = "SELECT * FROM item";
        if(sql==""){
            sql=DelfaultSql;
        }
        ResultSet rs = null;
        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Item item = new Item();
                item.setId(rs.getInt(1));
                item.setTitle(rs.getString(2));
                item.setPrice(rs.getFloat(3));
                item.setDescription(rs.getString(4));
                item.setSales(rs.getInt(5));
                item.setImg_url(rs.getString(6));
                item.setFoodtype(rs.getString(7));
                list.add(item);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                rs.close();
                stmt.close();
                ConnectionHandler.closeConnection();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        // 把集合的数据（商品信息）转换成二维数组
        data = new Object[list.size()][head.length];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < head.length; j++) {
                data[i][0] = list.get(i).getId();
                data[i][1] = list.get(i).getTitle();
                data[i][2] = list.get(i).getPrice();
                data[i][3] = list.get(i).getDescription();
                data[i][4] = list.get(i).getSales();
                data[i][5] = list.get(i).getImg_url();
                data[i][6]=list.get(i).getFoodtype();
            }
        }
        return data;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JLabel FoodLabel;
    private JLabel FoodJL;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;  //用于放置多组图片
    private String head[] = {"id", "商品名称", "单价", "描述", "促销价", "商品图片","类型"};
    private Object[][] data = null;
    private JTable table1;
    private JLabel label2;
    private JLabel label3;  //图片标题
    private JComboBox comboBox1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public Connection conn=null;

    //本界面显示菜品图片
    public void ShowFood(String FoodUrl){
        JLabel FoodJL;
        ImageIcon image= new ImageIcon(FoodUrl);
        image.setImage(image.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
        FoodJL = new JLabel(image);
        this.add(FoodJL);  //添加进Panel
        FoodJL.setBounds(new Rectangle(new Point(30, 250), FoodJL.getPreferredSize()));
    }

    public static void main(String[] args) throws SQLException {
        // 界面测试
        Frame frame=new Frame("MySalesPanel");
        frame.add(new MySalse(frame),BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
