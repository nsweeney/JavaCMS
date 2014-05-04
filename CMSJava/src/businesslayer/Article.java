package businesslayer;

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

	@Override
	public String toString() {
		return "Article object contents: " + getContents();
	}	

}
