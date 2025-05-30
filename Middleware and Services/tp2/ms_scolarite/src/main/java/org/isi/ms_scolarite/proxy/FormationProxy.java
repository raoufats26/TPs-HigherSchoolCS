package org.isi.ms_scolarite.proxy;

import org.isi.ms_scolarite.Model.Formation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ms-Formation",url = "localhost:8082")
public interface FormationProxy {
    @GetMapping("/formations/{id}")
    public Formation getFormation(@PathVariable("id") Long idf);
}
