package poeninja.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Detail {

    private int id;
    private String icon;
    private String name;
    private String poeTradeId;
}
