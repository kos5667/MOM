package kafka.domain.enums;

public enum CodeType {
    
    SUCCESS(0, "SUCCESS"), 
    FAIL(-1, "FAIL");

    CodeType(Integer code, String type) {
    }

    private Integer code;

    private String type;
}
