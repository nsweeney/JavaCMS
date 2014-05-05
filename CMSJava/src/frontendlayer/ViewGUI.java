package frontendlayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import businesslayer.Article;

/**
 * Used to display all of the article in the database.
 */
public class ViewGUI extends JDialog {

	/**
	 * Main panel used to display info for our ViewGUI.
	 */
	private final JPanel contentPanel = new JPanel();
	/**
	 * Are that displays contents of an article.
	 */
	private static JTextArea viewTextArea;
	/**
	 * Used to create a scrolling text area.
	 */
	private JScrollPane scrollPane;

	public static JTextArea getEditViewTextArea() {
		return viewTextArea;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewGUI dialog = new ViewGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewGUI() {
		setTitle("View Articles");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{

			// Create scroll-able JTextArea
			viewTextArea = new JTextArea();
			viewTextArea.setBounds(10, 11, 414, 207);
			scrollPane = new JScrollPane(viewTextArea);
			scrollPane.setBounds(10, 11, 414, 207);
			contentPanel.add(scrollPane);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				// ***Show button
				JButton showButton = new JButton("Show");
				showButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						viewTextArea.setText("");
						Article.showArticlesFromDB();

					}
				});
				showButton.setActionCommand("Show");
				buttonPane.add(showButton);
				getRootPane().setDefaultButton(showButton);
			}
			{
				// //***Close button
				JButton cancelButton = new JButton("Close");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ArticleGUI.getViewEditDialog().dispose();
					}
				});
				cancelButton.setActionCommand("Close");
				buttonPane.add(cancelButton);
			}
		}
	}

}
