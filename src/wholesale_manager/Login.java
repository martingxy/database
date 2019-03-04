package wholesale_manager;


import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import data_manage.Employee_manage;
import data_manage.User_check;

import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
    public static String UserName ;
    public static String Password;
    public static String EmployeeNo;

	/**
	 * Create the panel.
	 */
	@SuppressWarnings("deprecation")
	public Login() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel.setBounds(166, 121, 54, 15);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(178, 157, 54, 15);
		add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(230, 118, 85, 21);
		add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(230, 154, 85, 21);
		add(passwordField);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				UserName=textField.getText();
				Password=passwordField.getText();
				if(User_check.check(UserName, Password)==1) { //系统管理员
					//JOptionPane.showMessageDialog(null, "系统管理员", "标题",JOptionPane.WARNING_MESSAGE);
					Main.user_message.setEnabled(true);
					Main.supplier.setEnabled(true);
					Main.purchase.setEnabled(true);
					Main.employee.setEnabled(true);
					Main.customer.setEnabled(true);
					Main.sale.setEnabled(true);
					Main.storehouse.setEnabled(true);
					Main.login_panel.setVisible(false);
					Main.user_message_panel.setVisible(true);
					EmployeeNo=User_check.employeeno;
					Employee_manage.vData.clear();
					Employee_manage.employee_query_by_employeeno(User_check.employeeno);
					User_message.textField.setText(User_check.username);
					User_message.textField_1.setText(Employee_manage.employeename);
					User_message.textField_2.setText(User_check.employeeno);
					if(Employee_manage.departmentno.equals("sa"))
						User_message.textField_3.setText("销售部");
					else if(Employee_manage.departmentno.equals("pu"))
						User_message.textField_3.setText("采购部");
					else if(Employee_manage.departmentno.equals("ma"))
						User_message.textField_3.setText("管理层");
					if(User_check.rolelevel==1)
						User_message.textField_4.setText("1(系统管理员)");
					else if(User_check.rolelevel==2)
						User_message.textField_4.setText("2（公司管理层）");
					else if(User_check.rolelevel==3||User_check.rolelevel==4)
						User_message.textField_4.setText("3（普通员工）");
					//String inputValue = JOptionPane.showInputDialog("Please input a value");
				}
				else if(User_check.check(UserName, Password)==2) { //高管
					//JOptionPane.showMessageDialog(null, "高管", "标题",JOptionPane.WARNING_MESSAGE);
					Main.user_message.setEnabled(true);
					Main.supplier.setEnabled(true);
					Main.purchase.setEnabled(true);
					Main.employee.setEnabled(true);
					Main.customer.setEnabled(true);
					Main.sale.setEnabled(true);
					Main.storehouse.setEnabled(true);
					Main.login_panel.setVisible(false);
					Main.user_message_panel.setVisible(true);
					EmployeeNo=User_check.employeeno;
					Employee_manage.vData.clear();
					Employee_manage.employee_query_by_employeeno(User_check.employeeno);
					User_message.textField.setText(User_check.username);
					User_message.textField_2.setText(User_check.employeeno);
					User_message.textField_1.setText(Employee_manage.employeename);
					if(Employee_manage.departmentno.equals("sa"))
						User_message.textField_3.setText("销售部");
					else if(Employee_manage.departmentno.equals("pu"))
						User_message.textField_3.setText("采购部");
					else if(Employee_manage.departmentno.equals("ma"))
						User_message.textField_3.setText("管理层");
					if(User_check.rolelevel==1)
						User_message.textField_4.setText("1(系统管理员)");
					else if(User_check.rolelevel==2)
						User_message.textField_4.setText("2（公司管理层）");
					else if(User_check.rolelevel==3||User_check.rolelevel==4)
						User_message.textField_4.setText("3（普通员工）");
				}
				else if(User_check.check(UserName, Password)==3) {  //采购员
					Main.user_message.setEnabled(true);
					Main.supplier.setEnabled(true);
					Main.purchase.setEnabled(true);
					Main.storehouse.setEnabled(true);
					Main.login_panel.setVisible(false);
					Main.user_message_panel.setVisible(true);
					EmployeeNo=User_check.employeeno;
					Employee_manage.vData.clear();
					Employee_manage.employee_query_by_employeeno(User_check.employeeno);
					User_message.textField.setText(User_check.username);
					User_message.textField_2.setText(User_check.employeeno);
					User_message.textField_1.setText(Employee_manage.employeename);
					if(Employee_manage.departmentno.equals("sa"))
						User_message.textField_3.setText("销售部");
					else if(Employee_manage.departmentno.equals("pu"))
						User_message.textField_3.setText("采购部");
					else if(Employee_manage.departmentno.equals("ma"))
						User_message.textField_3.setText("管理层");
					if(User_check.rolelevel==1)
						User_message.textField_4.setText("1(系统管理员)");
					else if(User_check.rolelevel==2)
						User_message.textField_4.setText("2（公司管理层）");
					else if(User_check.rolelevel==3||User_check.rolelevel==4)
						User_message.textField_4.setText("3（普通员工）");
				}
				else if(User_check.check(UserName, Password)==4) { //销售员
					Main.user_message.setEnabled(true);
					Main.employee.setEnabled(true);
					Main.sale.setEnabled(true);
					Main.storehouse.setEnabled(true);
					Main.login_panel.setVisible(false);
					Main.user_message_panel.setVisible(true);
					EmployeeNo=User_check.employeeno;
					Employee_manage.vData.clear();
					Employee_manage.employee_query_by_employeeno(User_check.employeeno);
					User_message.textField.setText(User_check.username);
					User_message.textField_2.setText(User_check.employeeno);
					User_message.textField_1.setText(Employee_manage.employeename);
					if(Employee_manage.departmentno.equals("sa"))
						User_message.textField_3.setText("销售部");
					else if(Employee_manage.departmentno.equals("pu"))
						User_message.textField_3.setText("采购部");
					else if(Employee_manage.departmentno.equals("ma"))
						User_message.textField_3.setText("管理层");
					if(User_check.rolelevel==1)
						User_message.textField_4.setText("1(系统管理员)");
					else if(User_check.rolelevel==2)
						User_message.textField_4.setText("2（公司管理层）");
					else if(User_check.rolelevel==3||User_check.rolelevel==4)
						User_message.textField_4.setText("3（普通员工）");
				}
				else {  //用户名或密码错误
					JOptionPane.showMessageDialog(null, "用户名或密码错误", "标题",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(207, 207, 93, 23);
		add(btnNewButton);

	}

}
