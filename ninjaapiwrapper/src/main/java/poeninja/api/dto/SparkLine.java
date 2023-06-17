package poeninja.api.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SparkLine {

    private List<Integer> data;
    private float totalChange;
}
