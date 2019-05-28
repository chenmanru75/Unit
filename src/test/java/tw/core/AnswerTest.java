package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;

import static org.junit.Assert.assertEquals;

/**
 * 在AnswerTest文件中完成Answer中对应的单元测试
 */
public class AnswerTest {
    private Answer answer;

    @Before
    public void setup() {
        answer = Answer.createAnswer("1 2 3 4");
    }

    @Test(expected = OutOfRangeAnswerException.class)
    public void should_throws_OutOfRangeAnswerException_when_answer_string_validate() throws OutOfRangeAnswerException {
        Answer guess_answer = Answer.createAnswer("1 2 3 1");
        guess_answer.validate();
    }

    @Test
    public void should_return_guess_result() {
        Answer guess_answer = Answer.createAnswer("1 2 3 4");
        assertEquals("4A0B", answer.check(guess_answer).getValue());
    }

    @Test
    public void should_return_answer_string() {
        assertEquals("1 2 3 4", answer.toString());
    }

    @Test
    public void should_return_num_index_of_answer_string() {
        assertEquals(0, answer.getIndexOfNum("1"));
    }
}