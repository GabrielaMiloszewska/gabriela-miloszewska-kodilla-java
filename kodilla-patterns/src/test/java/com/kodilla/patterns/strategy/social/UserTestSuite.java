package com.kodilla.patterns.strategy.social;

import com.kodilla.patterns.strategy.social.publishers.TwitterPublisher;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTestSuite {

    @Test
    void testDefaultSharingStrategies() {
        //Given
        User users80 = new Millenials("Kasia");
        User users90 = new YGeneration("Julia");
        User users00 = new ZGeneration("Hania");

        //When
        String millenialsChosenSM = users80.sharePost();
        System.out.println("Kasia " + millenialsChosenSM);
        String yGenerationChosenSM = users90.sharePost();
        System.out.println("Julia " + yGenerationChosenSM);
        String zGenerationChosenSM = users00.sharePost();
        System.out.println("Hania " + zGenerationChosenSM);

        //Then
        assertEquals("[Facebook publisher] uses Facebook as a favorite social media channel", millenialsChosenSM);
        assertEquals("[Twitter publisher] uses Twitter as a favorite social media channel", yGenerationChosenSM);
        assertEquals("[Snapchat publisher] uses Snapchat as a favorite social media channel", zGenerationChosenSM);
    }

    @Test
    void testIndividualSharingStrategy() {
        //Given
        User users80 = new Millenials("Kasia");

        //When
        String millenialsChosenSM = users80.sharePost();
        System.out.println("Kasia " + millenialsChosenSM);
        users80.setSocialPublisher(new TwitterPublisher());
        millenialsChosenSM = users80.sharePost();
        System.out.println("Kasia very often " + millenialsChosenSM);

        //Then
        assertEquals("[Twitter publisher] uses Twitter as a favorite social media channel", millenialsChosenSM);
    }
}
