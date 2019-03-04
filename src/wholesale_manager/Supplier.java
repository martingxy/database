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

import data_manage.Customer_manage;
import data_manage.Supplier_manage;

public class Supplier extends JPanel {
	private JTable table;

    public Vector<String> vName = new Vector<String>();
    public String[] getmessage_supplier=new String[6];
	public int flag;
	
	DefaultTableModel newTableModel = new DefaultTableModel(Supplier_manage.vData, vName){
        @Override
        public boolean isCellEditable(int row,int column){
       	 if(column !=0){  
 		       return true;  
 		   }else{  
 		       return false;  
 		   }
        }
    };
	
	public void settable(JTable table) {
		DefaultTableModel model = new DefaultTableModel(Supplier_manage.vData, vName);
		table.setModel(model);
		TableColumn firsetColumn = table.getColumnModel().getColumn(3);
		firsetColumn.setPreferredWidth(35);
		TableColumn firsetColumn1 = table.getColumnModel().getColumn(4);
		firsetColumn1.setPreferredWidth(35);
		TableColumn firsetColumn2 = table.getColumnModel().getColumn(1);
		firsetColumn2.setPreferredWidth(110);
	}
	
	public void settable1(JTable table) {
		table.setModel(newTableModel);
		TableColumn firsetColumn = table.getColumnModel().getColumn(3);
		firsetColumn.setPreferredWidth(35);
		TableColumn firsetColumn1 = table.getColumnModel().getColumn(4);
		firsetColumn1.setPreferredWidth(35);
		TableColumn firsetColumn2 = table.getColumnModel().getColumn(1);
		firsetColumn2.setPreferredWidth(110);
	}

	/**
	 * Create the panel.
	 */
	public Supplier() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 494, 189);
		add(scrollPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5168\u90E8\u67E5\u8BE2", "\u6309\u4F9B\u5E94\u5546\u540D\u79F0\u67E5"}));
		comboBox.setBounds(198, 80, 128, 21);
		comboBox.getSelectedItem().toString();
		add(comboBox);
		
		vName.add("供应商编号");
		vName.add("供应商名称");
		vName.add("地址");
		vName.add("经度");
		vName.add("纬度");
		vName.add("联系电话");
		Vector zData = null;
		Vector zName = null;
		
		JLabel lblNewLabel = new JLabel("\u4F9B\u5E94\u5546\u4FE1\u606F\u7BA1\u7406");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel.setBounds(199, 10, 127, 28);
		add(lblNewLabel);
		
		JButton save = new JButton("\u4FDD\u5B58\u4FEE\u6539");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton query = new JButton("\u67E5\u8BE2");
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString()=="全部查询") {
					Supplier_manage.vData.clear();
					Supplier_manage.supplier_query_all();
					settable(table);
				}
				else if(comboBox.getSelectedItem().toString()=="按供应商名称查") {
					String inputValue = null;
					Supplier_manage.vData.clear();
					inputValue=JOptionPane.showInputDialog("请输入供应商名称");
					if(inputValue!=null) {
						if(Supplier_manage.supplier_query_by_suppliername(inputValue)==1) {
							settable(table);
						}
						else {
							JOptionPane.showMessageDialog(null, "无符合条件的记录！", "标题",JOptionPane.WARNING_MESSAGE);
						}
					}
				}
				table.setEnabled(false);
				save.setEnabled(false);
			}
		});
		query.setBounds(332, 79, 100, 23);
		add(query);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u9009\u62E9\u67E5\u8BE2\u65B9\u5F0F\uFF1A");
		lblNewLabel_1.setBounds(79, 83, 109, 15);
		add(lblNewLabel_1);
		
		JButton add = new JButton("\u6DFB\u52A0\u4F9B\u5E94\u5546");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Supplier_manage.vData.clear();
				table.setModel(new DefaultTableModel(
						new Object[][] {
							{null, null, null, null, null, null},
						},
						new String[] {
							"供应商编号", "供应商名称", "地址", "经度", "纬度", "联系电话"
						}
					));
				TableColumn firsetColumn = table.getColumnModel().getColumn(3);
				firsetColumn.setPreferredWidth(35);
				TableColumn firsetColumn1 = table.getColumnModel().getColumn(4);
				firsetColumn1.setPreferredWidth(35);
				TableColumn firsetColumn2 = table.getColumnModel().getColumn(1);
				firsetColumn2.setPreferredWidth(110);
				save.setEnabled(true);
				table.setEnabled(true);
				flag=0;
			}
		});
		add.setBounds(332, 46, 100, 23);
		add(add);
		
		JButton change = new JButton("\u4FEE\u6539\u4F9B\u5E94\u5546\u4FE1\u606F");
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inputValue = null;
				Supplier_manage.vData.clear();
				inputValue=JOptionPane.showInputDialog("请输入所要修改的供应商的编号");
				if(inputValue!=null) {
					if(Supplier_manage.supplier_query_by_supplierno(inputValue)==1) {
						settable1(table);
					}
					else {
						JOptionPane.showMessageDialog(null, "无符合条件的记录！", "标题",JOptionPane.WARNING_MESSAGE);
					}
				}
				save.setEnabled(true);
				table.setEnabled(true);
				flag=1;
			}
		});
		change.setBounds(198, 46, 128, 23);
		add(change);
		
		save.addActionListener(new ActionListener() {
			private boolean isNumeric(String str) {
				for (int i = 0; i < str.length(); i++)
				{
					if (!Character.isDigit(str.charAt(i)))
					{
						return false;
					}
				}
				return true;
			}
			private boolean isNumeric_set(String str,int a,int b) {
				for (int i = a; i <= b; i++)
				{
					if (!Character.isDigit(str.charAt(i)))
					{
						return false;
					}
				}
				return true;
			}
			private boolean isNumeric2(String str) {
				for (int i = 1; i < str.length(); i++)
				{
					if (!Character.isDigit(str.charAt(i)))
					{
						return false;
					}
				}
				return true;
			}
			public boolean checkname(String name)
		    {
		        int n = 0;
		        for(int i = 0; i < name.length(); i++) {
		            n = (int)name.charAt(i);
		            if(!(19968 <= n && n <40869)) {
		                return false;
		            }
		        }
		        return true;
		    }
			public void actionPerformed(ActionEvent e) {
				int count=table.getSelectedRow();
				int i;
				for(i=0;i<6;i++) {
					getmessage_supplier[i]=table.getValueAt(count, i).toString();
					//System.out.println(getmessage_employee[i]);
				}
				int flag2=1;
				char[][] char_getmessage_supplier=new char[8][];
				for(i=0;i<6;i++) {					// 转化为字符数组
					char_getmessage_supplier[i]=getmessage_supplier[i].toCharArray();
				}
				for(int j=0;j<1;j++) {
					if(!(char_getmessage_supplier[0][0]>='A' &&  char_getmessage_supplier[0][0]<='Z' && isNumeric2(getmessage_supplier[0])))
					{
						flag2=0;
						break;
					}
					if(!checkname(getmessage_supplier[1])) {
						flag2=0;
						break;
					}
					if(isNumeric(getmessage_supplier[2])) {
						flag2=0;
						break;
					}
					if(!isNumeric(getmessage_supplier[3])) {
						flag2=0;
						break;
					}
					if(!isNumeric(getmessage_supplier[4])) {
						flag2=0;
						break;
					}
					if(!isNumeric(getmessage_supplier[5])) {
						flag2=0;
						break;
					}
				}
				//over 2/4/6/7
				if(flag==0 && flag2==1) {
					if(Supplier_manage.insert_supplier_info(getmessage_supplier)==1) {
						JOptionPane.showMessageDialog(null, "添加成功！", "标题",JOptionPane.WARNING_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "添加失败！", "标题",JOptionPane.WARNING_MESSAGE);
					}
				}
				else if(flag==1 && flag2==1) {
					if(Supplier_manage.update_supplier_info(getmessage_supplier)==1) {
						JOptionPane.showMessageDialog(null, "修改成功！", "标题",JOptionPane.WARNING_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "修改失败！", "标题",JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "格式错误！", "标题",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		save.setBounds(414, 295, 90, 16);
		add(save);

	}

}
