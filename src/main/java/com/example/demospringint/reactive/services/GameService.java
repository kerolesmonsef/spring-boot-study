package com.example.demospringint.reactive.services;

import com.example.demospringint.reactive.models.Game;
import org.springframework.stereotype.Service;
import rx.Observable;

import java.util.Arrays;
import java.util.List;

@Service
public class GameService {
    public final static List<Game> GAMES = Arrays.asList(
            new Game("Overwatch", 59.99f, 100),
            new Game("Fifa 19", 59.99f, 100),
            new Game("Fortnite", 59.99f, 100),
            new Game("PUBG", 59.99f, 100),
            new Game("Apex Legends", 59.99f, 100)
    );

    public Observable<Game> games() {
       return Observable.create(emitter -> {
         int i = 0;
           System.out.println(" starting the game");
           while (!emitter.isUnsubscribed() && i < GAMES.size()) {
               Game game = GAMES.get(i);
               if (game.getStorage() == 0) {
                   emitter.onError(new RuntimeException("game storage is 0"));
               }
               emitter.onNext(game);
               i++;
           }
           System.out.println(" ending the game");
           emitter.onCompleted();
       });
    }
}
