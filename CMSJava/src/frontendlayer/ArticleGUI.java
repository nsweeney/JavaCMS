package frontendlayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ArticleGUI {

	private JFrame frmArticleCms;
	private static ViewEditGUI viewEditDialog;
	private static CreateGUI createDialog;

	public static ViewEditGUI getViewEditDialog() {
		return viewEditDialog;
	}

	public static CreateGUI getCreateDialog() {
		return createDialog;
	}

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
		frmArticleCms.setBounds(100, 100, 220, 220);
		frmArticleCms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmArticleCms.getContentPane().setLayout(null);
		
		JLabel lblArticleCms = new JLabel("Article CMS");
		lblArticleCms.setBounds(67, 11, 80, 14);
		frmArticleCms.getContentPane().add(lblArticleCms);
		
		JButton btnCreateArticle = new JButton("Create");
		btnCreateArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Open the CreateGUI dialog
				try {
					createDialog = new CreateGUI();
					createDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					createDialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnCreateArticle.setBounds(10, 59, 184, 23);
		frmArticleCms.getContentPane().add(btnCreateArticle);
		
		JButton buttonView = new JButton("View / Edit");
		buttonView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// Open the ViewEditGUI dialog
					viewEditDialog = new ViewEditGUI();
					viewEditDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					viewEditDialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		buttonView.setBounds(10, 93, 184, 23);
		frmArticleCms.getContentPane().add(buttonView);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//closes the app
				System.exit(-1);
			}
		});
		btnClose.setBounds(105, 148, 89, 23);
		frmArticleCms.getContentPane().add(btnClose);
	}
}
