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

public class 使用说明2 {

	private JFrame frame;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					使用说明2 window = new 使用说明2();
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
	public 使用说明2() {
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
				副主界面.run();
				frame.setVisible(false);
			}
		});
		button_1.setBounds(307, 250, 93, 23);
		frame.getContentPane().add(button_1);
		
		textArea = new JTextArea();
		textArea.setText("\u672C\u7CFB\u7EDF\u5171\u67094\u5927\u529F\u80FD\u6A21\u5757\u3002\r\n1\u3001\u57FA\u672C\u4FE1\u606F\u7BA1\u7406\u6A21\u5757\u6709\u4E2A\u4EBA\u4FE1\u606F\u67E5\u8BE2\u548C\u4FEE\u6539\u529F\u80FD\uFF0C\u7528\u9F20\u6807\u70B9\u51FB\u6309\u94AE\u5373\u53EF\u8FDB\u884C\u76F8\u5E94\u64CD\u4F5C\uFF0C\r\n\u8F93\u5165\u975E\u6CD5\u5B57\u7B26\u4F1A\u5F39\u51FA\u4FE1\u606F\u6846\u63D0\u793A\u3002\r\n2\u3001\u8D2D\u4E70\u548C\u67E5\u8BE2\u7BA1\u7406\u6A21\u5757\u6709\u8D2D\u4E70\u836F\u54C1\uFF0C\u67E5\u8BE2\uFF08\u53EF\u9009\u62E9\u4E24\u4E2A\u6761\u4EF6\u67E5\u8BE2\uFF09\u6D4F\u89C8\u4FE1\u606F\u548C\u5220\u9664\u5DF2\u8D2D\u836F\u54C1\u529F\u80FD\uFF0C\u7528\u9F20\u6807\u70B9\u51FB\u6309\u94AE\u5373\u53EF\u8FDB\u884C\u76F8\u5E94\u64CD\u4F5C\uFF0C\u8F93\u5165\u975E\u6CD5\u5B57\u7B26\u4F1A\u5F39\u51FA\u4FE1\u606F\u6846\u63D0\u793A\u3002\r\n3\u3001\u7CFB\u7EDF\u7BA1\u7406\u6A21\u5757\u6709\uFF0C\u4FEE\u6539\u5BC6\u7801\uFF0C\u6CE8\u9500\u7CFB\u7EDF\u548C\u9000\u51FA\u7CFB\u7EDF\u529F\u80FD\uFF0C\u7528\u9F20\u6807\u70B9\u51FB\u6309\u94AE\u5373\u53EF\u8FDB\u884C\u76F8\u5E94\u64CD\u4F5C\uFF0C\u8F93\u5165\u975E\u6CD5\u5B57\u7B26\u4F1A\u5F39\u51FA\u4FE1\u606F\u6846\u63D0\u793A\u3002\r\n4\u3001\u5E2E\u52A9\u6A21\u5757\u6709\u5173\u4E8E\u7CFB\u7EDF\u548C\u4F7F\u7528\u8BF4\u660E\u529F\u80FD\uFF0C\u5E2E\u52A9\u7528\u6237\u66F4\u597D\u4F7F\u7528\u672C\u7CFB\u7EDF\uFF0C\u70B9\u51FB\u201C\u4E86\u89E3\u66F4\u591A\u201D\u4F1A\u8FDB\r\n\u5165\u7F51\u9875\uFF08\u6D77\u8D3C\u738B\u7F51\u9875\u3002\u3002\u3002\uFF09\u3002\r\n");
		textArea.setBounds(10, 10, 538, 225);
		frame.getContentPane().add(textArea);
	}
}
