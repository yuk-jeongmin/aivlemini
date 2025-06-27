package aivlemini.domain;

import aivlemini.domain.*;
import aivlemini.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class PublishPrepared extends AbstractEvent {

    private Long id;
    private String coverImagePath;
    private String summaryContent;
    private String bookName;
    private String pdfPath;
    private String category;
    private String authorId;
    private ManuscriptId manuscriptId;
    private Boolean notifyStatus;
    private String authorName;

    public PublishPrepared(Publishing aggregate) {
        super(aggregate);
    }

    public PublishPrepared() {
        super();
    }
}
//>>> DDD / Domain Event
