package frontendlayer;

import java.util.List;

import businesslayer.Article;
import datalayer.ArticleStorage;

public class TestArticleApp {

	public static void main(String[] args) {
		//create db tables
		//ArticleStorage.createDBTables();
		
		Article article = new Article("This\nis\na\ntest.");
		//System.out.println(article);
		
		//article.addToDatabase();
		
		List<String> articles = ArticleStorage.getArticles();
		for(String article1 : articles){
			System.out.println(article1);
		}

	}

}
