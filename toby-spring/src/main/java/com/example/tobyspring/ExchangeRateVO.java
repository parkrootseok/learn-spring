package com.example.tobyspring;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.math.BigDecimal;
import java.util.Map;

/**
 * [Record]
 * - Class를 사용하여 Dto를 만들면 Filed를 정의하고 생성자 또는 Setter를 활용하여 값을 주입 한 후 Getterf를 통해 값을 가져옴
 * - Class와 달리 Record를 사용하면 Getter, Setter, toString 등을 선언할 필요가 없음
 */

@JsonIgnoreProperties(ignoreUnknown = true)
public record ExchangeRateVO(String result, Map<String, BigDecimal> rates) {

}
