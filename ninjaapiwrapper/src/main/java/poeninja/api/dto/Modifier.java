package poeninja.api.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Modifier {

    private String text;
    private boolean optional;
}
