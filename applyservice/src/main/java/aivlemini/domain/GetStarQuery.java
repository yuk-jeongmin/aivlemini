package aivlemini.domain;

import java.util.Date;
import lombok.Data;

@Data
public class GetStarQuery {

    private Integer id;
    private String isPurchase;
    private String status;
    private UserId userId;
    private BookId bookId;
}
