package com.example.startrekbalancerinjectors.Balancer;

import com.example.startrekbalancerinjectors.Models.PlasmaStream;
import com.example.startrekbalancerinjectors.Models.PlasmaStreamResponse;

import java.util.ArrayList;
import java.util.List;

public class BalanceInjectors extends PlasmaStream {
    private final int numberInjectors;

    public BalanceInjectors(PlasmaStream plasmaStream) {
        super(plasmaStream.getDamageList(), plasmaStream.getLightSpeed());
        numberInjectors = plasmaStream.getDamageList().size();
    }

    public int PercentSpeedLight(){
        List<Integer> speedLightStream = new ArrayList<>() ;
        if(numberInjectors > 0) {
            for (int damage: getDamageList())
                 speedLightStream.add(IndefinitePlasmaStream(damage));

            int amountStreams = speedLightStream.stream().reduce(0, Integer::sum);
            return (amountStreams / numberInjectors);
        }
        return 0;
    }

    protected int IndefinitePlasmaStream(int plasmaStream) {
        if(plasmaStream >=0  && plasmaStream <= 100){
            int indefinitePlasmaStream = 100;
            indefinitePlasmaStream -= plasmaStream;
           return indefinitePlasmaStream;
        } else{
            return 0;
        }
    }

    public PlasmaStreamResponse calculateBalanceInjector(){
        PlasmaStreamResponse response = new PlasmaStreamResponse();
        response.setMessage("Unable to comply");
        response.setSpeedLight(PercentSpeedLight());

        if(numberInjectors > 0 && getLightSpeed() >=0 && getLightSpeed() <=200){
            int requiredSpeedLight = numberInjectors * getLightSpeed();
            List<Integer> speedLightStream = new ArrayList<Integer>() ;

            for(int item: getDamageList()){
                speedLightStream.add(IndefinitePlasmaStream(item));
            }

            int summatoryStreams = speedLightStream.stream().reduce(0,(a,b)-> a+b);
            int differenceStreams = Math.abs(summatoryStreams - requiredSpeedLight);
            int divisorStreams = numberInjectors - speedLightStream.stream().filter(v -> v ==0).toArray().length;
            int quotientStreams = (int)(differenceStreams / (divisorStreams == 0 ? 1 : divisorStreams));

            if(summatoryStreams >= requiredSpeedLight){
                int index = 0;
                for(int item : speedLightStream){
                    if(item >= quotientStreams)
                    {
                        differenceStreams -= quotientStreams;
                        response.setStreams(item ==0 ? item : item - quotientStreams);
                    }else{
                        differenceStreams = differenceStreams - 2 * item + quotientStreams;
                        quotientStreams = (int)(differenceStreams /(divisorStreams -(index + 1)));
                        response.setStreams(item);
                    }
                    index++;

                };
                response.setOperativeTime("Infinite");
                response.setMessage("Transaction successful");
            }else {
                if(quotientStreams <= 99){
                for(int item : speedLightStream){
                    response.setStreams(item ==0 ? item : item  + quotientStreams);
                }
                response.setOperativeTime(String.valueOf(100 - quotientStreams));
                response.setMessage("Transaction successful");
            }
            }
        }
        return response;
    }

}
