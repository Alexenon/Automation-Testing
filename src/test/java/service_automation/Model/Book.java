package service_automation.Model;

import com.google.gson.annotations.SerializedName;

public class Book {

    @SerializedName("isbn")
    private String isbn;
    @SerializedName("title")
    private String title;
    @SerializedName("subTitle")
    private String subTitle;
    @SerializedName("author")
    private String author;
    @SerializedName("publish_date")
    private String publish_date;
    @SerializedName("publishier")
    private String publishier;
    @SerializedName("pages")
    private int pages;
    @SerializedName("description")
    private String description;
    @SerializedName("website")
    private String website;

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubTitle() {
        return subTitle;
    }

    public void setSubTitle(String subTitle) {
        this.subTitle = subTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish_date() {
        return publish_date;
    }

    public void setPublish_date(String publish_date) {
        this.publish_date = publish_date;
    }

    public String getPublishier() {
        return publishier;
    }

    public void setPublishier(String publishier) {
        this.publishier = publishier;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", subTitle='" + subTitle + '\'' +
                ", author='" + author + '\'' +
                ", publish_date='" + publish_date + '\'' +
                ", publishier='" + publishier + '\'' +
                ", pages=" + pages +
                ", description='" + description + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

    public static class Builder{
        private final Book book;

        public Builder() {
            book = new Book();
        }

        public Builder withISBN(String isbn){
            book.setIsbn(isbn);
            return this;
        }

        public Builder withTitle(String title){
            book.setTitle(title);
            return this;
        }

        public Builder withSubTitle(String subTitle){
            book.setSubTitle(subTitle);
            return this;
        }

        public Builder withAuthor(String author){
            book.setAuthor(author);
            return this;
        }

        public Builder withPublishDate(String publishDate){
            book.setPublish_date(publishDate);
            return this;
        }

        public Builder withPublisher(String publisher){
            book.setPublishier(publisher);
            return this;
        }

        public Builder withPages(int pages){
            book.setPages(pages);
            return this;
        }

        public Builder withDescription(String description){
            book.setDescription(description);
            return this;
        }

        public Builder withWebsite(String website){
            book.setWebsite(website);
            return this;
        }

        public Book build(){
            return book;
        }

    }

}
