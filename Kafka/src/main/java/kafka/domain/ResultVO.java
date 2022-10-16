package kafka.domain;

import kafka.domain.enums.CodeType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResultVO<T> {
    
    private String message = "";

    private CodeType code = null;

    private T result = null; 
}
