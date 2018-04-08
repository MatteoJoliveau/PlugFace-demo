package org.plugface.demo.app;

import org.plugface.demo.app.sdk.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {
    @Override
    public String test() {
        return "I'm a test service from Spring!";
    }
}
