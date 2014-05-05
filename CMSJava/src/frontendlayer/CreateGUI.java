package frontendlayer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import businesslayer.Article;

public class CreateGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	JTextArea textArea;

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
		
		textArea = new JTextArea();
		textArea.setBounds(10, 36, 414, 182);
		contentPanel.add(textArea);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton addArticleBtn = new JButton("Add");
				addArticleBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Article article = new Article(textArea.getText());
						article.addToDatabase();
					}
				});
				addArticleBtn.setMinimumSize(new Dimension(65, 23));
				addArticleBtn.setMaximumSize(new Dimension(65, 23));
				addArticleBtn.setActionCommand("OK");
				buttonPane.add(addArticleBtn);
				getRootPane().setDefaultButton(addArticleBtn);
			}
			{
				JButton cancelButton = new JButton("Close");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ArticleGUI.getCreateDialog().dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
