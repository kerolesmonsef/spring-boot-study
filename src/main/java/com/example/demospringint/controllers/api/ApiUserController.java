package com.example.demospringint.controllers.api;

import com.example.demospringint.models.User;
import com.example.demospringint.repositories.jpa.intefaces.JpaUserRepository;
import com.example.demospringint.resources.UserResource;
import com.example.demospringint.resources.i.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/api/users", produces = "application/json")
@CrossOrigin(origins = "*")
public class ApiUserController {
    JpaUserRepository userRepository;

    public ApiUserController(JpaUserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @GetMapping("/{id}")
    public EntityModel<User> show(@PathVariable("id") Long id) {
        Optional<User> user = userRepository.findById(id);
        log.info("User with id {} found", id);

        return EntityModel.of(user.orElse(null));
    }

    @PostMapping("")
    public User store(@RequestBody @Valid User user) {
        return userRepository.save(user);
    }

    @GetMapping("")
    public List<User> users() throws InterruptedException {

        Pageable pageable = PageRequest.of(1, 5);

        //        CollectionModel<UserResource> tacoResources = new UserResourceAssembler().toCollectionModel(users);
        System.out.println("called apiapi at" + new Date() + " => " + Thread.currentThread().getName());

        Thread.sleep(5000);
//        return userRepository.findAll(pageable).getContent();
        return Arrays.asList(new User());
    }


    @PutMapping("/{id}")
    public User update(@PathVariable("id") Long id, @RequestBody @Valid User user) {
        userRepository.save(user);
        return user; // TODO: return updated user
    }

    // TODO: delete user
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userRepository.deleteById(id);
    }

    // test method
    @GetMapping("/test")
    public ResponseEntity test() {

        Response response = new Response()
                .add("user", new UserResource(new User()));

//        return EntityModel.of(response.getData());

        return ResponseEntity.ok(response.getData());

//        return ResponseEntity.ok(users);
    }
}
