package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ����ϵͳ {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					����ϵͳ window = new ����ϵͳ();
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
	public ����ϵͳ() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("����ϵͳ");
		frame.setBounds(100, 100, 450, 236);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				������.run();
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(240, 163, 93, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton button = new JButton("\u4E86\u89E3\u66F4\u591A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					//�жϵ�ǰϵͳ�Ƿ�֧��Java AWT Desktop��չ
					if(java.awt.Desktop.isDesktopSupported()){
					try {
					//����һ��URIʵ��
					java.net.URI uri = java.net.URI.create("http://www.iqiyi.com/a_19rrhb3xvl.html?vfm=2008_aldbd");
					//��ȡ��ǰϵͳ������չ
					java.awt.Desktop dp = java.awt.Desktop.getDesktop();
					//�ж�ϵͳ�����Ƿ�֧��Ҫִ�еĹ���
					if(dp.isSupported(java.awt.Desktop.Action.BROWSE)){
					//��ȡϵͳĬ�������������
					dp.browse(uri);
					}
					} catch (java.io.IOException e1) {
					//��Ϊ�޷���ȡϵͳĬ�������
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
