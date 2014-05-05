package frontendlayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import businesslayer.Article;

/**
 * Used to let user edit and delete article in the database.
 */
public class EditGUI extends JDialog {

	/**
	 * Used to display info for the EditGUI
	 */
	private final JPanel contentPanel = new JPanel();
	/**
	 * Used to display the Article ID of each article in the database.
	 */
	private static JComboBox<Integer> articleNumberComboBox;
	/**
	 * Displays the content of the selected article.
	 */
	private JTextArea articleEditTextArea;
	/**
	 * The index position of the selected article.
	 */
	private static Integer articleSelectedInComboBox;

	public static JComboBox<Integer> getArticleNumberComboBox() {
		return articleNumberComboBox;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			EditGUI dialog = new EditGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			Article.populateEditGUIComboBox();
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public EditGUI() {
		setTitle("Edit  / Delete Articles");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblSelectArticleTo = new JLabel("Article Number:");
		lblSelectArticleTo.setBounds(10, 11, 141, 14);
		contentPanel.add(lblSelectArticleTo);

		articleNumberComboBox = new JComboBox<Integer>();
		articleNumberComboBox.setBounds(161, 8, 263, 20);
		contentPanel.add(articleNumberComboBox);

		articleEditTextArea = new JTextArea();
		articleEditTextArea.setBounds(10, 73, 414, 145);
		contentPanel.add(articleEditTextArea);

		// ***Edit button
		JButton btnEditButton = new JButton("Edit");
		btnEditButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				articleSelectedInComboBox = (Integer) articleNumberComboBox
						.getSelectedItem();
				String articleContents = Article
						.findArticleContents(articleSelectedInComboBox);
				articleEditTextArea.setText(articleContents);
			}
		});
		btnEditButton.setBounds(161, 39, 263, 23);
		contentPanel.add(btnEditButton);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				// ***Update button
				JButton updateButton = new JButton("Update");
				updateButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						articleSelectedInComboBox = (Integer) articleNumberComboBox
								.getSelectedItem();
						Article.updateArticleInDatabase(
								articleSelectedInComboBox,
								articleEditTextArea.getText());
						JOptionPane.showMessageDialog(
								ArticleGUI.getEditDialog(), "Article updated!",
								"Edit / Delete article information",
								JOptionPane.INFORMATION_MESSAGE);
					}
				});
				updateButton.setActionCommand("Update");
				buttonPane.add(updateButton);
				getRootPane().setDefaultButton(updateButton);
			}
			{
				// ***Close button
				JButton cancelButton = new JButton("Close");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ArticleGUI.getEditDialog().dispose();
					}
				});

				// ***Delete button
				JButton btnNewButton = new JButton("Delete");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						articleSelectedInComboBox = (Integer) articleNumberComboBox
								.getSelectedItem();
						Article.deleteArticleInDatabase(articleSelectedInComboBox);
						// now repopulate combobox since one item will be
						// deleted
						Article.populateEditGUIComboBox();
						// clear text area
						articleEditTextArea.setText("");
						JOptionPane.showMessageDialog(
								ArticleGUI.getEditDialog(), "Article deleted!",
								"Edit / Delete article information",
								JOptionPane.INFORMATION_MESSAGE);
					}
				});
				buttonPane.add(btnNewButton);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
