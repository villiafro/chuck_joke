package com.bangsapabbi.helloworld;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.containsString;

import org.junit.Test;


public class WorldTest {

    @Test
    public void greetResultsInHello() {
        World world = new World();
        assertThat(world.greet(), containsString("Chuck Norris"));
    }
}
