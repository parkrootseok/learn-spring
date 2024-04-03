package com.example.springstarthere.proxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.example.springstarthere.model.Payment;

/**
 * @FeignClient : OpenFeign에게 해당 인터페이스에 대한 구현 제공을 알려주기 위한 어노테이션
 * - name을 통해 프록시에 이름을 할당하고 이를 통해 클라이언트를 식별
 */
@FeignClient(name = "payments", url = "${name.service.url}")
public interface PaymentProxy {

	@PostMapping("/payment")
	Payment createPayment(@RequestHeader String requestId, @RequestBody Payment payment);

}
