package org.isi.msscolarite.proxy;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.isi.msscolarite.Model.Formation;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-formation")
@LoadBalancerClient(name = "ms-formation")
public interface FormationProxy {
    @GetMapping("/formations/{id}")
    @CircuitBreaker(name = "fall", fallbackMethod = "fallbackFormation")

    public Formation getFormation(@PathVariable("id") Long idf);
    default Formation fallbackFormation(@PathVariable("id") Long idf, Throwable throwable){
        if (idf.equals(1L))
            return new Formation(1L,"intergiciel",15);
        else if (idf.equals(2L))
            return new Formation(2L,"IoT",10);
        return new Formation(3L,"Reseau",20);

    };
}