package wholesale_manager;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import data_manage.Customer_manage;
import data_manage.Purchase_manage;
import data_manage.Sale_manage;
import data_manage.Storehouse_manage;
import data_manage.Product_manage;

public class Add_sale extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	static String[] tempstr=new String[100];
	public int count=0;

	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	static String[] str=new String[5];
	public static Vector<Vector<String>> str1 = new Vector<Vector<String>>();
	static Vector<String> vRow = new Vector<String>();
	
	public String Make_saleno() {
		String str=null;
		while(true){
			int s = (int) (Math.random()*10000);
	        str="S"+String.valueOf(s);
	        if(Sale_manage.is_saleno_existed(str)==0)
	        	break;
		}
        return str;
	}
	
	public String Get_storehouseno(String supplierno) {
		String str=null;
		int dis[]= new int[5];
		int x2,y2;
		Customer_manage.vData.clear();
		Customer_manage.get_customer(supplierno);
		Storehouse_manage.get_storehouse();
		for(int i=0;i<Storehouse_manage.vData.size();i++)
		{
			Vector myVector=(Vector)Storehouse_manage.vData.elementAt(i);
			x2=(Customer_manage.x-Integer.parseInt((String)myVector.elementAt(1)))*(Customer_manage.x-Integer.parseInt((String)myVector.elementAt(1)));
			y2=(Customer_manage.y-Integer.parseInt((String)myVector.elementAt(2)))*(Customer_manage.y-Integer.parseInt((String)myVector.elementAt(2)));
			dis[i]=x2+y2;
		}
		int index = 0;
		int a = dis[0];
		for(int i=0; i<Storehouse_manage.vData.size(); i++){
			if(dis[i] < a){
				a = dis[i];
				index = i;
			}
		}
		//System.out.println(index);
		Vector myVector1=(Vector)Storehouse_manage.vData.elementAt(index);
		str=(String)myVector1.elementAt(0);
		return str;
	}

	/**
	 * Create the dialog.
	 */
	public Add_sale() {
		setBounds(450, 230, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JButton confirm2 = new JButton("\u786E\u8BA4");
		
		JButton submit = new JButton("\u63D0\u4EA4");
		submit.setEnabled(false);
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag1=Sale_manage.insert_sale(str);
				int flag2=0;
				for(int i=0;i<str1.size();i++) {
				   flag2=Sale_manage.insert_saledetial(str,str1,i);
				}
				if(flag1==1 && flag2==1) {
					JOptionPane.showMessageDialog(null, "添加成功！", "标题",JOptionPane.WARNING_MESSAGE);
				    Sale.dialog.dispose();
				}					
				else
					JOptionPane.showMessageDialog(null, "添加失败！", "标题",JOptionPane.WARNING_MESSAGE);
			}
		});
		submit.setBounds(126, 211, 93, 23);
		contentPanel.add(submit);
		
		JLabel label = new JLabel("\u6DFB\u52A0\u9500\u552E\u5355");
		label.setFont(new Font("楷体", Font.PLAIN, 18));
		label.setBounds(170, 10, 99, 23);
		contentPanel.add(label);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u5BA2\u6237\u7F16\u53F7\uFF1A");
		label_1.setBounds(54, 48, 123, 15);
		contentPanel.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(163, 45, 93, 21);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton confirm1 = new JButton("\u786E\u8BA4");
		confirm1.addActionListener(new ActionListener() {
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
	
			@SuppressWarnings("unused")
			public void actionPerformed(ActionEvent arg0) {
				int flag2=0;
				char [] char_tempstr1=new char[100];
				String tempstr1=textField.getText();
				char_tempstr1=tempstr1.toCharArray();
				if(tempstr1==null) {
					flag2=0;
				}
				else if(Customer_manage.customer_query_by_customerno(tempstr1)==1)
					flag2=1;
				else if(!(char_tempstr1[0]>='A' && char_tempstr1[0]<='Z' && isNumeric2(tempstr1)))
					flag2=0;
			
				if (flag2==0) {
					JOptionPane.showMessageDialog(null, "请检查输入！", "标题",JOptionPane.WARNING_MESSAGE);
				}
				else {
					str[0]=Make_saleno();
					SimpleDateFormat tempDate = new SimpleDateFormat("yyyy-MM-dd");  
					str[1]=tempDate.format(new java.util.Date());
					str[2]=Login.EmployeeNo;
					str[3]=textField.getText();
					str[4]=Get_storehouseno(textField.getText());
					confirm1.setEnabled(false);
					confirm2.setEnabled(true);
				}
			}
		});
		confirm1.setBounds(277, 44, 93, 23);
		contentPanel.add(confirm1);
		
		JLabel label_2 = new JLabel("\u8BF7\u5728\u4E0B\u65B9\u8F93\u5165\u6B64\u9500\u552E\u5355\u7684\u5546\u54C1\u8BE6\u7EC6\u4FE1\u606F\uFF08\u4E00\u6B21\u4E00\u6761\uFF09");
		label_2.setBounds(88, 91, 312, 15);
		contentPanel.add(label_2);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1\u7F16\u53F7\uFF1A");
		lblNewLabel.setBounds(126, 116, 70, 15);
		contentPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u6570\u91CF\uFF1A");
		lblNewLabel_1.setBounds(126, 141, 70, 15);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u9500\u552E\u5355\u4EF7\uFF1A");
		lblNewLabel_2.setBounds(126, 166, 70, 15);
		contentPanel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(196, 113, 99, 21);
		contentPanel.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(196, 138, 99, 21);
		contentPanel.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(196, 163, 99, 21);
		contentPanel.add(textField_3);
		textField_3.setColumns(10);
		
		confirm2.setEnabled(false);
		confirm2.addActionListener(new ActionListener() {
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
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {
				int flag4=1;
				int flag5=1;
				int flag6=1;
				String temp_pno=textField_1.getText();
				String temp_quantity=textField_2.getText();
				String temp_price=textField_3.getText();
				
				tempstr[count]=temp_pno;
				count++;				
				
				
				char [] char_pno=new char[100];
				char_pno=temp_pno.toCharArray();
				for(int j=0; j<1; j++) {
					if(textField_1.getText()==null || textField_2.getText()==null || textField_3.getText()==null) {
						flag4=0;
						System.out.println("1");
						break;
					}
					for(int k=0;k<count;k++) {
						if(count!=1&&textField_1.getText().equals(tempstr[k])) {
							flag5=0;
							System.out.println("2");
							break;
						}
					}
					if( Product_manage.product_query_by_productno(temp_pno)==0) {
						flag4=0;
						System.out.println("3");
						break;
					}
					//Product_manage.vData.clear();
					Product_manage.product__num_query_by_storehouseno_and_productno(str[4],temp_pno);
					int a = Integer.parseInt(temp_quantity);
					int b = Integer.parseInt(Product_manage.num);
					if(a>b) {
						flag6=0;
						break;
					}
					if(!(isNumeric(temp_quantity) && isNumeric(temp_price))) {
						flag4=0;	
						System.out.println("4");
						break;
					}
					if(!(isNumeric2(temp_pno) && char_pno[0]<='Z' && char_pno[0]>='A')) {
						flag4=0;	
						System.out.println("5");
						break;
					}
				}
				
				
				if (flag4==0) {
					JOptionPane.showMessageDialog(null, "请检查格式！", "标题",JOptionPane.WARNING_MESSAGE);
				}
				else if(flag5==0) {
					JOptionPane.showMessageDialog(null, "请勿输入重复商品编号！", "标题",JOptionPane.WARNING_MESSAGE);
				}
				else if(flag6==0) {
					JOptionPane.showMessageDialog(null, "该商品剩余库存不足！\n仅剩"+Product_manage.num+"\n请修改商品数量或先增加库存再进行销售单添加", "标题",JOptionPane.WARNING_MESSAGE);
				}
				else {
					vRow.add(textField_1.getText());
					vRow.add(textField_2.getText());
					vRow.add(textField_3.getText());
					str1.add((Vector<String>) vRow.clone());
					vRow.clear();
					JOptionPane.showMessageDialog(null, "接收成功！", "标题",JOptionPane.WARNING_MESSAGE);
					textField_1.setText("");
					textField_2.setText("");
					textField_3.setText("");
					submit.setEnabled(true);
				}
			}
		});
		confirm2.setBounds(301, 162, 70, 23);
		contentPanel.add(confirm2);
		
		JLabel lblNewLabel_3 = new JLabel("\uFF08\u786E\u8BA4\u8F93\u5165\u5185\u5BB9\u540E\u53EF\u70B9\u51FB\uFF09");
		lblNewLabel_3.setBounds(104, 236, 157, 15);
		contentPanel.add(lblNewLabel_3);
		
		JButton cancel = new JButton("\u53D6\u6D88");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sale.dialog.dispose();
			}
		});
		cancel.setBounds(242, 211, 93, 23);
		contentPanel.add(cancel);
	}
}
