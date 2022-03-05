package com.example.springboot.exception.Service;

import java.util.concurrent.CountDownLatch;

public interface AsyncService {
    void executeAsync(CountDownLatch latch);
}
