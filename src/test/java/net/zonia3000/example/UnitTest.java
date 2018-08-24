package net.zonia3000.example;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * This useless UnitTest class is provided to show that if you have both unit
 * test and integration test classes you need to configure the
 * maven-surefire-plugin in order to exclude the integration test ones (see
 * pom.xml).
 *
 * @author zonia3000
 */
public class UnitTest {

    @Test
    public void fakeTest() {
        assertTrue(true);
    }
}
