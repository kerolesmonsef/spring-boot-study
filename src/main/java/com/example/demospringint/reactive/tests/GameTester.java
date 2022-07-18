package com.example.demospringint.reactive.tests;


import com.example.demospringint.reactive.models.Game;
import com.example.demospringint.reactive.services.GameService;
import org.junit.Test;
import rx.Observable;
import rx.Observer;

public class GameTester {

    @Test
    public void testGame() {
        GameService gameService = new GameService();
        Observable<Game> gameObservable = gameService.games();

//        gameObservable.subscribe(
//                data -> System.out.println("data: " + data),
//                error -> System.out.println("error accrued: " + error),
//                () -> System.out.println("we are done ... thanks for playing")
//        );

        Observer observer = new Observer<Game>() {


            @Override
            public void onCompleted() {
                System.out.println("we are done ... thanks for playing");
            }

            @Override
            public void onError(Throwable e) {
                System.out.println("error accrued: thanks -> " + e);
            }

            @Override
            public void onNext(Game game) {
                System.out.println("onNext: " + game);
            }
        };
        gameObservable.subscribe(observer);
    }


}
