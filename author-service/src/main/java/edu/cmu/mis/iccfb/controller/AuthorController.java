package edu.cmu.mis.iccfb.controller;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

import edu.cmu.mis.iccfb.model.Author;
import edu.cmu.mis.iccfb.service.AuthorService;

@RestController
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping( value = "/author/{id}")
    public Author findAuthor(@PathVariable String id) {
        Long ID = Long.parseLong(id);
        Author author = authorService.findOne(ID);
        return author;
    }

    @RequestMapping( value = "/authorname/{name}")
    public Author addAuthor(@PathVariable String name){
      Author a = authorService.findByName(name);
      if (a == null) {
           System.out.println("Saving author");
           Author new_author = new Author(counter.incrementAndGet()+3,name);
           authorService.save(new_author);
           return new_author;
       }

    return a;
    }

}
