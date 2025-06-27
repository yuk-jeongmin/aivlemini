package aivlemini.domain;

import aivlemini.LibraryserviceApplication;
import aivlemini.domain.BestsellerRegistered;
import aivlemini.domain.BookRegistered;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Book_table")
@Data
//<<< DDD / Aggregate Root
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String bookName;

    private String category;

    private Boolean isBestSeller;

    private String authorName;

    private String image;

    private Integer subscriptionCount;

    private String bookContent;

    private String pdfPath;

    public static BookRepository repository() {
        BookRepository bookRepository = LibraryserviceApplication.applicationContext.getBean(
            BookRepository.class
        );
        return bookRepository;
    }

    //<<< Clean Arch / Port Method
    public static void registerBook(PublishPrepared publishPrepared) {
        //implement business logic here:

        /** Example 1:  new item 
        Book book = new Book();
        repository().save(book);

        BookRegistered bookRegistered = new BookRegistered(book);
        bookRegistered.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if publishPrepared.gptIdmanuscriptId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<, Object> publishingMap = mapper.convertValue(publishPrepared.getGptId(), Map.class);
        // Map<Long, Object> publishingMap = mapper.convertValue(publishPrepared.getManuscriptId(), Map.class);

        repository().findById(publishPrepared.get???()).ifPresent(book->{
            
            book // do something
            repository().save(book);

            BookRegistered bookRegistered = new BookRegistered(book);
            bookRegistered.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void grantBestseller(BookApply bookApply) {
        //implement business logic here:

        /** Example 1:  new item 
        Book book = new Book();
        repository().save(book);

        BestsellerRegistered bestsellerRegistered = new BestsellerRegistered(book);
        bestsellerRegistered.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if bookApply.userInfoId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Long, Object> applyingMap = mapper.convertValue(bookApply.getUserInfoId(), Map.class);

        repository().findById(bookApply.get???()).ifPresent(book->{
            
            book // do something
            repository().save(book);

            BestsellerRegistered bestsellerRegistered = new BestsellerRegistered(book);
            bestsellerRegistered.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
