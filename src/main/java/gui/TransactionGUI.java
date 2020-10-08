package gui;

import constants.Constants;
import dao.Sql2oProductDao;
import dao.Sql2oUserDao;
import models.Product;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TransactionGUI extends JFrame {
    private JPanel mainPanel;
    private JTable shoppingCart;
    private JLabel lblTotal;
    private JTextField productIDField;
    private JButton btnAddToCart;
    private JButton btnPay;
    private JButton backButton;
    private JButton removeItemButton;
    private JButton clearCartButton;
    private DefaultTableModel dtm;
    private Connection conn;
    private double total=0.00;

    public TransactionGUI(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        createTable();

        lblTotal.setText(String.valueOf(total));

        btnAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int productID = Integer.parseInt(productIDField.getText());
                addProduct(productID);
            }
        });
    }

    private void addProduct(int productID) {
        Sql2o sql2o = new Sql2o(Constants.CONNECTION_URL, "louis", "23ARMIN23");
        conn = sql2o.open();

        Sql2oProductDao productDao = new Sql2oProductDao(sql2o);

        Product productToAdd = productDao.getProductById(productID);

        if(productToAdd!=null){
            String productName = productToAdd.getManufacturer() + " " + productToAdd.getProduct_name() + " - " + productToAdd.getType();
            double price = productToAdd.getPrice();
            int quantity = 1 ;

            total = total + price;

            String[] entry = {productName,String.valueOf(quantity),String.valueOf(price)};


            dtm.addRow(entry);
            shoppingCart=new JTable(dtm);


            lblTotal.setText(String.valueOf(total));


        }

    }

    private void createTable() {
        dtm = new DefaultTableModel(
                null, new String[]{"Item","Quantity","Price"}
        );

        shoppingCart.setModel(dtm);
    }
}
