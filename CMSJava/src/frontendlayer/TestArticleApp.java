package frontendlayer;

import datalayer.ArticleStorage;
import businesslayer.Article;

public class TestArticleApp {

	public static void main(String[] args) {
		//create db tables
		ArticleStorage.createDBTables();
		Article article = new Article("This\nis\na\ntest.");
		//System.out.println(article);
		article.addToDatabase();

	}

}
