package model;
import java.util.Map;

public record Moneda(String base_code,
                     String target_code,
                     Double conversion_rate) {
}
