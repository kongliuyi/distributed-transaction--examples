package net.riking.provider.fruits;

import com.codingapi.txlcn.tc.config.EnableDistributedTransaction;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient  ///开启对EurekaClient的支持，即：作为Eureka客户端，高版本可省略
@EnableDistributedTransaction
public class ProviderFruitsApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProviderFruitsApplication.class, args);
    }

}
