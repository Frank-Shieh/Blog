package com.blog.core.Bean;



import javax.persistence.*;

@Entity
@Table(name = "news")
public class NBANews {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false)
    private int id;
    @Column(name = "title")
    private String title;
    @Column(name = "source")
    private String source;
    @Column(name = "link")
    private String link;

    public NBANews(){

    }
    public NBANews(String title, String source, String link){
        this.title=title;
        this.source=source;
        this.link = link;
    }
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getSource() {
        return source;
    }

    public String getLink() {
        return link;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setLink(String link) {
        this.link = link;
    }

    @Override
    public String toString() {
        return "NBANews{" +
                "title='" + title + '\'' +
                ", source='" + source + '\'' +
                ", link='" + link + '\'' +
                '}';
    }
}
