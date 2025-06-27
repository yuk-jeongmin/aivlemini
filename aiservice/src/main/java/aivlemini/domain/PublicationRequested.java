package aivlemini.domain;

import aivlemini.domain.*;
import aivlemini.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PublicationRequested extends AbstractEvent {

    private Long id;
    private String date;
    private String contents;
    private Object authorId;
    private String title;
    private String status;
    private String authorName;
}
