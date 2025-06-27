package aivlemini.domain;

import aivlemini.ApplyserviceApplication;
import aivlemini.domain.AppliesFailed;
import aivlemini.domain.BookApply;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Applying_table")
@Data
//<<< DDD / Aggregate Root
public class Applying {

    @Id
    private Integer id;

    private String isPurchase;

    private String status;

    @Embedded
    private UserId userId;

    @PostPersist
    public void onPostPersist() {
        BookApply bookApply = new BookApply(this);
        bookApply.publishAfterCommit();

        AppliesFailed appliesFailed = new AppliesFailed(this);
        appliesFailed.publishAfterCommit();
    }

    public static ApplyingRepository repository() {
        ApplyingRepository applyingRepository = ApplyserviceApplication.applicationContext.getBean(
            ApplyingRepository.class
        );
        return applyingRepository;
    }

    //<<< Clean Arch / Port Method
    public static void failApplies(OutOfPoint outOfPoint) {
        //implement business logic here:

        /** Example 1:  new item 
        Applying applying = new Applying();
        repository().save(applying);

        AppliesFailed appliesFailed = new AppliesFailed(applying);
        appliesFailed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        // if outOfPoint.applyingIduserInfoId exists, use it
        
        // ObjectMapper mapper = new ObjectMapper();
        // Map<Integer, Object> pointMap = mapper.convertValue(outOfPoint.getApplyingId(), Map.class);
        // Map<Long, Object> pointMap = mapper.convertValue(outOfPoint.getUserInfoId(), Map.class);

        repository().findById(outOfPoint.get???()).ifPresent(applying->{
            
            applying // do something
            repository().save(applying);

            AppliesFailed appliesFailed = new AppliesFailed(applying);
            appliesFailed.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
