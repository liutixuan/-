package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class 副主界面 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					副主界面 window = new 副主界面();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void run() {
		try {
			副主界面 window = new 副主界面();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the application.
	 */
	public 副主界面() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("欢迎登陆医药信息管理系统");
		frame.setBounds(100, 100, 450, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("\u57FA\u672C\u4FE1\u606F\u7BA1\u7406");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(47, 25, 97, 34);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("\u67E5\u8BE2\u548C\u8D2D\u4E70\u836F\u54C1\u7BA1\u7406");
		label_1.setFont(new Font("宋体", Font.PLAIN, 16));
		label_1.setBounds(45, 105, 144, 34);
		frame.getContentPane().add(label_1);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u4E2A\u4EBA\u4FE1\u606F\u4FEE\u6539", "\u4E2A\u4EBA\u4FE1\u606F\u67E5\u8BE2"}));
		comboBox.setBounds(199, 25, 134, 37);
		frame.getContentPane().add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				if(comboBox.getSelectedItem() == "个人信息修改") {
					个人信息修改.run();
					frame.setVisible(false);
				}
				if(comboBox.getSelectedItem() == "个人信息查询") {
					个人信息查询.run();
					frame.setVisible(false);
				}				
				
			}
		});
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u8D2D\u4E70\u836F\u54C1", "\u836F\u54C1\u67E5\u8BE2\u548C\u6D4F\u89C8", "\u5220\u9664\u5DF2\u8D2D\u836F\u54C1"}));
		comboBox_1.setBounds(199, 105, 134, 37);
		frame.getContentPane().add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				if(comboBox_1.getSelectedItem() == "购买药品") {
					购买药品.run();
					frame.setVisible(false);
				}
				if(comboBox_1.getSelectedItem() == "药品查询和浏览") {
					药品查询和浏览.run();
					frame.setVisible(false);
				}
				if(comboBox_1.getSelectedItem() == "删除已购药品") {
					已购药品删除.run();
					frame.setVisible(false);
				}
			}
		});			
				
		
		JLabel label_3 = new JLabel("\u7CFB\u7EDF\u7BA1\u7406");
		label_3.setFont(new Font("宋体", Font.PLAIN, 16));
		label_3.setBounds(47, 186, 97, 34);
		frame.getContentPane().add(label_3);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"\u4FEE\u6539\u5BC6\u7801", "\u6CE8\u9500\u8D26\u53F7", "\u9000\u51FA\u7CFB\u7EDF"}));
		comboBox_3.setBounds(199, 186, 134, 37);
		frame.getContentPane().add(comboBox_3);
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				if(comboBox_3.getSelectedItem() == "修改密码") {
					修改密码2.run();
					frame.setVisible(false);
				}
				if(comboBox_3.getSelectedItem() == "注销账号") {
					注销账号.run();
					frame.setVisible(false);
				}if(comboBox_3.getSelectedItem() == "退出系统") {
					System.exit(0);
				}
				
				
			}
		});			
		
		
		JLabel label_4 = new JLabel("\u5E2E\u52A9");
		label_4.setFont(new Font("宋体", Font.PLAIN, 16));
		label_4.setBounds(48, 265, 61, 37);
		frame.getContentPane().add(label_4);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"\u5173\u4E8E\u7CFB\u7EDF", "\u4F7F\u7528\u8BF4\u660E"}));
		comboBox_4.setBounds(199, 266, 134, 37);
		frame.getContentPane().add(comboBox_4);
		frame.getContentPane().add(comboBox_1);
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				if(comboBox_4.getSelectedItem() == "关于系统") {
					关于系统2.run();
					frame.setVisible(false);
				}
				if(comboBox_4.getSelectedItem() == "使用说明") {
					使用说明2.run();
					frame.setVisible(false);
				}
				
			}
		});			
				
	}
}
