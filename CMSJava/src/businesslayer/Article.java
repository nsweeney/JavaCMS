package businesslayer;

import java.util.List;

import datalayer.ArticleStorage;
import frontendlayer.EditGUI;
import frontendlayer.ViewGUI;

/**
 * Used to store articles and query articles in the database.
 */
public class Article {
	/**
	 * Articles contents.
	 */
	private String contents;

	/**
	 * Article constructor.
	 * 
	 * @param contents
	 *            -this is the article
	 */
	public Article(String contents) {
		setContents(contents);
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	/**
	 * Adds an article in the database.
	 */
	public void addToDatabase() {
		ArticleStorage.addArticleToDatabase(this);
	}

	/**
	 * Used to display articles in the ViewGUI.
	 */
	public static void showArticlesFromDB() {
		List<String> articles = ArticleStorage.getArticles();
		for (String content : articles) {
			ViewGUI.getEditViewTextArea().append(content + "\n");
		}

	}

	/**
	 * Used to populate the EditGUI combobox with all the article id numbers.
	 */
	public static void populateEditGUIComboBox() {
		// find article numbers
		List<Integer> articleList = ArticleStorage.findArticleNumber();

		EditGUI.getArticleNumberComboBox().removeAllItems();
		EditGUI.getArticleNumberComboBox().validate();

		for (Integer articleNumber : articleList) {
			EditGUI.getArticleNumberComboBox().addItem(articleNumber);
		}
	}

	/**
	 * Used to search for a specific article by it's article if number.
	 * 
	 * @param articleNumber
	 *            -the article you want to search for.
	 * @return String -represent the articles contents.
	 */
	public static String findArticleContents(int articleNumber) {

		String articleContents = ArticleStorage
				.findArticleToEdit(articleNumber);
		return articleContents;
	}

	/**
	 * Updates the selected article in the database.
	 * 
	 * @param articleSelectedInComboBox
	 *            -the articles article id number you want to update.
	 * @param updatedArticleContent
	 *            -the new content you want to be added to the article.
	 */
	public static void updateArticleInDatabase(
			Integer articleSelectedInComboBox, String updatedArticleContent) {
		ArticleStorage.updateArticle(articleSelectedInComboBox,
				updatedArticleContent);
	}

	/**
	 * Deletes an article in the database.
	 * 
	 * @param articleSelectedInComboBox
	 *            -article id number of the article you want to delete.
	 */
	public static void deleteArticleInDatabase(Integer articleSelectedInComboBox) {
		ArticleStorage.deleteArticle(articleSelectedInComboBox);
	}
	
	/**
	 * Display information about an Article object.
	 */
	@Override
	public String toString() {
		return "Article object contents: " + getContents();
	}

}
