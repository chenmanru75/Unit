package tw.core.generator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * 在AnswerGeneratorTest文件中完成AnswerGenerator中对应的单元测试
 */
public class AnswerGeneratorTest {
    private AnswerGenerator answer;
    private RandomIntGenerator randomIntGenerator;

    @Before
    public void setup() {
        randomIntGenerator = mock(RandomIntGenerator.class);
        when(randomIntGenerator.generateNums(9, 4)).thenReturn("1 2 3 4");
        answer = new AnswerGenerator(randomIntGenerator);
    }

    @Test
    public void should_print_generate_actual_answer_when_the_game_begins() throws Exception {
        assertEquals("1 2 3 4", answer.generate().toString());
    }
}

