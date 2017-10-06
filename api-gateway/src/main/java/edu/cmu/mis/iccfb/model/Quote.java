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
public class Quote {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Long id;

    private Long authorId;

    private String text;

    private String source;


    // @ManyToOne(fetch=FetchType.EAGER)
    // @JoinColumn(name="authorId")
    //@JsonManagedReference

    public Quote() {}

    public Quote(String text, String source,Long authorId,Long id) {
        this.authorId = authorId;
        this.text = text;
        this.source = source;
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return String.format("Quote[id=%d, text='%s', source='%s']", this.authorId, this.text,this.source);
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
    public Long getAuthorId() {
        return authorId;
    }

}
