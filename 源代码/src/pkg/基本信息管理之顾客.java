package pkg;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ������Ϣ����֮�˿� {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {*/
			public static void run() {
				try {
					������Ϣ����֮�˿� window = new ������Ϣ����֮�˿�();
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
	public ������Ϣ����֮�˿�() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("�˿���Ϣ����");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("\u987E\u5BA2\u4FE1\u606F\u5F55\u5165");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				�˿���Ϣ¼��.run();
				frame.setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("����", Font.PLAIN, 16));
		btnNewButton.setBounds(121, 35, 188, 37);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u987E\u5BA2\u4FE1\u606F\u4FEE\u6539\u548C\u5220\u9664");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				�˿���Ϣ�޸ĺ�ɾ��.run();
				frame.setVisible(false);
			}
		});
		btnNewButton_1.setFont(new Font("����", Font.PLAIN, 16));
		btnNewButton_1.setBounds(121, 108, 188, 37);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				������.run();
				frame.setVisible(false);
			}
		});
		button.setFont(new Font("����", Font.PLAIN, 16));
		button.setBounds(121, 181, 188, 37);
		frame.getContentPane().add(button);
	}

}
