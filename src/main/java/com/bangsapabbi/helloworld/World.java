package com.bangsapabbi.helloworld;

import net.joningi.icndb.ICNDBClient;
import net.joningi.icndb.Joke;

public class World {

    final ICNDBClient client = new ICNDBClient();

    public String greet() {
        Joke randomJoke = client.getRandom();
        return randomJoke.getJoke();
    }
}
