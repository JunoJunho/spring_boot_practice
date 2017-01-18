package com.junojunho;

import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.PublicMetrics;
import org.springframework.boot.actuate.metrics.Metric;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Component
public class ApplicationContextMetrics implements PublicMetrics{

    private ApplicationContext context;

    @Autowired
    public ApplicationContextMetrics(ApplicationContext context){
        this.context = context;
    }

    @Override
    public Collection<Metric<?>> metrics() {

        List<Metric<?>> metrics = new ArrayList<>();
        metrics.add(new Metric<Long>("spring.context.startup-date", context.getStartupDate()));

        metrics.add(new Metric<Integer>("spring.beans.definitions", context.getBeanDefinitionCount()));

        metrics.add(new Metric<Integer>("spring.controllers", context.getBeanNamesForAnnotation(Controller.class).length));


        return metrics;
    }
}
