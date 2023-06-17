package poeninja.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CurrencyLine {

    private String detailsId;
    private String currencyTypeName;
    private PayOrReceive pay;
    private PayOrReceive receive;
    private SparkLine paySparkLine;
    private SparkLine receiveSparkLine;
    private SparkLine lowConfidencePaySparkLine;
    private SparkLine lowConfidenceReceiveSparkLine;
}
