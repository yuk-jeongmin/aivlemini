package aivlemini.domain;

import aivlemini.domain.*;
import aivlemini.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class AppliesFailed extends AbstractEvent {

    private Integer id;
    private String isPurchase;
    private UserId userId;
    private BookId bookId;
    private String status;

    public AppliesFailed(Applying aggregate) {
        super(aggregate);
    }

    public AppliesFailed() {
        super();
    }
}
//>>> DDD / Domain Event
