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

public class ʹ��˵�� {

	private JFrame frame;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					ʹ��˵�� window = new ʹ��˵��();
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
	public ʹ��˵��() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("ʹ��˵��");
		frame.setBounds(100, 100, 574, 326);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
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
		button.setBounds(104, 250, 93, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				������.run();
				frame.setVisible(false);
			}
		});
		button_1.setBounds(307, 250, 93, 23);
		frame.getContentPane().add(button_1);
		
		textArea = new JTextArea();
		textArea.setText("��ϵͳ����5����ģ�顣\r\n" + 
				"1��������Ϣ����ģ������Ϣ¼�롢�޸ġ�ɾ�����ܣ����������ť���ɽ�����Ӧ������\r\n����Ƿ��ַ��ᵯ����Ϣ����ʾ��\r\n" + 
				"2����ѯ����ģ���в�ѯ����ѡ������������ѯ���������Ϣ���ܣ����������ť���ɽ�\r\n����Ӧ����������Ƿ��ַ��ᵯ����Ϣ����ʾ��\r\n" + 
				"3�����ݱ���ģ���������Ϣ��������Ϣ��excel���ܣ����������ť���ɽ�����Ӧ��\r\n����������Ϣ����ʾ���سɹ���Ĭ������Ŀ¼D��//����\r\n" + 
				"4��ϵͳ����ģ��������û����޸��û���Ϣ��ɾ���û����޸Ĺ���Ա������˳�ϵͳ����\r\n�����������ť���ɽ�����Ӧ����������Ƿ��ַ��ᵯ����Ϣ����ʾ��\r\n" + 
				"5������ģ���й���ϵͳ��ʹ��˵�����ܣ������û�����ʹ�ñ�ϵͳ��������˽���ࡱ���\r\n����ҳ����������ҳ����������\r\n" + 
				"");
		textArea.setBounds(10, 10, 538, 225);
		frame.getContentPane().add(textArea);
	}
}
