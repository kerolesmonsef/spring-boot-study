package com.example.demospringint.controllers.reactive;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/reactive/user")
@RestController
public class ReactiveUserController {

//    @Autowired
//    public ReactiveUserRepository userRepository;

//    @GetMapping("/")
//    public Flux<User> index() {
//        Flux<User> users = WebClient
//                .create()
//                .get()
//                .uri("http://localhost:8080/api/users")
//                .retrieve()
//                .bodyToFlux(User.class);
//
////
//        users.subscribe((user) -> {
//            System.out.println(Thread.currentThread().getName() + " => " + user);
//        });
//
//        Flux<User> users2 = Flux.empty();
//
//
//        System.out.println("called reactive at" + new Date() + " => " + Thread.currentThread().getName());
//
////        Flux<User> userFlux = userRepository.findAll();
//        return Flux.fromIterable(Arrays.asList(new User(), new User()));
////        return users;
//    }
}
