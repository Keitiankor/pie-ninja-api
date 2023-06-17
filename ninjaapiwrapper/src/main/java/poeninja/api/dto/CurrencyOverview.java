package poeninja.api.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrencyOverview {

    private List<CurrencyLine> lines;
    private List<Detail> currencyDetails;
}
