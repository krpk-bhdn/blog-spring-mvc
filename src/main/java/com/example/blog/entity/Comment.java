package com.example.blog.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Set;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    @Column(length = 5000)
    private String text;

    private LocalDateTime publicationDate;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "comment_id")
    private Set<SubComment> subComments;

    public Comment() {
    }

    public Comment(User author, String text) {
        this.author = author;
        this.text = text;
    }

    public String formattedPublicationDate(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy, hh:mm a");
        String dateTime = publicationDate.format(formatter);
        return dateTime;
    }

    public Long getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDateTime getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(LocalDateTime publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Set<SubComment> getSubComments() {
        return subComments;
    }

    public void setSubComments(Set<SubComment> subComments) {
        this.subComments = subComments;
    }
}
