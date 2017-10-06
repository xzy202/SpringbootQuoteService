package edu.cmu.mis.iccfb.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@jsonid")
public class AuthorFormat {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Long id;

    private String name;


    @OneToMany(targetEntity=Quote.class,fetch=FetchType.EAGER)
    //@JsonBackReference
    private List<Quote> quotes;

	protected AuthorFormat() {}

    public AuthorFormat(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Author[id=%d, name='%s']", id, this.name);
    }

    public Long getId () {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id){
      this.id = id;
    }

	public List<Quote> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}
}
