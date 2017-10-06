package edu.cmu.mis.iccfb;

import java.sql.SQLException;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import edu.cmu.mis.iccfb.model.Quote;
import edu.cmu.mis.iccfb.service.QuoteService;

@Configuration
public class SeedData {

    @Autowired
    private QuoteService quoteService;

    private static final Logger log = LoggerFactory.getLogger(SeedData.class);

    @Bean
    public SeedData getBean() throws SQLException {

        Quote q1 = new Quote(
                "The world is a thing of utter inordinate complexity and richness " +
                "and strangeness that is absolutely awesome",
                "https://en.wikiquote.org/wiki/Douglas_Adams",
                1L,1L);

        Quote q2 = new Quote(
                "As rain breaks through an ill-thatched house, passion will break through an unreflecting mind.",
                "https://en.wikiquote.org/wiki/Gautama_Buddha",
                2L,2L);

        Quote q3 = new Quote(
                "I think that only daring speculation can lead us further and not accumulation of facts.",
                "https://en.wikiquote.org/wiki/Albert_Einstein",
                3L,3L);

        Quote q4 = new Quote(
        		"Imagination is more important than knowledge.",
        		"https://www.goalcast.com/2017/03/29/top-30-most-inspiring-albert-einstein-quotes/",
        		3L,4L);

        quoteService.save(q1);
        quoteService.save(q2);
        quoteService.save(q3);
        quoteService.save(q4);

        return new SeedData();
    }
}
