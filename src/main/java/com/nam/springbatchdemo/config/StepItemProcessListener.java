package com.nam.springbatchdemo.config;

import org.springframework.batch.core.ItemProcessListener;

public class StepItemProcessListener implements ItemProcessListener<String,Number> {
    @Override
    public void beforeProcess(String s) {
        System.out.println("ItemProcessListener - beforeProcess");
    }

    @Override
    public void afterProcess(String s, Number number) {
        System.out.println("ItemProcessListener - afterProcess");
    }

    @Override
    public void onProcessError(String s, Exception e) {
        System.out.println("ItemProcessListener - onProcessError");
    }
}
