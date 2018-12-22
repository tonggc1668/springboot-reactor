package org.springboot.reactor.example;

import static reactor.event.selector.Selectors.$;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.Reactor;

@Service
public class ReactorService implements InitializingBean{

    @Autowired
    private Reactor reactor;

    @Autowired
    private AppListener appListener;

    @Override
    public void afterPropertiesSet() throws Exception {
        reactor.on($("eventHandler"), appListener);
    }
}