package edu.cmu.mis.iccfb.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@jsonid")
public class QuoteFormat {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String text;

    private String source;

    @ManyToOne(fetch=FetchType.EAGER)

    private AuthorFormat author;

    public QuoteFormat() {}

    public QuoteFormat(String text, String source, AuthorFormat author) {
        this.text = text;
        this.source = source;
        this.author = author;
    }

    @Override
    public String toString() {
        return String.format("Quote[id=%d, text='%s' by = '%s' ", this.id, this.text, this.author.getName());
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Long getId() {
        return id;
    }
    public AuthorFormat getAuthor() {
        return author;
    }
    public void setAuthor(AuthorFormat author) {
        this.author = author;
    }

}
