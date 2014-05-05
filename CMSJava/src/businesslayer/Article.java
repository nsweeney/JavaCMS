package businesslayer;

import java.util.List;

import datalayer.ArticleStorage;
import frontendlayer.ViewGUI;

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
		int key = 1;
		List<String> articles = ArticleStorage.getArticles();
		for(String content : articles){
			ViewGUI.getEditViewTextArea().append("Article: " + key + "\n");
			ViewGUI.getEditViewTextArea().append(content);
			ViewGUI.getEditViewTextArea().append("\n");
			key++;
		}
		
	}

	@Override
	public String toString() {
		return "Article object contents: " + getContents();
	}	

}
