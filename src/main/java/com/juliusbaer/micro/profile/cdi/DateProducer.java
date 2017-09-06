package com.juliusbaer.micro.profile.cdi;

import java.time.LocalDateTime;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;


@ApplicationScoped
public class DateProducer {
    
    
    @Produces
    LocalDateTime getDateTimeNow() {
        return LocalDateTime.now();
    }
}