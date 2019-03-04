package wholesale_manager;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPasswordField;

public class Main {

	public JFrame frmTest;
	public static JPanel user_message_panel = new User_message();
	public static JPanel login_panel = new Login();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frmTest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}
	
	static JButton supplier = new JButton("\u4F9B\u5E94\u5546\u7BA1\u7406");
	static JButton purchase = new JButton("\u91C7\u8D2D\u5355\u7BA1\u7406");
	static JButton employee = new JButton("\u5458\u5DE5\u7BA1\u7406");
	static JButton customer = new JButton("\u5BA2\u6237\u7BA1\u7406");
	static JButton storehouse = new JButton("\u5546\u54C1\u7BA1\u7406");
	static JButton sale = new JButton("\u9500\u552E\u5355\u7BA1\u7406");
	static JButton user_message = new JButton("\u7528\u6237\u4FE1\u606F");
	private final JButton btnNewButton = new JButton("\u9000\u51FA\u767B\u5F55");
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTest = new JFrame();
		frmTest.setForeground(Color.WHITE);
		frmTest.setTitle("\u6279\u53D1\u9500\u552E\u7BA1\u7406\u7CFB\u7EDF");
		frmTest.getContentPane().setBackground(Color.LIGHT_GRAY);
		frmTest.setBackground(new Color(240, 240, 240));
		frmTest.setBounds(400, 180, 643, 360);
		frmTest.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		login_panel.setBounds(113, 0, 514, 321);
		frmTest.getContentPane().add(login_panel);
		login_panel.setVisible(true);
		
		JPanel purchase_panel = new Purchase();
		purchase_panel.setBounds(113, 0, 514, 321);
		frmTest.getContentPane().add(purchase_panel);
		purchase_panel.setVisible(false);
		
		JPanel sale_panel = new Sale();
		sale_panel.setBounds(113, 0, 514, 321);
		frmTest.getContentPane().add(sale_panel);
		sale_panel.setVisible(false);
		
		JPanel customer_panel = new Customer();
		customer_panel.setBounds(113, 0, 514, 321);
		frmTest.getContentPane().add(customer_panel);
		customer_panel.setVisible(false);
		
		JPanel supplier_panel = new Supplier();
		supplier_panel.setBounds(113, 0, 514, 321);
		frmTest.getContentPane().add(supplier_panel);
		supplier_panel.setVisible(false);
		
		JPanel storehouse_panel = new Storehouse();
		storehouse_panel.setBounds(113, 0, 514, 321);
		frmTest.getContentPane().add(storehouse_panel);
		storehouse_panel.setVisible(false);
		
		JPanel employee_panel = new Employee();
		employee_panel.setBounds(113, 0, 514, 321);
		frmTest.getContentPane().add(employee_panel);
		employee_panel.setVisible(false);
		
		//JPanel user_message_panel = new User_message();
		user_message_panel.setBounds(113, 0, 514, 321);
		frmTest.getContentPane().add(user_message_panel);
		user_message_panel.setVisible(false);
		
		supplier.setEnabled(false);
		supplier.setBounds(7, 225, 100, 23);
		supplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_panel.setVisible(false);
				purchase_panel.setVisible(false);
				sale_panel.setVisible(false);
				customer_panel.setVisible(false);
				storehouse_panel.setVisible(false);
				employee_panel.setVisible(false);
				user_message_panel.setVisible(false);
				supplier_panel.setVisible(true);
			}
		});
		
		//JButton purchase = new JButton("\u91C7\u8D2D\u5355\u7BA1\u7406");
		purchase.setEnabled(false);
		purchase.setBounds(7, 184, 100, 23);
		purchase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_panel.setVisible(false);
				sale_panel.setVisible(false);
				customer_panel.setVisible(false);
				supplier_panel.setVisible(false);
				storehouse_panel.setVisible(false);
				employee_panel.setVisible(false);
				user_message_panel.setVisible(false);
				purchase_panel.setVisible(true);
			}
		});
		frmTest.getContentPane().setLayout(null);
		frmTest.getContentPane().add(purchase);
		frmTest.getContentPane().add(supplier);
		employee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_panel.setVisible(false);
				sale_panel.setVisible(false);
				customer_panel.setVisible(false);
				supplier_panel.setVisible(false);
				storehouse_panel.setVisible(false);
				purchase_panel.setVisible(false);
				user_message_panel.setVisible(false);
				employee_panel.setVisible(true);
			}
		});
		
		//JButton employee = new JButton("\u5458\u5DE5\u7BA1\u7406");
		employee.setEnabled(false);
		employee.setBounds(7, 265, 100, 23);
		frmTest.getContentPane().add(employee);
		customer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_panel.setVisible(false);
				purchase_panel.setVisible(false);
				sale_panel.setVisible(false);
				supplier_panel.setVisible(false);
				storehouse_panel.setVisible(false);
				employee_panel.setVisible(false);
				user_message_panel.setVisible(false);
				customer_panel.setVisible(true);
			}
		});
		
		//JButton customer = new JButton("\u5BA2\u6237\u7BA1\u7406");
		customer.setEnabled(false);
		customer.setBounds(7, 141, 100, 23);
		frmTest.getContentPane().add(customer);
		
		storehouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login_panel.setVisible(false);
				purchase_panel.setVisible(false);
				sale_panel.setVisible(false);
				customer_panel.setVisible(false);
				supplier_panel.setVisible(false);
				employee_panel.setVisible(false);
				user_message_panel.setVisible(false);
				storehouse_panel.setVisible(true);
			}
		});
		
		//JButton storehouse = new JButton("\u5E93\u5B58\u67E5\u8BE2");
		storehouse.setEnabled(false);
		storehouse.setBounds(7, 53, 100, 23);
		frmTest.getContentPane().add(storehouse);
		sale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login_panel.setVisible(false);
				purchase_panel.setVisible(false);
				customer_panel.setVisible(false);
				supplier_panel.setVisible(false);
				employee_panel.setVisible(false);
				storehouse_panel.setVisible(false);
				user_message_panel.setVisible(false);
				sale_panel.setVisible(true);
			}
		});
		
		//JButton sale = new JButton("\u9500\u552E\u5355\u7BA1\u7406");
		sale.setEnabled(false);
		sale.setBounds(7, 97, 100, 23);
		frmTest.getContentPane().add(sale);
		user_message.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login_panel.setVisible(false);
				purchase_panel.setVisible(false);
				customer_panel.setVisible(false);
				supplier_panel.setVisible(false);
				employee_panel.setVisible(false);
				storehouse_panel.setVisible(false);
				sale_panel.setVisible(false);
				user_message_panel.setVisible(true);
			}
		});
		
//		JButton user_message = new JButton("\u7528\u6237\u4FE1\u606F");
		user_message.setEnabled(false);
		user_message.setBounds(7, 10, 100, 23);
		frmTest.getContentPane().add(user_message);
		btnNewButton.addActionListener(new ActionListener() {
			public void run() {
				try {
					Main window = new Main();
					window.frmTest.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			public void actionPerformed(ActionEvent e) {
				frmTest.dispose();
				run();
			}
		});
		btnNewButton.setBounds(10, 298, 93, 23);
		
		frmTest.getContentPane().add(btnNewButton);
	}
}
