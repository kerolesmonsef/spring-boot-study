package com.example.demospringint.messaging.types.jms;

import com.example.demospringint.models.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;

@Slf4j
@Component
public class JmsUserListener {

    //    @JmsListener(destination = "order") // you can add another @JmsListener(destination = "order") to listen to another thread
//    @JmsListener(destination = "user", concurrency = "1-1")
    // the concurrency is the number of threads that will be used to process the messages
    public void listenAndReceive(User user) throws JMSException {
        log.info(Thread.currentThread().getName()); // with @JmsListener, the thread name will be the same
        log.info(Thread.activeCount() + "");
        log.info(user + "");
    }

}
