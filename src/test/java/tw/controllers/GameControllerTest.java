package tw.controllers;


import org.junit.Before;
import org.junit.Test;
import tw.commands.GuessInputCommand;
import tw.commands.InputCommand;
import tw.core.Answer;
import tw.core.Game;
import tw.core.exception.OutOfRangeAnswerException;
import tw.core.generator.AnswerGenerator;
import tw.core.generator.RandomIntGenerator;
import tw.views.GameView;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


/**
 * 在GameControllerTest文件中完成GameController中对应的单元测试
 */
public class GameControllerTest {
    private GameController gameController;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setup() throws OutOfRangeAnswerException {
        gameController = new GameController(new Game(new AnswerGenerator(new RandomIntGenerator())), new GameView());
        System.setOut(new PrintStream(outContent));
    }

    @Test
    public void should_print_game_begin_message_when_the_game_begins() throws Exception {
        gameController.beginGame();
        assertEquals("------Guess Number Game, You have 6 chances to guess!  ------\r\n", systemOut());
    }

    @Test
    public void should_current_input_when_the_game_begins() throws Exception {
        Answer answer = Answer.createAnswer("1 2 3 4");
        InputCommand inputCommand = mock(GuessInputCommand.class);
        when(inputCommand.input()).thenReturn(answer);
        AnswerGenerator answerGenerator = mock(AnswerGenerator.class);
        when(answerGenerator.generate()).thenReturn(answer);
        gameController = new GameController(new Game(answerGenerator), new GameView());
        gameController.play(inputCommand);
        assertEquals("Guess Result: 4A0B\r\n" +
                "Guess History:\r\n" +
                "[Guess Numbers: 1 2 3 4, Guess Result: 4A0B]\r\n" +
                "Game Status: success\r\n", systemOut());
    }

    private String systemOut() {
        return outContent.toString();
    }
}