package aivlemini.domain;

import aivlemini.domain.*;
import aivlemini.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class BookApply extends AbstractEvent {

    private Integer id;
    private String isPurchase;
    private UserId userId;
    private BookId bookId;
    private String status;

    public BookApply(Applying aggregate) {
        super(aggregate);
    }

    public BookApply() {
        super();
    }
}
//>>> DDD / Domain Event
