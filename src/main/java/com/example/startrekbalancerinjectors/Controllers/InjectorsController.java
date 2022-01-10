package com.example.startrekbalancerinjectors.Controllers;

import com.example.startrekbalancerinjectors.Models.PlasmaStream;
import com.example.startrekbalancerinjectors.Models.PlasmaStreamResponse;
import com.example.startrekbalancerinjectors.Service.InjectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "api/v1/injectors")
public class InjectorsController {
    private final InjectorService injectorService;

    @Autowired
    public InjectorsController(InjectorService injectorService) {
        this.injectorService = injectorService;
    }

    @PostMapping
    public ResponseEntity<PlasmaStreamResponse> calculateBalanceInjectors(@RequestBody PlasmaStream plasmaStream){
        return new ResponseEntity<PlasmaStreamResponse>(injectorService.calculateBalanceInjector(plasmaStream), HttpStatus.OK);
    }
}
