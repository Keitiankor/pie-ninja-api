package poeninja.api.dto;

import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ItemLine {

    private long id;
    private String name;
    private String icon;
    private int mapTier;
    private String baseType;
    private int stackSize;
    private String variant;
    private String prophecyText;
    private String artFilename;
    private int links;
    private int itemClass;
    private SparkLine sparkLine;
    private SparkLine lowConfidenceSparkline;
    private List<Modifier> implicitModifires;
    private List<Modifier> explicitModifires;
    private String flavorText;
    private boolean corrupted;
    private int gemLevel;
    private int gemQuality;
    private String itemType;
    private int chaosValue;
    private int exaltedValue;
    private int count;
    private String detailsId;
}
