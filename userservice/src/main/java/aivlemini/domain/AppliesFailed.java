package aivlemini.domain;

import aivlemini.domain.*;
import aivlemini.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class AppliesFailed extends AbstractEvent {

    private Integer id;
    private String isPurchase;
    private Object userId;
    private Object bookId;
    private String status;
}
