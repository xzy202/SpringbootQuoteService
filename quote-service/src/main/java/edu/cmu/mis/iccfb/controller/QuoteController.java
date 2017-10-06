package edu.cmu.mis.iccfb.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import edu.cmu.mis.iccfb.model.Quote;
import edu.cmu.mis.iccfb.service.QuoteService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import java.util.*;


@RestController
public class QuoteController {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    private QuoteService quoteService;

    @RequestMapping("/quote/randomquote")
    public Quote random() {
        return quoteService.randomQuote();
    }

    @RequestMapping(value = "/quotes/{id}")
    public List<Quote> findAuthor(@PathVariable String id) {
        ArrayList<Quote> quotes = new ArrayList<Quote>();
        Long authorId = Long.parseLong(id);
        for (Quote q: this.quoteService.findAll() ) {
              if ( q.getAuthorId() == authorId)
                 quotes.add(q);
        }
    //    System.out.println(quotes);
        return quotes;
    }

    @RequestMapping( value = "/addquote", method = RequestMethod.POST,headers = "Accept=application/json")
    public void addquote(@RequestBody Quote quote) {
      String text = quote.getText();
      String source = quote.getSource();
      Long authorId = quote.getAuthorId();
      Quote new_quote = new Quote(text,source,authorId,counter.incrementAndGet()+3);
      quoteService.save(new_quote);

    }


}
