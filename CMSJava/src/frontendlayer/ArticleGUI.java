package frontendlayer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class ArticleGUI {

	private JFrame frmArticleCms;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ArticleGUI window = new ArticleGUI();
					window.frmArticleCms.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ArticleGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmArticleCms = new JFrame();
		frmArticleCms.setTitle("Article CMS");
		frmArticleCms.setBounds(100, 100, 220, 165);
		frmArticleCms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmArticleCms.getContentPane().setLayout(null);
		
		JLabel lblArticleCms = new JLabel("Article CMS");
		lblArticleCms.setBounds(67, 11, 80, 14);
		frmArticleCms.getContentPane().add(lblArticleCms);
		
		JButton btnCreateArticle = new JButton("Create");
		btnCreateArticle.setBounds(10, 59, 184, 23);
		frmArticleCms.getContentPane().add(btnCreateArticle);
		
		JButton buttonView = new JButton("View / Edit");
		buttonView.setBounds(10, 93, 184, 23);
		frmArticleCms.getContentPane().add(buttonView);
	}
}
