package com.github.steveash.guavate;

import static org.junit.Assert.*;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;


/**
 * @author Steve Ash
 */
public class ObjIntPairTest {

    @Test
    public void shouldMakeCorrectly() throws Exception {
        ObjIntPair<String> result = ObjIntPair.of("steve", 42);
        assertEquals("steve", result.getFirst());
        assertEquals(42, result.getSecond());

        ObjIntPair<String> result2 = ObjIntPair.ofPair(Pair.of("steve", 42));
        assertEquals(result, result2);
    }
}
