package tw.core;


import org.junit.Before;
import org.junit.Test;
import tw.core.generator.RandomIntGenerator;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在RandomIntGeneratorTest文件中完成RandomIntGenerator中对应的单元测试
 */
public class RandomIntGeneratorTest {
    public RandomIntGenerator randomIntGenerator;

    @Before
    public void setup() {
        randomIntGenerator = new RandomIntGenerator();
    }

    @Test(expected = IllegalArgumentException.class)
    public void should_throws_IllegalArgumentException() {
        randomIntGenerator.generateNums(3, 4);
    }

    @Test
    public void should_return_generate_nums_string() {
        RandomIntGenerator randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
        assertEquals("1 2 3 4", randomIntGenerator.generateNums(9, 4));
    }
}