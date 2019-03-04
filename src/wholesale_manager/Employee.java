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
import data_manage.Employee_manage;
import data_manage.User_check;

public class Employee extends JPanel {

private JTable table;
	
	public Vector<String> vName = new Vector<String>();
	public String[] getmessage_employee=new String[8];
	public int flag;
	
	 DefaultTableModel newTableModel = new DefaultTableModel(Employee_manage.vData, vName){
         @Override
         public boolean isCellEditable(int row,int column){
        	 if(column == 2 || column == 4|| column == 6|| column == 7){  
  		       return true;  
  		   }else{  
  		       return false;  
  		   }
         }
     };

	 
	public void settable(JTable table) {
		DefaultTableModel model = new DefaultTableModel(Employee_manage.vData, vName);
		table.setModel(model);
		TableColumn firsetColumn = table.getColumnModel().getColumn(3);
		firsetColumn.setPreferredWidth(27);
		TableColumn firsetColumn1 = table.getColumnModel().getColumn(4);
		firsetColumn1.setPreferredWidth(120);
		TableColumn firsetColumn2 = table.getColumnModel().getColumn(6);
		firsetColumn2.setPreferredWidth(30);
		TableColumn firsetColumn3 = table.getColumnModel().getColumn(2);
		firsetColumn3.setPreferredWidth(50);
		TableColumn firsetColumn4 = table.getColumnModel().getColumn(7);
		firsetColumn4.setPreferredWidth(30);
		TableColumn firsetColumn5 = table.getColumnModel().getColumn(1);
		firsetColumn5.setPreferredWidth(50);
	}
	
	public void settable1(JTable table) {
		table.setModel(newTableModel);
		TableColumn firsetColumn = table.getColumnModel().getColumn(3);
		firsetColumn.setPreferredWidth(27);
		TableColumn firsetColumn1 = table.getColumnModel().getColumn(4);
		firsetColumn1.setPreferredWidth(120);
		TableColumn firsetColumn2 = table.getColumnModel().getColumn(6);
		firsetColumn2.setPreferredWidth(30);
		TableColumn firsetColumn3 = table.getColumnModel().getColumn(2);
		firsetColumn3.setPreferredWidth(50);
		TableColumn firsetColumn4 = table.getColumnModel().getColumn(7);
		firsetColumn4.setPreferredWidth(30);
		TableColumn firsetColumn5 = table.getColumnModel().getColumn(1);
		firsetColumn5.setPreferredWidth(50);
	}

	/**
	 * Create the panel.
	 */
	public Employee() {
		setBackground(Color.WHITE);
		setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 108, 494, 189);
		add(scrollPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u5168\u90E8\u67E5\u8BE2", "\u6309\u5458\u5DE5\u59D3\u540D\u67E5"}));
		comboBox.setBounds(198, 77, 128, 21);
		comboBox.getSelectedItem().toString();
		add(comboBox);
		
		vName.add("员工编号");
		vName.add("员工姓名");
		vName.add("所属部门");
		vName.add("性别");
		vName.add("地址");
		vName.add("聘用日期");
		vName.add("薪水");
		vName.add("状态");
		Vector zData = null;
		Vector zName = null;
		
		
		//String[] getmessage=new String[8];
		
		JLabel lblNewLabel = new JLabel("\u5458\u5DE5\u4FE1\u606F\u7BA1\u7406");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 18));
		lblNewLabel.setBounds(199, 10, 127, 28);
		add(lblNewLabel);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setSurrendersFocusOnKeystroke(true);
		table.setFillsViewportHeight(true);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		JButton save = new JButton("\u4FDD\u5B58\u4FEE\u6539");
		
		JButton query = new JButton("\u67E5\u8BE2");
		query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().toString()=="全部查询") {
					Employee_manage.vData.clear();
					Employee_manage.employee_query_all();
					settable(table);
				}
				else if(comboBox.getSelectedItem().toString()=="按员工姓名查") {
					String inputValue = null;
					Employee_manage.vData.clear();
					inputValue=JOptionPane.showInputDialog("请输入员工姓名");
					if(inputValue!=null) {
						if(Employee_manage.employee_query_by_employeename(inputValue)==1) {
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
		query.setBounds(336, 76, 100, 23);
		add(query);
		
		JLabel lblNewLabel_1 = new JLabel("\u8BF7\u9009\u62E9\u67E5\u8BE2\u65B9\u5F0F\uFF1A");
		lblNewLabel_1.setBounds(91, 80, 109, 15);
		add(lblNewLabel_1);
		
		JButton add = new JButton("\u6DFB\u52A0\u5458\u5DE5");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Employee_manage.vData.clear();
				table.setModel(new DefaultTableModel(
						new Object[][] {
							{null, null, null, null, null, null,null,null},
						},
						new String[] {
							"员工编号", "员工姓名", "所属部门", "性别", "地址", "聘用日期","薪水","状态"
						}
					));
				TableColumn firsetColumn = table.getColumnModel().getColumn(3);
				firsetColumn.setPreferredWidth(27);
				TableColumn firsetColumn1 = table.getColumnModel().getColumn(4);
				firsetColumn1.setPreferredWidth(120);
				TableColumn firsetColumn2 = table.getColumnModel().getColumn(6);
				firsetColumn2.setPreferredWidth(30);
				TableColumn firsetColumn3 = table.getColumnModel().getColumn(2);
				firsetColumn3.setPreferredWidth(50);
				TableColumn firsetColumn4 = table.getColumnModel().getColumn(7);
				firsetColumn4.setPreferredWidth(30);
				TableColumn firsetColumn5 = table.getColumnModel().getColumn(1);
				firsetColumn5.setPreferredWidth(50);
				save.setEnabled(true);
				table.setEnabled(true);
				flag=0;
			}
		});
		add.setBounds(336, 42, 100, 23);
		add(add);
		
		//JButton save = new JButton("\u4FDD\u5B58\u4FEE\u6539");
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
			public void actionPerformed(ActionEvent arg0) {
				int count=table.getSelectedRow();
				int i;
				for(i=0;i<8;i++) {
					getmessage_employee[i]=table.getValueAt(count, i).toString();
				}
				int flag2=1;
				char[][] char_getmessage_employee=new char[8][];
				for(i=0;i<8;i++) {					// 转化为字符数组
					char_getmessage_employee[i]=getmessage_employee[i].toCharArray();
				}
				for(int j=0;j<1;j++) {
					if(!(char_getmessage_employee[0][0]=='E' && isNumeric2(getmessage_employee[0]))) {
						flag2=0;
						break;
					}
					if(!checkname(getmessage_employee[1])) {
						flag2=0;
						break;
					}
					if(!(getmessage_employee[2].equals("pu")||  getmessage_employee[2].equals("ma") || getmessage_employee[2].equals("sa")))
					{
						flag2=0;
						break;
					}
					if( !(getmessage_employee[3].equals("F") || getmessage_employee[3].equals("M") )) {
						flag2=0;
						break;
					}
					if(isNumeric(getmessage_employee[4])) {
						flag2=0;
						break;
					}
					if(!(isNumeric_set(getmessage_employee[5],0,3) && isNumeric_set(getmessage_employee[5],5,6) && isNumeric_set(getmessage_employee[5],8,9)
							&& char_getmessage_employee[5][4]=='-' && char_getmessage_employee[5][7]=='-')) {
						flag2=0;
						break;
					}
					if(!isNumeric(getmessage_employee[6])) {
						flag2=0;
						break;
					}
					if(!(getmessage_employee[7].equals("leave") || getmessage_employee[7].equals("in"))) {
						flag2=0;
						break;
					}
				}
				if(flag==0 && flag2==1) {//添加员工
					String[] str=new String[4];
					str[0]=getmessage_employee[0];
					str[1]=getmessage_employee[0];
					if(getmessage_employee[2].equals("ma")) {
						str[2]="2";
					}
					else if(getmessage_employee[2].equals("pu")) {
						str[2]="3";
					}
					else if(getmessage_employee[2].equals("sa")) {
						str[2]="4";
					}
					str[3]=getmessage_employee[0];
					if(Employee_manage.insert_employee_info(getmessage_employee)==1&&Employee_manage.insert_user(str)==1) {
						
						JOptionPane.showMessageDialog(null, "添加成功！\n此员工用户名级初始密码均为"+getmessage_employee[0], "标题",JOptionPane.WARNING_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "添加失败！", "标题",JOptionPane.WARNING_MESSAGE);
					}
				}
				else if(flag==1 && flag2==1) {//修改员工信息
					if(Employee_manage.update_employee_info(getmessage_employee)==1) {
						if(getmessage_employee[7].equals("leave")) {
							User_check.delete_user(getmessage_employee[0]);
							JOptionPane.showMessageDialog(null, "修改成功！\n该员工的登录用户信息已删除", "标题",JOptionPane.WARNING_MESSAGE);
						}
						else
							JOptionPane.showMessageDialog(null, "修改成功！", "标题",JOptionPane.WARNING_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(null, "修改失败！", "标题",JOptionPane.WARNING_MESSAGE);
					}
				}
				else {
					JOptionPane.showMessageDialog(null, "请检查格式！", "标题",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		save.setBounds(414, 295, 90, 16);
		add(save);
		
		JButton change = new JButton("\u4FEE\u6539\u5458\u5DE5\u4FE1\u606F");
		change.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String inputValue = null;
				Employee_manage.vData.clear();
				inputValue=JOptionPane.showInputDialog("请输入所要修改的员工的编号");
				if(inputValue!=null) {
					if(Employee_manage.employee_query_by_employeeno(inputValue)==1) {
						settable1(table);
					}
					else {
						JOptionPane.showMessageDialog(null, "请输入正确的员工编号！", "标题",JOptionPane.WARNING_MESSAGE);
					}
				}
				table.setEnabled(true);
				save.setEnabled(true);
				flag=1;
			}
		});
		change.setBounds(209, 42, 117, 23);
		add(change);

	}
}
