package frontendlayer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import businesslayer.Article;

/**
 * Used to let a user save articles in the database.
 */
public class CreateGUI extends JDialog {

	/**
	 * Used to display info for the CreateGUI.
	 */
	private final JPanel contentPanel = new JPanel();
	/**
	 * Area used by user to enter an article.
	 */
	private JTextArea textArea;
	/**
	 * Used to create a scrolling text area.
	 */
	private JScrollPane scrollPane;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			CreateGUI dialog = new CreateGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public CreateGUI() {
		setTitle("Create Articles");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter Article");
		lblNewLabel.setBounds(10, 11, 74, 14);
		contentPanel.add(lblNewLabel);
		
		// Create scroll-able JTextArea
		textArea = new JTextArea();
		textArea.setBounds(10, 36, 414, 182);
		scrollPane = new JScrollPane(textArea);
		scrollPane.setBounds(10, 36, 414, 182);
		contentPanel.add(scrollPane);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				// ***Add button
				JButton addArticleBtn = new JButton("Add");
				addArticleBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Article article = new Article(textArea.getText());
						article.addToDatabase();
						JOptionPane.showMessageDialog(
								ArticleGUI.getCreateDialog(), "Article saved!",
								"Add article information",
								JOptionPane.INFORMATION_MESSAGE);
					}
				});
				addArticleBtn.setMinimumSize(new Dimension(65, 23));
				addArticleBtn.setMaximumSize(new Dimension(65, 23));
				addArticleBtn.setActionCommand("Add");
				buttonPane.add(addArticleBtn);
				getRootPane().setDefaultButton(addArticleBtn);
			}
			{
				// ***Close button
				JButton cancelButton = new JButton("Close");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ArticleGUI.getCreateDialog().dispose();
					}
				});
				cancelButton.setActionCommand("Close");
				buttonPane.add(cancelButton);
			}
		}
	}
}
