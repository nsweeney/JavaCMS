package frontendlayer;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import businesslayer.Article;

public class ViewEditGUI extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTextArea editViewTextArea;

	public static JTextArea getEditViewTextArea() {
		return editViewTextArea;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ViewEditGUI dialog = new ViewEditGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ViewEditGUI() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			editViewTextArea = new JTextArea();
			editViewTextArea.setBounds(10, 11, 414, 207);
			contentPanel.add(editViewTextArea);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton showButton = new JButton("Show");
				showButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Article.showArticlesFromDB();
	
					}
				});
				showButton.setActionCommand("OK");
				buttonPane.add(showButton);
				getRootPane().setDefaultButton(showButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ArticleGUI.getViewEditDialog().dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
