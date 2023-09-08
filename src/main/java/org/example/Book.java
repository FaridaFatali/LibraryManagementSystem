package org.example;

public class Book {
    private String id;
    private String title;
    private String author;
    private String publishYear;
    private String status;

    public Book(String id, String author, String title, String publishYear, String status) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.publishYear = publishYear;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "id - " + id +
                ", author - " + author +
                ", title - " + '"' + title + '"' +
                ", publishYear - " + publishYear +
                ", status - " + status +
                "\n--------------------------------------------------------------";
    }
}
