package wholesale_manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data_manage.User_check;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Change_password extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the dialog.
	 */
	public Change_password() {
		setBounds(450, 230, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel.setBounds(119, 79, 99, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u786E\u8BA4\u65B0\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setBounds(119, 117, 99, 15);
		contentPanel.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(219, 76, 89, 21);
		contentPanel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(219, 114, 89, 21);
		contentPanel.add(passwordField_1);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(passwordField.getText().equals((passwordField_1.getText()))){
					if(passwordField.getText().length()>10) {
						JOptionPane.showMessageDialog(null, "密码长度不可超过10位！", "标题",JOptionPane.WARNING_MESSAGE);
					}
					else if(User_check.update_user_info(User_check.username,passwordField.getText())==1) {
						JOptionPane.showMessageDialog(null, "修改成功！", "标题",JOptionPane.WARNING_MESSAGE);
						User_message.dialog.dispose();
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "两次输入密码不一致！", "标题",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(169, 169, 93, 23);
		contentPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u53D6\u6D88");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User_message.dialog.dispose();
			}
		});
		btnNewButton_1.setBounds(169, 202, 93, 23);
		contentPanel.add(btnNewButton_1);
	}
}
