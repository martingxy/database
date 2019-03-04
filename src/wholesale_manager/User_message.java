package wholesale_manager;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Dialog.ModalityType;
import java.util.Vector;

import javax.swing.JTextField;

import data_manage.Employee_manage;
import data_manage.Storehouse_manage;
import data_manage.User_check;

import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class User_message extends JPanel {
	public static JTextField textField;
	public static JTextField textField_1;
	public static JTextField textField_2;
	public static JTextField textField_3;
	public static JTextField textField_4;
	public static JDialog dialog ;

	/**
	 * Create the panel.
	 */
	public User_message() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u7528\u6237\u4FE1\u606F");
		lblNewLabel.setFont(new Font("¿¬Ìå", Font.PLAIN, 18));
		lblNewLabel.setBounds(218, 10, 152, 24);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u7528\u6237\u540D\uFF1A");
		lblNewLabel_1.setBounds(148, 76, 77, 15);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5458\u5DE5\u59D3\u540D\uFF1A");
		lblNewLabel_2.setBounds(148, 112, 77, 15);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u5458\u5DE5\u7F16\u53F7\uFF1A");
		lblNewLabel_3.setBounds(148, 152, 77, 15);
		add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u6240\u5C5E\u90E8\u95E8\uFF1A");
		lblNewLabel_4.setBounds(148, 190, 77, 15);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("\u6743\u9650\u7B49\u7EA7\uFF1A");
		lblNewLabel_5.setBounds(148, 232, 77, 15);
		add(lblNewLabel_5);
		
		
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setBounds(250, 73, 99, 21);
		add(textField);
		textField.setColumns(10);
		
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setBounds(250, 109, 99, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setBounds(250, 149, 99, 21);
		add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setBounds(250, 187, 99, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setBounds(250, 229, 99, 21);
		add(textField_4);
		textField_4.setColumns(10);
		
		
		JButton btnNewButton = new JButton("\u4FEE\u6539\u5BC6\u7801");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dialog = new Change_password();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setModalityType(ModalityType.APPLICATION_MODAL);
				dialog.setVisible(true);
			}
		});
		btnNewButton.setBounds(411, 288, 93, 23);
		add(btnNewButton);

	}
}
