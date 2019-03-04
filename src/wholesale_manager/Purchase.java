package wholesale_manager;

import javax.swing.JPanel;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dialog.ModalityType;

import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import data_manage.Customer_manage;
import data_manage.Purchase_manage;

import javax.swing.border.LineBorder;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class Purchase extends JPanel {
	private JTable table;

	/**
	 * Create the panel.
	 */
	
	
	public Vector<String> vName = new Vector<String>();
	public static JDialog dialog ;
	
	public static boolean isValidDate(String str) {
		        boolean convertSuccess=true;
		         SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		       try {
		            format.setLenient(false);
		            format.parse(str);
		         } catch (ParseException e) {
		            convertSuccess=false;
		       } 
		        return convertSuccess;
		 }
	 
	public void settable(JTable table) {
		DefaultTableModel model = new DefaultTableModel(Purchase_manage.vData, vName);
		table.setModel(model);
		TableColumn firsetColumn = table.getColumnModel().getColumn(7);
		firsetColumn.setPreferredWidth(35);
		TableColumn firsetColumn1 = table.getColumnModel().getColumn(6);
		firsetColumn1.setPreferredWidth(60);
		TableColumn firsetColumn2 = table.getColumnModel().getColumn(1);
		firsetColumn2.setPreferredWidth(90);
	}
	
	public Purchase() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u91C7\u8D2D\u5355\u7BA1\u7406");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel.setBounds(205, 10, 93, 23);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 494, 189);
		add(scrollPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5168\u90E8\u67E5\u8BE2", "\u6309\u65E5\u671F\u67E5", "\u6309\u91C7\u8D2D\u5355\u7F16\u53F7\u67E5", "\u6309\u4F9B\u5E94\u5546\u540D\u79F0\u67E5"}));
		comboBox.setBounds(195, 45, 128, 21);
		comboBox.getSelectedItem().toString();
		add(comboBox);
		
		vName.add("采购单编号");
		vName.add("采购日期");
		vName.add("职工编号");
		vName.add("供应商编号");
		vName.add("仓库编号");
		vName.add("商品编号");
		vName.add("商品数量");
		vName.add("单价");
		Vector zData = null;
		Vector zName = null;
		
		table = new JTable();
		table.setEnabled(false);
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton query = new JButton("\u67E5\u8BE2");
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString()=="全部查询") {
					Purchase_manage.vData.clear();
					Purchase_manage.purchase_query_all();
					settable(table);
				}
				else if(comboBox.getSelectedItem().toString()=="按日期查") {
					String inputValue = null;
					Purchase_manage.vData.clear();
					while(true) {
						inputValue=JOptionPane.showInputDialog("请输入查询日期，格式如：2018-12-12");
						if(inputValue!=null) {
							if(isValidDate(inputValue)) {
								if(Purchase_manage.purchase_query_by_date(inputValue)==1) {
									settable(table);
								}
								else {
									JOptionPane.showMessageDialog(null, "无符合条件的记录！", "标题",JOptionPane.WARNING_MESSAGE);
								}
								break;
							}
							else {
								JOptionPane.showMessageDialog(null, "输入日期格式有误，请重新输入！", "标题",JOptionPane.WARNING_MESSAGE);
							}
						}
					}
				}
				else if(comboBox.getSelectedItem().toString()=="按采购单编号查") {
					String inputValue = null;
					Purchase_manage.vData.clear();
					inputValue=JOptionPane.showInputDialog("请输入采购单编号，格式如：P0001");
					if(inputValue!=null) {
						if(Purchase_manage.purchase_query_by_purchaseno(inputValue)==1) {
							settable(table);
						}
						else {
							JOptionPane.showMessageDialog(null, "无符合条件的记录！", "标题",JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				else if(comboBox.getSelectedItem().toString()=="按供应商名称查") {
					String inputValue = null;
					Purchase_manage.vData.clear();
					inputValue=JOptionPane.showInputDialog("请输入供应商名称");
					if(inputValue!=null) {
						if(Purchase_manage.purchase_query_by_suppliername(inputValue)==1) {
							settable(table);
						}
						else {
							JOptionPane.showMessageDialog(null, "无符合条件的记录！", "标题",JOptionPane.WARNING_MESSAGE);
						}
					}
				}
			}
		});
		query.setBounds(330, 44, 100, 23);
		add(query);
		
		JButton add = new JButton("\u6DFB\u52A0\u91C7\u8D2D\u5355");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dialog = new Add_purchase();
				dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
				dialog.setModalityType(ModalityType.APPLICATION_MODAL);
				dialog.setVisible(true);
			}
		});
		add.setBounds(330, 75, 100, 23);
		add(add);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u9009\u62E9\u67E5\u8BE2\u65B9\u5F0F\uFF1A");
		lblNewLabel_1.setBounds(76, 48, 109, 15);
		add(lblNewLabel_1);
		

	}
}



