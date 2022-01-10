package com.example.startrekbalancerinjectors.Service;

import com.example.startrekbalancerinjectors.Balancer.BalanceInjectors;
import com.example.startrekbalancerinjectors.Models.PlasmaStream;
import com.example.startrekbalancerinjectors.Models.PlasmaStreamResponse;
import org.springframework.stereotype.Service;

@Service
public class InjectorService {

    private BalanceInjectors balanceInjectors;

    public PlasmaStreamResponse calculateBalanceInjector(PlasmaStream plasmaStream) {
        balanceInjectors = new BalanceInjectors(plasmaStream);
        return balanceInjectors.calculateBalanceInjector();
    }
}
