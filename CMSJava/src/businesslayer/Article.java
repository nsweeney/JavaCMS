package businesslayer;

import java.util.List;

import datalayer.ArticleStorage;
import frontendlayer.ViewEditGUI;

public class Article {
	private String contents;
	
	public Article(String contents){
		setContents(contents);
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}
	
	public void addToDatabase(){
		ArticleStorage.addArticleToDatabase(this);
	}
	
	public static void showArticlesFromDB(){
		List<String> articles = ArticleStorage.getArticles();
		for(String content : articles){
			ViewEditGUI.getEditViewTextArea().append(content);
			System.out.println("\n");
		}
		
	}

	@Override
	public String toString() {
		return "Article object contents: " + getContents();
	}	

}
