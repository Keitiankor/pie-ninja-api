package poeninja.api.dto;

import java.time.ZonedDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PayOrReceive {

    private int id;
    private int leaguId;
    private int payCurrencyId;
    private int getCurrencyId;
    private ZonedDateTime sampleTimeUtc;
    private int count;
    private int value;
    private int datePointCount;
    private boolean includesSecondary;
}
