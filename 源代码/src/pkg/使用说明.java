package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class 使用说明 {

	private JFrame frame;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					使用说明 window = new 使用说明();
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
	public 使用说明() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("使用说明");
		frame.setBounds(100, 100, 574, 326);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton button = new JButton("\u4E86\u89E3\u66F4\u591A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//判断当前系统是否支持Java AWT Desktop扩展
				if(java.awt.Desktop.isDesktopSupported()){
				try {
				//创建一个URI实例
				java.net.URI uri = java.net.URI.create("http://www.iqiyi.com/a_19rrhb3xvl.html?vfm=2008_aldbd");
				//获取当前系统桌面扩展
				java.awt.Desktop dp = java.awt.Desktop.getDesktop();
				//判断系统桌面是否支持要执行的功能
				if(dp.isSupported(java.awt.Desktop.Action.BROWSE)){
				//获取系统默认浏览器打开链接
				dp.browse(uri);
				}
				} catch (java.io.IOException e1) {
				//此为无法获取系统默认浏览器
				}
				}
			}
		});
		button.setBounds(104, 250, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				主界面.run();
				frame.setVisible(false);
			}
		});
		button_1.setBounds(307, 250, 93, 23);
		frame.getContentPane().add(button_1);
		
		textArea = new JTextArea();
		textArea.setText("本系统共有5大功能模块。\r\n" + 
				"1、基本信息管理模块有信息录入、修改、删除功能，用鼠标点击按钮即可进行相应操作，\r\n输入非法字符会弹出信息框提示。\r\n" + 
				"2、查询管理模块有查询（可选择两个条件查询）和浏览信息功能，用鼠标点击按钮即可进\r\n行相应操作，输入非法字符会弹出信息框提示。\r\n" + 
				"3、数据报表模块有浏览信息和下载信息到excel表功能，用鼠标点击按钮即可进行相应操\r\n作，弹出信息框提示下载成功（默认下载目录D：//）。\r\n" + 
				"4、系统管理模块有添加用户，修改用户信息，删除用户，修改管理员密码和退出系统功能\r\n，用鼠标点击按钮即可进行相应操作，输入非法字符会弹出信息框提示。\r\n" + 
				"5、帮助模块有关于系统和使用说明功能，帮助用户更好使用本系统，点击“了解更多”会进\r\n入网页（海贼王网页。。。）。\r\n" + 
				"");
		textArea.setBounds(10, 10, 538, 225);
		frame.getContentPane().add(textArea);
	}
}
