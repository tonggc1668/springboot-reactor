package org.springboot.reactor.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.Reactor;
import reactor.event.Event;

@RestController
@RequestMapping("/api")
public class ReactorController {

    @Autowired
    private Reactor reactor;

    @RequestMapping("/test")
    public void test() throws InterruptedException{
        User user = new User();
        user.firstName = "Chetan";
        user.lastName = "Birajdar";
        user.address = "410 S Hauser";
        user.city = "Los Angeles";
        reactor.notify("eventHandler", Event.wrap(user));
        System.out.println("y0, I sent something for you!!");
    }
}