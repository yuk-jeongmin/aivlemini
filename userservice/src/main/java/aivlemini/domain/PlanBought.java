package aivlemini.domain;

import aivlemini.domain.*;
import aivlemini.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PlanBought extends AbstractEvent {

    private Long id;
    private Boolean isPurchase;
    private String userName;
    private Date planStartDate;
    private Date planEndDate;

    public PlanBought(UserInfo aggregate) {
        super(aggregate);
    }

    public PlanBought() {
        super();
    }
}
//>>> DDD / Domain Event
