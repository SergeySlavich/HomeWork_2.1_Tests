import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Tests {
    
    @Test
    public void testIsWin() {
        System.out.println("Test isWin");
        //arrange
        char[][] field = {
                {'0', '0', 'X'},
                {'0', 'X', '0'},
                {'X', '0', 'X'}
        };
        char player = 'X';
        //act
        boolean result = Main.isWin(field, 'X');
        //assert
        assertTrue(result);
    }

    @ParameterizedTest
    @MethodSource("testSource")
    public void testParameterizedIsWin(char[][] field){
        char player = 'X';
        assertTrue(Main.isWin(field, player));
    }
    private static Stream<Arguments> testSource(){
        char[][] horizontal = new char[][] {
                {'X', 'X', 'X'},
                {'-', '-', '-'},
                {'-', '-', '-'}
        };
        char[][] vertical = new char[][] {
                {'X', '-', '-'},
                {'X', '-', '-'},
                {'X', '-', '-'}
        };
        char[][] leftDiagonal = new char[][] {
                {'X', '-', '-'},
                {'-', 'X', '-'},
                {'-', '-', 'X'}
        };
        char[][] rightDiagonal = new char[][] {
                {'-', '-', 'X'},
                {'-', 'X', '-'},
                {'X', '-', '-'}
        };
        return Stream.of(
                Arguments.of((Object) horizontal),
                Arguments.of((Object) vertical),
                Arguments.of((Object) leftDiagonal),
                Arguments.of((Object) rightDiagonal)
        );
    }

    @Test
    public void testIsFieldFull(){
        System.out.println("Test isFieldFull");
        //arrange
        char[][] field = {
                {'X', '0', 'X'},
                {'0', 'X', '0'},
                {'0', 'X', '0'}
        };
        //act
        boolean result = Main.isFieldFull(field);
        //assert
        assertTrue(result);
    }
}
