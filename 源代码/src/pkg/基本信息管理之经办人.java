package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javafx.event.ActionEvent;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class 基本信息管理之经办人 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					基本信息管理之经办人 window = new 基本信息管理之经办人();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		/*});
	}*/
	
	/**
	 * Create the application.
	 */
	public 基本信息管理之经办人() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("经办人信息管理");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("\u7ECF\u529E\u4EBA\u4FE1\u606F\u5F55\u5165");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent arg0) {
				经办人信息录入.run();
				frame.setVisible(false);
			}
		});
		button.setFont(new Font("宋体", Font.PLAIN, 16));
		button.setBounds(121, 32, 193, 37);
		frame.getContentPane().add(button);
		
		
		JButton button_1 = new JButton("\u7ECF\u529E\u4EBA\u4FE1\u606F\u4FEE\u6539\u548C\u5220\u9664");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				经办人信息修改和删除.run();
				frame.setVisible(false);
			}
		});
		button_1.setFont(new Font("宋体", Font.PLAIN, 16));
		button_1.setBounds(121, 109, 193, 37);
		frame.getContentPane().add(button_1);
		
		
		
		JButton button_2 = new JButton("\u8FD4\u56DE");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) {
				主界面.run();
				frame.setVisible(false);//关掉此界面
			}
		});
		button_2.setFont(new Font("宋体", Font.PLAIN, 16));
		button_2.setBounds(121, 187, 188, 37);
		frame.getContentPane().add(button_2);
	}

}
