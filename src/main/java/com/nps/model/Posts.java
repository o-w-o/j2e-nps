package com.nps.model;

public class Posts {
    
			private int id;
			private String categories;
			private String title;
			private String summary;
			private String content;
			private String keywords;
			private String postime;
			private String author;
			
			public int getId() {
				return id;
			}
			public String getCategories() {
				return categories;
			}
			public void setCategories(String categories) {
				this.categories = categories;
			}
			public String getSummary() {
				return summary;
			}
			public void setSummary(String summary) {
				this.summary = summary;
			}
			public String getKeywords() {
				return keywords;
			}
			public void setKeywords(String keywords) {
				this.keywords = keywords;
			}
			public String getPostime() {
				return postime;
			}
			public void setPostime(String postime) {
				this.postime = postime;
			}
			public String getTitle() {
				return title;
			}
			public void setTitle(String title) {
				this.title = title;
			}
			public String getContent() {
				return content;
			}
			public void setContent(String content) {
				this.content = content;
			}
			public String getAuthor() {
				return author;
			}
			public void setAuthor(String author) {
				this.author = author;
			}

}
