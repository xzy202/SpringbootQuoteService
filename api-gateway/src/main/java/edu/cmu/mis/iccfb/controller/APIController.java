package edu.cmu.mis.iccfb.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.*;

import org.springframework.http.HttpMethod;

import java.util.*;

import edu.cmu.mis.iccfb.model.Author;
import edu.cmu.mis.iccfb.model.Quote;
import edu.cmu.mis.iccfb.model.QuoteFormat;
import edu.cmu.mis.iccfb.model.AuthorFormat;

@RestController
public class APIController {

   @Value("${Quote_URL}")

    String quoteurl;
   
   @Value("${Author_URL}")

   String authorurl; 
    // @RequestMapping("/api/quote/randomquote")
    // public Quote random() {
    //     return quoteService.randomQuote();
    // }

    @RequestMapping("/api/quote/randomquote")
    public QuoteFormat random() {
      RestTemplate restTemplate = new RestTemplate();
      String fooResourceUrl = quoteurl+"/quote/randomquote";

      // ResponseEntity<String> response = restTemplate.getForEntity(fooResourceUrl, String.class);
      // System.out.println(response.getStatusCode());
      // String body = response.getBody();

      Quote response = restTemplate.getForObject(fooResourceUrl, Quote.class);
    //  System.out.println(response);

      String text = response.getText();
      String source = response.getSource();
      Long authorId = response.getAuthorId();

      RestTemplate Template = new RestTemplate();
      String Url = authorurl+ "/author/" + Long.toString(authorId) ;
      Author author = Template.getForObject(Url, Author.class);
      //System.out.println(author);
      Long id = author.getId();
      String name = author.getName();

      AuthorFormat new_author = new AuthorFormat(name);
      new_author.setId(id);
      QuoteFormat quote = new QuoteFormat(text,source,new_author);
      //System.out.println(quote);
      return quote;
    }


    @RequestMapping( value = "/api/quotes/{id}" , method = RequestMethod.GET)
    public AuthorFormat quotes(@PathVariable String id) {
    	long ID = Long.parseLong(id);

      RestTemplate Template = new RestTemplate();
      String Url = authorurl+"/author/" + Long.toString(ID) ;

      Author a = Template.getForObject(Url, Author.class);
      String name = a.getName();
      Long authorId = a.getId();

      AuthorFormat author = new AuthorFormat(name);
      //System.out.println(author);

      RestTemplate restTemplate = new RestTemplate();
      String fooResourceUrl = quoteurl+"/quotes/" + id;

      Quote[] response = restTemplate.getForObject(fooResourceUrl, Quote[].class);
      ArrayList<Quote> quotes = new ArrayList<Quote>();
      for (Quote q: response) {
               quotes.add(q);
      }
      author.setQuotes(quotes);

    //  System.out.println(quotes);

      return author;
    }

    @RequestMapping(value = "/api/quote", method = RequestMethod.POST)
    public void saveQuote(@RequestBody QuoteFormat quote) {

        String name = quote.getAuthor().getName();
        String text = quote.getText();
        String source = quote.getSource();

        // send to author service
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = authorurl+"/authorname/" + name;
        Author response = restTemplate.getForObject(fooResourceUrl, Author.class);

        Quote new_quote = new Quote(text,source,response.getId(),1L);

        //System.out.println("breank here");

        // send to quote service

        RestTemplate Template = new RestTemplate();

      //  System.out.println("ka le");
        String Url = quoteurl+ "/addquote";
        HttpEntity<Quote> request = new HttpEntity<Quote>(new_quote);
        ResponseEntity<Quote> post_quote = Template.exchange(Url, HttpMethod.POST,request, Quote.class);
        System.out.println(".....Saving quote");
        // quoteService.save(quote);
    }


}
