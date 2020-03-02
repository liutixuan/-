package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.Color;

public class 主界面 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public  void run() {
				try {
					主界面 window = new 主界面();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void run() {
		try {
			主界面 window = new 主界面();
			window.frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Create the application.
	 */
	public 主界面() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("欢迎登陆医药信息管理系统");
		frame.setBounds(100, 100, 452, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u987E\u5BA2\u7BA1\u7406", "\u836F\u54C1\u7BA1\u7406", "\u7ECF\u529E\u4EBA\u7BA1\u7406"}));
		comboBox.setBounds(181, 34, 124, 37);
		frame.getContentPane().add(comboBox);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				if(comboBox.getSelectedItem() == "顾客管理") {
					基本信息管理之顾客.run();
					frame.setVisible(false);
				}
				if(comboBox.getSelectedItem() == "经办人管理") {
					基本信息管理之经办人.run();
					frame.setVisible(false);
				}
				if(comboBox.getSelectedItem() == "药品管理") {
					基本信息管理之药品.run();
					frame.setVisible(false);
				}
				
			}
		});
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"\u987E\u5BA2\u67E5\u8BE2", "\u836F\u54C1\u67E5\u8BE2", "\u7ECF\u529E\u4EBA\u67E5\u8BE2"}));
		comboBox_1.setBounds(181, 89, 124, 37);
		frame.getContentPane().add(comboBox_1);
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				if(comboBox_1.getSelectedItem() == "顾客查询") {
					顾客信息查询和浏览.run();
					frame.setVisible(false);
				}
				if(comboBox_1.getSelectedItem() == "药品查询") {
					药品信息查询和浏览.run();
					frame.setVisible(false);
				}
				if(comboBox_1.getSelectedItem() == "经办人查询") {
					经办人信息查询和浏览.run();
					frame.setVisible(false);
				}
			}
		});
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"\u987E\u5BA2\u4FE1\u606F\u62A5\u8868", "\u836F\u54C1\u4FE1\u606F\u62A5\u8868", "\u7ECF\u529E\u4EBA\u4FE1\u606F\u62A5\u8868"}));
		comboBox_2.setBounds(181, 150, 124, 37);
		frame.getContentPane().add(comboBox_2);
		comboBox_2.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				if(comboBox_2.getSelectedItem() == "顾客信息报表") {
					顾客信息报表.run();
					frame.setVisible(false);
				}
				if(comboBox_2.getSelectedItem() == "药品信息报表") {
					药品信息报表.run();
					frame.setVisible(false);
				}
				if(comboBox_2.getSelectedItem() == "经办人信息报表") {
					经办人信息报表.run();
					frame.setVisible(false);
				}
			}
		});
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"\u6DFB\u52A0\u65B0\u7528\u6237", "\u4FEE\u6539\u548C\u5220\u9664\u7528\u6237\u4FE1\u606F", "\u4FEE\u6539\u5BC6\u7801", "\u9000\u51FA\u7CFB\u7EDF"}));
		comboBox_3.setBounds(181, 215, 124, 37);
		frame.getContentPane().add(comboBox_3);
		comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				if(comboBox_3.getSelectedItem() == "添加新用户") {
					添加新用户.run();
					frame.setVisible(false);
				}
				if(comboBox_3.getSelectedItem() == "修改和删除用户信息") {
					修改和删除用户信息.run();
					frame.setVisible(false);
				}
				if(comboBox_3.getSelectedItem() == "修改密码") {
					修改密码.run();
					frame.setVisible(false);
				}
				if(comboBox_3.getSelectedItem() == "退出系统") {
					System.exit(0);
				}
			}
		});
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"\u5173\u4E8E\u7CFB\u7EDF", "\u4F7F\u7528\u8BF4\u660E"}));
		comboBox_4.setBounds(181, 273, 124, 37);
		frame.getContentPane().add(comboBox_4);
		comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				if(comboBox_4.getSelectedItem() == "关于系统") {
					关于系统.run();
					frame.setVisible(false);
				}
				if(comboBox_4.getSelectedItem() == "使用说明") {
					使用说明.run();
					frame.setVisible(false);
				}
				
			}
		});
		
	
		
	    JLabel label = new JLabel("\u7CFB\u7EDF\u7BA1\u7406");
		label.setFont(new Font("宋体", Font.PLAIN, 16));
		label.setBounds(46, 215, 97, 34);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel_1 = new JLabel("\u57FA\u672C\u4FE1\u606F\u7BA1\u7406");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(46, 34, 97, 34);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5E2E\u52A9");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(46, 272, 61, 37);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u67E5\u8BE2\u7BA1\u7406");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(48, 89, 77, 37);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u6570\u636E\u62A5\u8868");
		lblNewLabel_4.setFont(new Font("宋体", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(46, 147, 69, 40);
		frame.getContentPane().add(lblNewLabel_4);
	}	
}
