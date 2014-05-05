package frontendlayer;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import businesslayer.Article;

public class ArticleGUI {

	private JFrame frmArticleCms;
	private static ViewGUI viewDialog;
	private static CreateGUI createDialog;
	private static EditGUI editDialog;

	public static ViewGUI getViewEditDialog() {
		return viewDialog;
	}

	public static CreateGUI getCreateDialog() {
		return createDialog;
	}

	public static EditGUI getEditDialog() {
		return editDialog;
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
		frmArticleCms.setBounds(100, 100, 220, 280);
		frmArticleCms.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmArticleCms.getContentPane().setLayout(null);

		JLabel lblArticleCms = new JLabel("Article CMS");
		lblArticleCms.setBounds(67, 11, 80, 14);
		frmArticleCms.getContentPane().add(lblArticleCms);

		JButton btnCreateArticle = new JButton("Create");
		btnCreateArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Open the CreateGUI dialog
				try {
					createDialog = new CreateGUI();
					createDialog
							.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					createDialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnCreateArticle.setBounds(10, 59, 184, 23);
		frmArticleCms.getContentPane().add(btnCreateArticle);

		JButton buttonViewArticle = new JButton("View");
		buttonViewArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					// Open the ViewEditGUI dialog
					viewDialog = new ViewGUI();
					viewDialog
							.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					viewDialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		buttonViewArticle.setBounds(10, 93, 184, 23);
		frmArticleCms.getContentPane().add(buttonViewArticle);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// closes the app
				System.exit(-1);
			}
		});
		btnClose.setBounds(105, 208, 89, 23);
		frmArticleCms.getContentPane().add(btnClose);

		JButton buttonEditArticle = new JButton("Edit");
		buttonEditArticle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					editDialog = new EditGUI();
					Article.populateEditGUIComboBox();
					editDialog
							.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					editDialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		buttonEditArticle.setBounds(10, 127, 184, 23);
		frmArticleCms.getContentPane().add(buttonEditArticle);

		JButton buttonDeleteArticle = new JButton("Delete");
		buttonDeleteArticle.setBounds(10, 161, 184, 23);
		frmArticleCms.getContentPane().add(buttonDeleteArticle);
	}
}
