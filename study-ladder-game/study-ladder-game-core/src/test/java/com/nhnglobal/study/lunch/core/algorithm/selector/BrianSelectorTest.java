package com.nhnglobal.study.lunch.core.algorithm.selector;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class BrianSelectorTest {

    private BrianSelector selector;

    private static final List<String> participants = List.of("kevin", "kelly", "jay", "jane");
    private static final Random random = new Random();
    private static final String BRIAN = "brian";

    @Before
    public void setup() {
        this.selector = new BrianSelector();
    }

    @Test
    public void does_not_return_null() {
        // given
        Integer winner = random.nextInt();

        // when
        List<String> winners = selector.select(participants, winner);

        //then
        Assert.assertNotNull(winners);
    }

    @Test
    public void winners_size_equals_to_given_winner() {
        // given
        int winner = random.nextInt(participants.size());

        // when
        List<String> winners = selector.select(participants, winner);

        // then
        Assert.assertEquals(winner, winners.size());
    }

    @Test
    public void winners_size_does_not_exceeds_participants_size() {

        // given
        int winner = participants.size() + random.nextInt(100);

        // when
        List<String> winners = selector.select(participants, winner);

        // then
        Assert.assertEquals(participants.size(), winners.size());
    }

    @Test
    public void return_empty_list_when_winner_is_null() {

        // given
        Integer winner = null;

        // when
        List<String> winners = selector.select(participants, winner);

        // then
        Assert.assertEquals(Collections.emptyList(), winners);
    }

    @Test
    public void return_empty_list_when_winner_is_negative() {

        // given
        Integer winner = -1 * random.nextInt(10);

        // when
        List<String> winners = selector.select(participants, winner);

        // then
        Assert.assertEquals(Collections.emptyList(), winners);
    }

    @Test
    public void returns_only_brian() {
        // given
        int winner = random.nextInt(participants.size());

        // when
        List<String> winners = selector.select(participants, winner);

        // then
        Assert.assertTrue(winners.stream().allMatch(person -> person.equals(BRIAN)));
    }
}
