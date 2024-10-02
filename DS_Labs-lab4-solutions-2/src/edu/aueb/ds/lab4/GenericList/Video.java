package edu.aueb.ds.lab4.GenericList;

public class Video {
    private String link;
    private String title;
    private int views;

    public Video(String title, String link, int views) {
        this.link = link;
        this.title = title;
        this.views = views;
    }

    public int getViews() {
        return views;
    }

    public String getTitle() {
        return title;
    }

    public String getLink() {
        return link;
    }

    @Override
    public String toString() {
        return "\n " + title + " (" + views + ")" + "\n" + link;
    }
}
