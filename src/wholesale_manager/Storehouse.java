package wholesale_manager;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import data_manage.Product_manage;

public class Storehouse extends JPanel {

private JTable table;
	
	public Vector<String> vName = new Vector<String>();
	public Vector<String> vName1 = new Vector<String>();
	
	public void settable(JTable table, Vector<String> vName) {
		DefaultTableModel model = new DefaultTableModel(Product_manage.vData, vName);
		table.setModel(model);
//		TableColumn firsetColumn = table.getColumnModel().getColumn(3);
//		firsetColumn.setPreferredWidth(35);
//		TableColumn firsetColumn1 = table.getColumnModel().getColumn(4);
//		firsetColumn1.setPreferredWidth(35);
//		TableColumn firsetColumn2 = table.getColumnModel().getColumn(1);
//		firsetColumn2.setPreferredWidth(110);
	}

	/**
	 * Create the panel.
	 */
	public Storehouse() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 494, 189);
		add(scrollPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u67E5\u8BE2\u5546\u54C1\u4FE1\u606F", "\u67E5\u8BE2\u5546\u54C1\u5E93\u5B58", "\u67E5\u8BE2\u4ED3\u5E93B1\u5E93\u5B58", "\u67E5\u8BE2\u4ED3\u5E93S1\u5E93\u5B58", "\u67E5\u8BE2\u4ED3\u5E93G1\u5E93\u5B58"}));
		comboBox.setBounds(193, 55, 128, 21);
		comboBox.getSelectedItem().toString();
		add(comboBox);
		
		vName.add("商品编号");
		vName.add("商品名称");
		vName.add("商品类别");
		vName.add("销售单价");
		
		vName1.add("商品编号");
		vName1.add("商品名称");
		vName1.add("库存数量");
		
		Vector zData = null;
		Vector zName = null;
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u4FE1\u606F\u7BA1\u7406");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel.setBounds(205, 7, 128, 28);
		add(lblNewLabel);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton query = new JButton("\u67E5\u8BE2");
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString()=="查询商品信息") {
					Product_manage.vData.clear();
					Product_manage.product_message_query();
					settable(table,vName);
					table.setEnabled(true);
				}
				else if(comboBox.getSelectedItem().toString()=="查询商品库存") {
					Product_manage.vData.clear();
					Product_manage.product_num_query_all();
					settable(table,vName1);
					table.setEnabled(false);
				}
				else if(comboBox.getSelectedItem().toString()=="查询仓库B1库存") {
					Product_manage.vData.clear();
					Product_manage.product__num_query_by_storehouseno("B1");
					settable(table,vName1);
					table.setEnabled(false);
				}
				else if(comboBox.getSelectedItem().toString()=="查询仓库S1库存") {
					Product_manage.vData.clear();
					Product_manage.product__num_query_by_storehouseno("S1");
					settable(table,vName1);
					table.setEnabled(false);
				}
				else if(comboBox.getSelectedItem().toString()=="查询仓库G1库存") {
					Product_manage.vData.clear();
					Product_manage.product__num_query_by_storehouseno("G1");
					settable(table,vName1);
					table.setEnabled(false);
				}
			}
		});
		query.setBounds(331, 54, 100, 23);
		add(query);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u9009\u62E9\u67E5\u8BE2\u65B9\u5F0F\uFF1A");
		lblNewLabel_1.setBounds(79, 58, 116, 15);
		add(lblNewLabel_1);

	}

}
