package poeninja.api.wrapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import poeninja.api.dto.*;
import poeninja.api.network.ApiRequest;

public class JsonWrapper {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static CurrencyOverview getCurrencyOverview(String str) {
        JsonNode jsonNode = null;
        try {
            jsonNode = mapper.readTree(ApiRequest.get("currency", str));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

        if (jsonNode != null) {
            return CurrencyOverview
                .builder()
                .lines(readCurrencyLines(jsonNode))
                .currencyDetails(readDetails(jsonNode))
                .build();
        }
        return null;
    }

    public static ItemOverview getItemOverview(String str) {
        JsonNode jsonNode;
        try {
            jsonNode = mapper.readTree(ApiRequest.get("item", str));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }

        return ItemOverview.builder().lines(readItemLines(jsonNode)).build();
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    private static CurrencyLine readCurrencyLine(JsonNode jsonNode) {
        return CurrencyLine
            .builder()
            .detailsId(jsonNode.get("detailsId").asText())
            .currencyTypeName(jsonNode.get("currencyTypeName").asText())
            .pay(readPayOrReceive(jsonNode.get("pay")))
            .receive(readPayOrReceive(jsonNode.get("receive")))
            .paySparkLine(readSparkLine(jsonNode.get("paySparkLine")))
            .receiveSparkLine(readSparkLine(jsonNode.get("receiveSparkLine")))
            .lowConfidencePaySparkLine(readSparkLine(jsonNode.get("lowConfidencePaySparkLine")))
            .lowConfidenceReceiveSparkLine(readSparkLine(jsonNode.get("lowConfidencePaySparkLine")))
            .build();
    }

    private static List<CurrencyLine> readCurrencyLines(JsonNode jsonNode) {
        List<CurrencyLine> cls = new ArrayList<>();
        JsonNode jn = jsonNode.get("lines");
        for (JsonNode node : jn) {
            cls.add(readCurrencyLine(node));
        }

        return cls;
    }

    private static Detail readDetail(JsonNode jsonNode) {
        if (jsonNode == null) {
            return null;
        }
        return Detail
            .builder()
            .id(jsonNode.get("id").asInt())
            .icon(jsonNode.get("icon") == null ? null : jsonNode.get("icon").asText())
            .name(jsonNode.get("name") == null ? null : jsonNode.get("name").asText())
            .poeTradeId(jsonNode.get("id") == null ? null : jsonNode.get("id").asText())
            .build();
    }

    private static List<Detail> readDetails(JsonNode jsonNode) {
        List<Detail> ds = new ArrayList<>();
        JsonNode jn = jsonNode.get("currencyDetails");
        for (JsonNode node : jn) {
            ds.add(readDetail(node));
        }
        return ds;
    }

    private static ItemLine readItemlLine(JsonNode jsonNode) {
        return ItemLine
            .builder()
            .id(jsonNode.get("id") == null ? 0 : jsonNode.get("id").asInt())
            .name(jsonNode.get("name") == null ? null : jsonNode.get("name").asText())
            .icon(jsonNode.get("icon") == null ? null : jsonNode.get("icon").asText())
            .mapTier(jsonNode.get("mapTier") == null ? 0 : jsonNode.get("mapTier").asInt())
            .baseType(jsonNode.get("baseType") == null ? null : jsonNode.get("baseType").asText())
            .stackSize(jsonNode.get("stackSize") == null ? 0 : jsonNode.get("stackSize").asInt())
            .variant(jsonNode.get("variant") == null ? null : jsonNode.get("variant").asText())
            .prophecyText(jsonNode.get("prophecyText") == null ? null : jsonNode.get("prophecyText").asText())
            .artFilename(jsonNode.get("artFilename") == null ? null : jsonNode.get("artFilename").asText())
            .links(jsonNode.get("links") == null ? 0 : jsonNode.get("links").asInt())
            .itemClass(jsonNode.get("itemClass") == null ? 0 : jsonNode.get("itemClass").asInt())
            .sparkLine(readSparkLine(jsonNode.get("sparkLine")))
            .lowConfidenceSparkline(readSparkLine(jsonNode.get("lowConfidenceSparkline")))
            .implicitModifires(readModifiers(jsonNode.get("implicitModifiers")))
            .explicitModifires(readModifiers(jsonNode.get("explicitModifiers")))
            .flavorText(jsonNode.get("flavorText") == null ? null : jsonNode.get("flavorText").asText())
            .corrupted(jsonNode.get("corrupted") == null ? false : jsonNode.get("corrupted").asBoolean())
            .gemLevel(jsonNode.get("gemLevel") == null ? 0 : jsonNode.get("gemLevel").asInt())
            .gemQuality(jsonNode.get("gemQuality") == null ? 0 : jsonNode.get("gemQuality").asInt())
            .itemType(jsonNode.get("itemType") == null ? null : jsonNode.get("itemType").asText())
            .chaosValue(jsonNode.get("chaosValue") == null ? 0 : jsonNode.get("chaosValue").asInt())
            .exaltedValue(jsonNode.get("exaltedValue") == null ? 0 : jsonNode.get("exaltedValue").asInt())
            .count(jsonNode.get("count") == null ? 0 : jsonNode.get("count").asInt())
            .detailsId(jsonNode.get("detailsId") == null ? null : jsonNode.get("detailsId").asText())
            .build();
    }

    private static List<ItemLine> readItemLines(JsonNode jsonNode) {
        List<ItemLine> ils = new ArrayList<>();
        JsonNode jn = jsonNode.get("lines");
        for (JsonNode node : jn) {
            ils.add(readItemlLine(node));
        }
        return ils;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    private static PayOrReceive readPayOrReceive(JsonNode jsonNode) {
        if (jsonNode == null) {
            return null;
        }
        return PayOrReceive
            .builder()
            .id(jsonNode.get("id").asInt())
            .leaguId(jsonNode.get("league_id").asInt())
            .payCurrencyId(jsonNode.get("pay_currency_id").asInt())
            .getCurrencyId(jsonNode.get("get_currency_id").asInt())
            .sampleTimeUtc(ZonedDateTime.parse(jsonNode.get("sample_time_utc").asText()))
            .count(jsonNode.get("count").asInt())
            .value(jsonNode.get("value").asInt())
            .datePointCount(jsonNode.get("data_point_count").asInt())
            .includesSecondary(jsonNode.get("includes_secondary").asBoolean())
            .build();
    }

    private static SparkLine readSparkLine(JsonNode jsonNode) {
        if (jsonNode == null) {
            return null;
        }
        return SparkLine
            .builder()
            .data(readData(jsonNode))
            .totalChange((float) jsonNode.get("totalChange").asDouble(0))
            .build();
    }

    private static Modifier readModifier(JsonNode jsonNode) {
        return Modifier
            .builder()
            .text(jsonNode.get("text").asText())
            .optional(jsonNode.get("optional").asBoolean())
            .build();
    }

    private static List<Modifier> readModifiers(JsonNode jsonNode) {
        if (jsonNode == null) {
            return null;
        }
        List<Modifier> ils = new ArrayList<>();
        for (JsonNode node : jsonNode) {
            ils.add(readModifier(node));
        }
        return ils;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////
    private static List<Integer> readData(JsonNode jsonNode) {
        List<Integer> lst = new ArrayList<>();
        if (jsonNode == null) {
            return null;
        }
        JsonNode jn = jsonNode.get("data");
        for (JsonNode node : jn) {
            lst.add(node.asInt(0));
        }
        return lst;
    }
}
