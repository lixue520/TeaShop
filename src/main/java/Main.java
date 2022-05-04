import SqlShare.ConnectionHandler;

import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


/**
 * @liwei
 */
public class Main extends JFrame {
    public Main() throws SQLException {
        initComponents();
    }

    private void initComponents() throws SQLException {
        scrollPane1 = new JScrollPane();
        table1 = new JTable();
        button1 = new JButton();
        button2 = new JButton();
        button3 = new JButton();
        button4 = new JButton();
        label1 = new JLabel();
        textField1 = new JTextField();

        DefaultTableModel tableModel = new DefaultTableModel(getDataFromDatabase(), head) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table1.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        table1.setModel(tableModel);

        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setLayout(null);

        label1.setFont(new
                Font("STHeiti Light", Font.BOLD,
                30));
        label1.setText("��Ʒ��Ϣ");
        contentPane.add(label1);
        label1.setBounds(460, 0, 600, 60);

        button1.setText("ɾ��");
        contentPane.add(button1);
        button1.setBounds(510, 355, 100, 30);

        button2.setText("����");
        contentPane.add(button2);
        button2.setBounds(610, 355, 100, 30);
        button3.addActionListener(
                (e)->{

                }
        );

        button3.setText("�޸�");
        contentPane.add(button3);
        button3.setBounds(710, 355, 100, 30);
        button3.addActionListener(
                (e)->{
                    int rowNo = table1.getSelectedRow();//��ȡ��ѡ���к�
                    int id=(int)table1.getValueAt(rowNo, 0);
                    String title=(String)table1.getValueAt(rowNo, 1);
                    Float price=(Float)table1.getValueAt(rowNo, 2);
                    String description=(String)table1.getValueAt(rowNo, 3);
                    int sales=(int)table1.getValueAt(rowNo, 4);
                    String img_url=(String)table1.getValueAt(rowNo, 5);
                    System.out.println(id);
                    System.out.println(title);
                    System.out.println(price);
                    System.out.println(description);
                    System.out.println(sales);
                    System.out.println(img_url);

                    Item item=new Item(id,title,price,description,sales,img_url);

                    UpdateItem updateItem=new UpdateItem(item);
                    updateItem.setVisible(true);
                }
        );

        contentPane.add(textField1);
        textField1.setBounds(270, 355, 130, 30);

        button4.setText("��ѯ");
        contentPane.add(button4);
        button4.setBounds(410, 355, 100, 30);
        button4.addActionListener((a)->{
            //��ѯ����-->�����ѯ
            /**
             * @Funtional��������ѯ����
             */
        });

        {
            scrollPane1.setViewportView(table1);
        }
        contentPane.add(scrollPane1);
        scrollPane1.setBounds(0, 50, 1000, 300);
        {
            Dimension preferredSize = new Dimension();
            for (int i = 0; i < contentPane.getComponentCount(); i++) {
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
        this.setBounds(300, 300, 1000, 415);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Object[][] getDataFromDatabase() throws SQLException {

        java.util.List<Item> list = new ArrayList<Item>();
        Connection conn = null;
        conn = ConnectionHandler.getConn();
        Statement stmt = null;
        String sql = "SELECT * FROM item";
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
            }
        }
        return data;
    }

    private JScrollPane scrollPane1;
    private JTable table1;
    private String head[] = {"id", "��Ʒ����", "����", "����", "������", "��ƷͼƬ"};
    private Object[][] data = null;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JTextField textField1;
    private JLabel label1;

    public static void main(String[] args) throws SQLException {
        new Main();
    }
}