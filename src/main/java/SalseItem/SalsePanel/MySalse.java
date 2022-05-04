/*
 * Created by JFormDesigner on Tue May 03 11:00:17 CST 2022
 */

package SalseItem.SalsePanel;

import SalseItem.ItemandCar.Item;
import SalseItem.ItemandCar.user_car;
import SalseItem.MainForm;
import SqlShare.ConnectionHandler;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 * @author unknown
 */
public class MySalse extends JPanel {

    Frame frame; //����panel����������Frame��������������panel�еİ�ť��Frame����Ŀ���Ȩ
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
//        label3.setText("��ƷͼƬ��");
//        label3.setBounds(new Rectangle(new Point(15,250),label3.getPreferredSize()));

        // --- ��ʾ��Ʒ����---
//        FoodLabel = new JLabel();
//        FoodLabel.setText("������"+"����С��Ϲ"+"���ͣ�"+"�ײ�1");  //�����ݿ��л�ȡ��ÿ�ε���˵���Ӧ
//        this.add(FoodLabel); //��ӽ�panel
//        FoodLabel.setBounds(new Rectangle(new Point(30,230), FoodLabel.getPreferredSize()));
//        ImageIcon image = new ImageIcon("src/main/java/ImageDemo/DavidNan.jpg");
//        image.setImage(image.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
//        label3 = new JLabel(image);
//        this.add(label3);  //��ӽ�Panel
//        label3.setBounds(new Rectangle(new Point(30, 250), label3.getPreferredSize()));


        //---- label2 ----
        label2.setText("\u83dc\u5355\u5206\u7c7b");
        add(label2);
        label2.setBounds(new Rectangle(new Point(15, 180), label2.getPreferredSize()));
        add(comboBox1);
        comboBox1.setBounds(new Rectangle(70,180,70,25));
        comboBox1.addItem("ȫ��");
        comboBox1.addItem("����");
        comboBox1.addItem("����");
        comboBox1.addItem("�ײ�");
        comboBox1.addItem("����");
        comboBox1.addActionListener(a->{
            String str= String.valueOf(comboBox1.getSelectedItem());
            try {
                conn= ConnectionHandler.getConn();
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("conn����ʧЧ");
            }
            if(str.equals("ȫ��")){
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

            }else if(str.equals("����")){
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
            }else if(str.equals("����")){
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
            }else if(str.equals("�ײ�")){
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
                    int rowNo = table1.getSelectedRow();//��ȡ��ѡ���к�
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
                    * ��һ�����õ�����������ݱȶԿ�����ʾ���ﳵ������panel�����ͼƬ��ʾ
                    * ����������ȥ���ݿ�дsqlʱ��Ҳͦʵ��*/
                    ResultSet rs = null;
                    Statement stmt = null;
                    String FoodTypeSave=""; //��¼��ѯ������Ϣ

                    try {
                        conn=ConnectionHandler.getConn();
                        String sql = "select img_url from item where FoodType='"+FoodType+"'";
                        stmt = conn.createStatement();
                        rs = stmt.executeQuery(sql);
                        if(rs.next()){
                            //���α�����һ��
                            System.out.println("Show the food:"+rs.getString(1));
                            FoodTypeSave = rs.getString(1);
                            //��ʾͼƬ--�����е�����--��ʱ����
                            ImageIcon icon = new ImageIcon(rs.getString(1));
                            FoodJL = new JLabel("ʳ��:",icon,JLabel.CENTER);
                            FoodJL.setHorizontalAlignment(SwingConstants.LEFT);
                            FoodJL.setHorizontalTextPosition(SwingConstants.CENTER);
                            FoodJL.setOpaque(true);
                            FoodJL.setBounds(100,200,300,300);
                            this.add(FoodJL);
                            //����shopCar��ʾ����

                        }else{
                            System.out.println("�ò�Ʒ����ͼƬ@����Ա�����ܷ�");
                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                    /* Item item=new Item(id,title,price,description,sales,img_url,FoodType);*/
                    // �ֱ������Ĭ��ÿ����Ĭ������Ϊ1���ֶ��޸�������colnum��ʼ��Ϊ1�������ύ�Զ�����
                    user_car UseCar=new user_car(1,id,title,price,1);
                    ShopCar car=new ShopCar(UseCar,FoodTypeSave);
                    car.setVisible(true);
                    //car.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                }
        );

        //---- button2 ----
        button2.setText("�ҵĹ��ﳵ");
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
        button3.setText("�˳���¼");
        add(button3);
        button3.setBounds(new Rectangle(new Point(390, 180), button3.getPreferredSize()));
        button3.addActionListener(a->{
            System.out.println("--------ע��--------");
            System.out.println("�����û���¼��Ϣ");
            //�����ǰ�û���¼��Ϣ��ÿ�ε�¼ֻ����һ���û������빺�ﳵʱ֧�����ɶ�������ɶ�����Ҫ
            // ���������û���¼Ӧ�����ݱ������������Լ�����
            //��ȡ��ǰFrame����--�������������--�´ε�¼���ݱ����
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
        // �Ѽ��ϵ����ݣ���Ʒ��Ϣ��ת���ɶ�ά����
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
    private JScrollPane scrollPane2;  //���ڷ��ö���ͼƬ
    private String head[] = {"id", "��Ʒ����", "����", "����", "������", "��ƷͼƬ","����"};
    private Object[][] data = null;
    private JTable table1;
    private JLabel label2;
    private JLabel label3;  //ͼƬ����
    private JComboBox comboBox1;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
    public Connection conn=null;

    //��������ʾ��ƷͼƬ
    public void ShowFood(String FoodUrl){
        JLabel FoodJL;
        ImageIcon image= new ImageIcon(FoodUrl);
        image.setImage(image.getImage().getScaledInstance(100,80,Image.SCALE_DEFAULT));
        FoodJL = new JLabel(image);
        this.add(FoodJL);  //��ӽ�Panel
        FoodJL.setBounds(new Rectangle(new Point(30, 250), FoodJL.getPreferredSize()));
    }

    public static void main(String[] args) throws SQLException {
        // �������
        Frame frame=new Frame("MySalesPanel");
        frame.add(new MySalse(frame),BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }
}
