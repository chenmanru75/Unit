package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.model.GuessResult;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static tw.core.GameStatus.CONTINUE;

/**
 * 在GameTest文件中完成Game中对应的单元测试
 */


public class GameTest {
    private Game game;

    @Before
    public void setup() throws OutOfRangeAnswerException {
        Answer answer = Answer.createAnswer("1 2 3 4");
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);
        game = new Game(answerGenerator);
    }

    @Test
    public void should_get_game_status_is_CONTINUE() {
        assertEquals(true, game.checkCoutinue());
    }

    @Test
    public void should_get_game_status() {
        assertEquals(CONTINUE, game.checkStatus());
    }

    @Test
    public void should_get_guess_result() {
        Answer answer = Answer.createAnswer("1 2 3 4");
        GuessResult guessResult =  game.guess(answer);
        GuessResult expectedResult = new GuessResult("4A0B", answer);
        assertEquals(expectedResult.getResult(), guessResult.getResult());
    }
}
