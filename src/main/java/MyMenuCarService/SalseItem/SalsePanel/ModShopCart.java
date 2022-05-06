/*
 * Created by JFormDesigner on Tue May 03 20:08:38 CST 2022
 */

package MyMenuCarService.SalseItem.SalsePanel;

import MyMenuCarService.SalseItem.ItemandCar.user_car;
import MyMenuCarService.SalseItem.ModTool.ModTool;
import MyMenuCarService.SalseItem.PayJDialog.MyPay;
import MyMenuCarService.SqlShare.ConnectionHandler;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;

/**
 * @author unknown
 */
public class ModShopCart extends JFrame {
    public ModShopCart() throws SQLException {
        this.setTitle("购物车");
        initComponents();
    }

    private void initComponents() throws SQLException {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        label1 = new JLabel();
        scrollPane1 = new JScrollPane();

        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //---- label1 ----
        label1.setText("\u4f60\u7684\u8d2d\u7269\u8f66");
        contentPane.add(label1);
        label1.setBounds(new Rectangle(new Point(165, 20), label1.getPreferredSize()));

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(35, 45, 330, 125);

        //初始化表单
        DefaultTableModel tableModel = new DefaultTableModel(getDataFromDatabase(""), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table1.setModel(tableModel);

        //---- button1 ----
        button1.setText("\u67e5\u8be2\u8d2d\u7269\u8f66");
        contentPane.add(button1);
        button1.setBounds(new Rectangle(new Point(40, 190), button1.getPreferredSize()));
        button1.addActionListener(a->{
            try {
                conn = ConnectionHandler.getConn();
                String sql1 = "UPDATE user_car m set m.title=?";   // -- 更新数据
                String sql2[] ={"SET @auto_id = 0;",
                        "UPDATE user_car  SET colnum = (@auto_id := @auto_id + 1);",
                        "ALTER TABLE user_car  AUTO_INCREMENT = 1;"};  //消除自增长断层
                for(String item:sql2){
                    PreparedStatement pstmt = conn.prepareStatement(item);
                    pstmt.executeUpdate();
                }
                //更新table
                DefaultTableModel tableModel1 = new DefaultTableModel(getDataFromDatabase(""), head) {
                    public boolean isCellEditable(int row, int column) {
                        return false;
                    }
                };
                table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                table1.setModel(tableModel1);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        //---- button2 ----
        button2.setText("\u4fee\u6539\u8d2d\u7269\u8f66");
        contentPane.add(button2);
        button2.setBounds(new Rectangle(new Point(145, 190), button2.getPreferredSize()));
        button2.addActionListener(a->{
            int rowNo = table1.getSelectedRow();//获取所选的行号
            int colnum= (int) table1.getValueAt(rowNo,0);
            int id = (int) table1.getValueAt(rowNo,1);
            String title= (String) table1.getValueAt(rowNo,2);
            Float price = (Float)table1.getValueAt(rowNo,3);
            int num = (int)table1.getValueAt(rowNo,4);
            int user_id = (int)table1.getValueAt(rowNo,5);
            String name = (String) table1.getValueAt(rowNo,6);
            Container container = this.getContentPane(); //将窗体转换为容器
            user_car car = new user_car(colnum,id,title,price,num,user_id,name);
            new ModTool(car).setVisible(true);
            container.add(button2);   //将按钮添加到容器中
        });
        //---- button3 ----
        button3.setText("\u786e\u8ba4\u8ba2\u5355");
        contentPane.add(button3);
        button3.setBounds(new Rectangle(new Point(250, 190), button3.getPreferredSize()));
        button3.addActionListener(a->{
            //支付与购物信息
            Connection conn = null;
            try {
                conn = ConnectionHandler.getConn();
                //查询
                String sql = "select * from user_car";

            } catch (SQLException e) {
                e.printStackTrace();
            }

        });
        //---- button4 ----
        button4.setText("\u6e05\u7a7a\u8d2d\u7269\u8f66/\u652f\u4ed8");
        contentPane.add(button4);
        button4.setBounds(new Rectangle(new Point(210, 225), button4.getPreferredSize()));
        button4.addActionListener(a->{
            //支付模块
            try {
                conn = ConnectionHandler.getConn();
                Statement stmt = null;
                ResultSet rs = null;
                user_car Car = new user_car();;
                Container container = this.getContentPane(); //将窗体转换为容器
                //user_car car = new user_car(colnum,id,title,price,num,user_id,name);
                String sql = "select user_name,sum(price*num) from user_car where user_name = " +
                        "(select DISTINCT c.user_name from currentuser c) GROUP BY(user_name)";
                stmt = conn.createStatement();
                rs=stmt.executeQuery(sql);
                if(rs.next()){
                    System.out.println("客户姓名:"+rs.getString(1));
                    System.out.println("应付金额:"+rs.getFloat(2));
                    Car.setUser_name(rs.getString(1));
                    Car.setPrice(rs.getFloat(2));
                }
                new MyPay(Car).setVisible(true);
                container.add(button2);   //将按钮添加到容器中
            } catch (SQLException e) {
                e.printStackTrace();
            }


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

    public Object[][] getDataFromDatabase(String sql) throws SQLException {

        java.util.List<user_car> list = new ArrayList<user_car>();
        conn = ConnectionHandler.getConn();
        Statement stmt = null;
        String DelfaultSql = "select distinct m.colnum,m.id,m.title,m.price,m.num,m.user_id,m.user_name " +
                "from user_car m,currentuser n where m.user_name=n.user_name order by(m.colnum) ASC";
        if(sql==""){
            sql=DelfaultSql;
        }
        ResultSet rs = null;
        try {

            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                user_car item = new user_car();
                item.setColnum(rs.getInt(1));
                item.setId(rs.getInt(2));
                item.setTitle(rs.getString(3));
                item.setPrice(rs.getFloat(4));
                item.setNum(rs.getInt(5));
                item.setUser_id(rs.getInt(6));
                item.setUser_name(rs.getString(7));
                list.add(item);
                name=item.getUser_name();
                label1.setText(name+"的购物车");
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
                data[i][0] = list.get(i).getColnum();
                data[i][1] = list.get(i).getId();
                data[i][2] = list.get(i).getTitle();
                data[i][3] = list.get(i).getPrice();
                data[i][4] = list.get(i).getNum();
                data[i][5] = list.get(i).getUser_id();
                data[i][6] = list.get(i).getUser_name();
            }
        }
        return data;
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JLabel label1;
    private JScrollPane scrollPane1;
    private JScrollPane scrollPane2;
    private JTable table1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private String head[] = {"添加序号","商品ID","商品名称", "单价","数量","顾客ID","顾客"};
    private Object[][] data = null;
    Connection conn=null;
    static String name;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public static void main(String[] args) throws SQLException {
        new ModShopCart().setVisible(true);
    }
}
