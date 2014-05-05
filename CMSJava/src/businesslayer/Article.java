package businesslayer;

import java.util.List;

import datalayer.ArticleStorage;
import frontendlayer.EditGUI;
import frontendlayer.ViewGUI;

public class Article {
	private String contents;

	public Article(String contents) {
		setContents(contents);
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public void addToDatabase() {
		ArticleStorage.addArticleToDatabase(this);
	}

	public static void showArticlesFromDB() {
		int key = 1;
		List<String> articles = ArticleStorage.getArticles();
		for (String content : articles) {
			ViewGUI.getEditViewTextArea().append("Article: " + key + "\n");
			ViewGUI.getEditViewTextArea().append(content);
			ViewGUI.getEditViewTextArea().append("\n");
			key++;
		}

	}

	public static void populateEditGUIComboBox() {
		// find article numbers
		List<Integer> articleList = ArticleStorage.findArticleNumber();

		EditGUI.getArticleNumberComboBox().removeAllItems();
		EditGUI.getArticleNumberComboBox().validate();

		for (Integer articleNumber : articleList) {
			EditGUI.getArticleNumberComboBox().addItem(articleNumber);
		}
	}

	public static String populateEditGUITextBoxWithContents(int articleNumber) {
		
		String articleContents = ArticleStorage.findArticleToEdit(articleNumber);
		return articleContents;	
	}

	@Override
	public String toString() {
		return "Article object contents: " + getContents();
	}

}
