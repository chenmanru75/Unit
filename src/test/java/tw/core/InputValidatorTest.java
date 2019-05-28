package tw.core;

import org.junit.Before;
import org.junit.Test;
import tw.validator.InputValidator;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * 在InputValidatorTest文件中完成InputValidator中对应的单元测试
 */
public class InputValidatorTest {
    private InputValidator validator;

    @Before
    public void setup() {
        validator = new InputValidator();
    }

    @Test
    public void should_return_input_string_to_list() throws Exception {
        Method numStrToList = validator.getClass().getDeclaredMethod("numStrToList", String.class);
        numStrToList.setAccessible(true);
        Object result = numStrToList.invoke(validator, "1 2 3 4");
        assertEquals("[1, 2, 3, 4]", ((List<String>)result).toString());
    }

    @Test
    public void should_return_result_of_validate_list_size() throws Exception {
        List<String> expectResult = Arrays.asList("1", "2", "3", "4");
        Method validateDigitsCount = validator.getClass().getDeclaredMethod("validateDigitsCount", List.class, int.class);
        validateDigitsCount.setAccessible(true);
        Object result = validateDigitsCount.invoke(validator, expectResult, 4);
        assertEquals(true, result);
    }

    @Test
    public void should_return_result_of_validate_list_single_num_count() throws Exception {
        List<String> expectResult = Arrays.asList("1", "2", "3", "4");
        Method validateSingleGigit = validator.getClass().getDeclaredMethod("validateSingleGigit", List.class, int.class);
        validateSingleGigit.setAccessible(true);
        Object result = validateSingleGigit.invoke(validator, expectResult, 4);
        assertEquals(true, result);
    }

    @Test
    public void should_return_input_string_validate_result() {
        boolean result = validator.validate("1 2 3 4");
        assertEquals(true, result);
    }
}
