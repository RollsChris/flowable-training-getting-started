package com.flowable.gsd.work.services;

public record VerificationResult(String cardNumber, boolean isValid, String message){}
