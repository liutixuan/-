package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class 关于系统 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					关于系统 window = new 关于系统();
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
	public 关于系统() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("关于系统");
		frame.setBounds(100, 100, 450, 236);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				主界面.run();
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(240, 163, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
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
		button.setBounds(67, 163, 93, 23);
		frame.getContentPane().add(button);
		
		JTextArea txtrjavasqlServer = new JTextArea();
		txtrjavasqlServer.setText("\u6B64\u533B\u836F\u7CFB\u7EDF\u4E3A\u6570\u636E\u5E93\u5F00\u53D1\u8BFE\u7A0B\u4F5C\u4E1A\u3002\r\n\u91C7\u7528java\u548Csql server\u7F16\u5199\u3002");
		txtrjavasqlServer.setBounds(10, 10, 414, 132);
		frame.getContentPane().add(txtrjavasqlServer);
	}
}
