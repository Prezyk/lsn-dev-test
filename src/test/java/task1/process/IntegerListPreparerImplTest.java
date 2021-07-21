package task1.process;

import org.junit.jupiter.api.Test;
import task1.process.exception.IntegerListPrepareException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListPreparerImplTest {

    private IntegerListPreparer integerListPreparer = new IntegerListPreparerImpl();;

    @Test
    void testPrepareIntegerListNonIntegersInInput() {
        String input = "1 9 11 bcd 33 12 99 a 24 yu";
        assertThrows(IntegerListPrepareException.class, () -> {
            integerListPreparer.prepareIntegersList(input, " ");
        });
    }

    @Test
    void testPrepareIntegerListEmptyInput() {
        String input = "";
        assertThrows(IntegerListPrepareException.class, () -> {
            integerListPreparer.prepareIntegersList(input, " ");
        });
    }

    @Test
    void testPrepareIntegerListWrongSeparator() {
        String input = "1,5,12,3,21,21,23,31,1,0,12,0";
        assertThrows(IntegerListPrepareException.class, () -> {
            integerListPreparer.prepareIntegersList(input, " ");
        });
    }

    @Test
    void testPrepareIntegerListTwoSeparatorsInInput() {
        String input = "1,22 12 0 4,19,7 15 4 15 22 1";
        assertThrows(IntegerListPrepareException.class, () -> {
            integerListPreparer.prepareIntegersList(input, " ");
        });
    }

    @Test
    void testPrepareIntegerListShortInput() throws IntegerListPrepareException {
        String input = "37 25 20 17 5 1 2 38 43 13 4 49 29 17 11";
        List<Integer> expectedResult = Arrays.asList(37,25,20,17,5,1,2,38,43,13,4,49,29,17,11);
        List<Integer> actualResult = integerListPreparer.prepareIntegersList(input, " ");
        assertEquals(expectedResult, actualResult);

    }


    @Test
    void testPrepareIntegerListLongInput() throws IntegerListPrepareException {
        String input = "41 25 25 25 16 4 6 41 41 45 50 31 4 15 10 19 29 3 37 4 24 10 38 45 2 23 44 39 36 29 22 1 36 27 15 42 49 24 34 8 27 2 21 28 41 44 33 1 4 2 27 8 38 12 46 50 16 30 29 17 37 37 37 13 36 12 42 36 22 15 14 18 5 34 50 15 8 35 31 37 41 18 22 17 29 28 15 41 30 1 17 9 41 37 14 24 18 11 21 1 32 13 30 20 3 48 24 20 25 24 11 2 30 35 41 43 7 44 35 39 21 13 29 25 36 9 14 45 42 1 31 32 19 35 27 12 1 1 29 16 9 5 20 17 19 49 32 29 8 17 13 44 27 34 30 28 36 45 40 37 35 22 26 39 19 50 2 33 37 37 21 35 50 10 8 16 44 27 12 11 35 48 19 32 12 38 18 50 37 20 9 25 42 38 18 13 46 18 3 26 48 38 33 1 28 3 14 36 13 24 19 5 18 38 27 47 1 38 42 49 30 36 45 13 36 20 44 43 39 29 23 21 37 49 11 36 27 7 29 38 2 24 19 40 40 15 15 10 4 18 39 43 38 9 45 8 50 22 29 11 42 24 47 50 43 49 47 46 30 34 15 42 49 11 42 34 43 48 24 40 21 8 6 24 31 41 18 15 30 5 7 12 31 5 22 14 24 48 26 34 23 46 9 21 5 20 22 13 40 34 40 4 14 29 11 11 46 12 7 3 3 44 1 16 35 16 35 10 3 46 11 23 34 50 38 7 48 1 3 8 18 8 40 12 39 25 40 21 42 37 23 17 41 36 17 33 32 50 4 40 33 10 6 28 34 12 31 34 33 24 17 25 29 45 33 13 8 50 36 9 30 18 18 22 48 38 21 30 20 24 38 22 31 34 43 29 41 13 14 48 23 23 34 19 19 20 36 35 12 34 19 1 8 34 14 12 28 31 22 40 2 41 16 13 46 24 39 15 9 12 21 27 35 2 46 26 27 50 37 34 16 2 7 31 28 35 21 41 14 25 15 48 23 40 25 8 3 13 10 48 13 4 12 5 18 3 5 29 28 10 21 48 3 2 21 7 44 30 12 18 24 1 30 41 35 30 42 5 38 12 46 17 7 6 35 13 49 10 24 29 47 24 18 37 37 30 12 44 18 30 33 23 1 4 32 45 4 45 4 17 1 5 42 27 43 36 46 38 28 31 10 37 38 5 26 6 23 19 19 36 27 4 7 26 43 17 15 44 25 9 33 49 19 37 6 17 31 38 23 35 38 14 1 37 37 43 12 35 48 34 25 43 43 6 9 4 16 47 46 13 43 30 28 13 4 37 40 32 1 1 14 1 10 24 6 15 23 22 38 31 2 36 39 30 18 40 3 39 39 47 8 24 11 19 32 7 24 50 26 47 31 20 39 1 28 44 45 41 50 41 17 18 8 47 21 29 19 49 44 18 4 2 12 3 1 45 30 16 21 20 33 29 18 47 35 26 35 23 3 26 13 29 32 32 28 30 48 47 24 41 37 17 39 34 21 21 36 14 29 8 34 27 39 25 20 20 8 45 11 13 11 32 14 43 13 45 14 49 38 50 22 9 24 19 36 9 48 37 29 49 24 12 24 48 46 32 42 22 50 43 41 49 14 22 33 50 5 16 35 27 1 2 27 14 29 2 42 5 37 2 15 19 21 11 50 3 12 44 50 5 13 35 41 37 24 5 6 22 25 35 44 24 31 45 46 5 42 29 49 12 28 23 39 15 48 30 28 5 25 23 19 11 43 47 42 17 49 24 22 16 16 38 15 13 6 21 16 18 11 48 13 24 24 22 18 19 24 31 27 40 37 50 10 6 47 2 2 17 42 48 7 45 14 45 26 10 48 11 10 8 26 39 40 6 37 2 50 8 19 50 10 35 37 9 33 44 43 41 36 13 50 14 3 22 29 31 13 47 24 39 38 39 24 16 41 18 25 18 46 17 12 12 22 24 8 26 50 49 30 2 25 37 22 43 22 1 23 50 34 2 17 23 24 49 43 18 48 37 22 12 31 26 32 5 18 35 47 44 36 3 47 12 3 11 9 45 6 10 32 37 49 46 50 17 42 8 7 32 48 13 10 30 20 19 11 43 37 50 23 8 2 28 14 3 8 15 49 15 2 42 13 16 8 26 36 13 15 22 47 3 36 38 39 36 1 37 3 15 44 15 36 30 11 18 11 15 12 29 31 34 41 13 19 4 8 7 12 2 39 28 20 43 18 43 20 9 43 9 34 25 11 7 3 30 2 8 28 4 25 8 37 44 8 48 47 7 41 28 14 49 47 37 44 45 37 45 48 48 47 26 28 35 29 23 9 49 37 14 40 23 23 31 47 37 14 18 5 7 11 37 34 47 20 9 16 16 41 45 35 34 29 8 25 42 4 29 10 24 11 33 48 19 15 6 22 6 47 33 46 23 2 1 9 6 2 47 8 33 11 3 48 24 24 29 22 40 33 39 44 6 23 25 2 7 12 5 20 42 3 23 4 26 18 37 48 14 27 42 38 34 31 16 4 34 5 25 17 26 3 43 37 34 2 1 4 22 32 4 27 39 24 28 31 28 7 43 13 7 46 37 42 6 14 36 6 8 37 11 49 44 46 41 22 31 12 22 1 6 3 5 10 24 24 47 46 42 50 32 50 21 46 1 3 18 11 23 43 40 3 5 11 25 24 3 48 34 49 34 26 29 5 3 19 46 14 22 10 47 44 21 35 18 42 29 7 26 9 23 30 27 34 22 5 6 41 7 14 22 15 27 22 1 20 35 28 34 31 48 48 6 26 50 25 23 44 38 32 23 45 45 27 5 8 13 30 40 38 48 14 1 14 30 28 9 42 25 43 44 23 21 2 12 15 30 48 13 49 9 50 9 33 34 47 23 11 48 20 34 50 30 44 15 20 33 42 25 50 21 27 46 32 44 18 25 7 34 40 48 35 18 23 1 49 34 40 30 1 32 34 19 45 39 44 24 35 7 31 48 34 23 46 34 29 26 25 19 39 23 48 20 17 33 23 46 20 31 25 8 15 19 8 18 37 13 36 48 40 48 8 39 28 20 39 19 46 28 34 43 20 45 25 10 20 31 32 32 37 50 1 9 43 23 17 42 23 14 38 18 19 28 27 21 43 16 24 25 43 35 42 36 45 10 45 23 37 20 2 18 27 18 37 24 4 32 13 21 50 23 13 13 34 23 20 6 37 28 7 46 42 29 20 31 27 34 29 12 31 7 43 23 21 7 43 15 27 27 31 38 10 30 17 38 9 15 9 41 42 9 41 8 43 46 33 37 43 21 1 44 14 25 41 38 32 30 14 29 39 17 34 32 39 39 39 36 5 39 31 19 3 2 30 5 50 10 32 43 32 8 24 25 39 38 21 17 1 41 4 31 8 46 3 29 3 31 41 8 14 16 26 12 7 35 34 22 3 22 7 29 11 45 48 15 4 2 23 31 41 6 36 15 9 24 2 25 21 12 23 7 49 34 17 33 29 29 24 45 34 10 46 39 1 32 4 13 15 30 2 36 3 44 20 47 18 44 13 35 40 25 17 1 21 43 16 19 33 2 41 6 4 16 40 2 30 7 12 38 30 8 18 11 2 4 24 2 23 39 13 32 14 11 45 23 32 38 4 46 27 33 35 44 50 48 15 25 17 23 39 14 18 6 3 48 25 2 13 46 25 35 39 17 26 29 29 22 23 26 33 2 31 50 45 40 41 36 5 27 36 18 34 16 34 34 32 26 44 6 10 50 20 6 18 31 20 37 32 4 7 41 17 41 17 26 11 49 14 44 19 12 22 23 34 44 12 11 9 21 34 33 39 26 11 1 8 14 2 43 1 45 42 46 25 35 10 43 3 47 26 34 32 25 5 24 30 9 41 25 20 13 50 13 5 28 3 15 26 7 42 23 8 17 47 35 42 33 25 9 32 6 22 6 5 49 22 25 17 9 15 23 3 43 19 29 18 39 8 6 39 6 40 9 8 31 1 33 50 26 11 47 6 21 24 20 37 41 30 47 33 50 25 49 41 33 20 1 23 16 30 34 17 32 47 31 45 9 6 50 40 21 29 42 17 19 43 12 31 14 6 47 45 17 4 12 1 43 48 40 20 18 11 3 8 10 17 28 40 41 31 37 23 32 29 4 25 39 22 39 31 20 33 29 9 14 4 2 1 14 32 43 45 7 48 29 33 26 19 33 40 18 15 3 27 39 14 38 13 25 46 6 35 7 6 45 31 17 3 45 37 40 48 23 43 20 5 16 19 17 5 8 21 17 30 36 23 46 11 43 50 47 10 28 19 20 3 38 17 43 41 21 24 15 10 23 50 17 35 27 33 1 2 10 24 17 31 31 42 47 37 50 34 38 1 21 34 1 19 40 48 22 8 3 6 27 29 35 2 21 17 25 2 8 38 36 14 23 42 23 8 30 44 5 49 26 20 50 9 39 47 3 17 17 46 45 11 13 38 21 32 13 33 32 30 46 22 44 50 32 42 12 34 20";
        List<Integer> expectedResult = Arrays.asList(41,25,25,25,16,4,6,41,41,45,50,31,4,15,10,19,29,3,37,4,24,10,38,45,2,23,44,39,36,29,22,1,36,27,15,42,49,24,34,8,27,2,21,28,41,44,33,1,4,2,27,8,38,12,46,50,16,30,29,17,37,37,37,13,36,12,42,36,22,15,14,18,5,34,50,15,8,35,31,37,41,18,22,17,29,28,15,41,30,1,17,9,41,37,14,24,18,11,21,1,32,13,30,20,3,48,24,20,25,24,11,2,30,35,41,43,7,44,35,39,21,13,29,25,36,9,14,45,42,1,31,32,19,35,27,12,1,1,29,16,9,5,20,17,19,49,32,29,8,17,13,44,27,34,30,28,36,45,40,37,35,22,26,39,19,50,2,33,37,37,21,35,50,10,8,16,44,27,12,11,35,48,19,32,12,38,18,50,37,20,9,25,42,38,18,13,46,18,3,26,48,38,33,1,28,3,14,36,13,24,19,5,18,38,27,47,1,38,42,49,30,36,45,13,36,20,44,43,39,29,23,21,37,49,11,36,27,7,29,38,2,24,19,40,40,15,15,10,4,18,39,43,38,9,45,8,50,22,29,11,42,24,47,50,43,49,47,46,30,34,15,42,49,11,42,34,43,48,24,40,21,8,6,24,31,41,18,15,30,5,7,12,31,5,22,14,24,48,26,34,23,46,9,21,5,20,22,13,40,34,40,4,14,29,11,11,46,12,7,3,3,44,1,16,35,16,35,10,3,46,11,23,34,50,38,7,48,1,3,8,18,8,40,12,39,25,40,21,42,37,23,17,41,36,17,33,32,50,4,40,33,10,6,28,34,12,31,34,33,24,17,25,29,45,33,13,8,50,36,9,30,18,18,22,48,38,21,30,20,24,38,22,31,34,43,29,41,13,14,48,23,23,34,19,19,20,36,35,12,34,19,1,8,34,14,12,28,31,22,40,2,41,16,13,46,24,39,15,9,12,21,27,35,2,46,26,27,50,37,34,16,2,7,31,28,35,21,41,14,25,15,48,23,40,25,8,3,13,10,48,13,4,12,5,18,3,5,29,28,10,21,48,3,2,21,7,44,30,12,18,24,1,30,41,35,30,42,5,38,12,46,17,7,6,35,13,49,10,24,29,47,24,18,37,37,30,12,44,18,30,33,23,1,4,32,45,4,45,4,17,1,5,42,27,43,36,46,38,28,31,10,37,38,5,26,6,23,19,19,36,27,4,7,26,43,17,15,44,25,9,33,49,19,37,6,17,31,38,23,35,38,14,1,37,37,43,12,35,48,34,25,43,43,6,9,4,16,47,46,13,43,30,28,13,4,37,40,32,1,1,14,1,10,24,6,15,23,22,38,31,2,36,39,30,18,40,3,39,39,47,8,24,11,19,32,7,24,50,26,47,31,20,39,1,28,44,45,41,50,41,17,18,8,47,21,29,19,49,44,18,4,2,12,3,1,45,30,16,21,20,33,29,18,47,35,26,35,23,3,26,13,29,32,32,28,30,48,47,24,41,37,17,39,34,21,21,36,14,29,8,34,27,39,25,20,20,8,45,11,13,11,32,14,43,13,45,14,49,38,50,22,9,24,19,36,9,48,37,29,49,24,12,24,48,46,32,42,22,50,43,41,49,14,22,33,50,5,16,35,27,1,2,27,14,29,2,42,5,37,2,15,19,21,11,50,3,12,44,50,5,13,35,41,37,24,5,6,22,25,35,44,24,31,45,46,5,42,29,49,12,28,23,39,15,48,30,28,5,25,23,19,11,43,47,42,17,49,24,22,16,16,38,15,13,6,21,16,18,11,48,13,24,24,22,18,19,24,31,27,40,37,50,10,6,47,2,2,17,42,48,7,45,14,45,26,10,48,11,10,8,26,39,40,6,37,2,50,8,19,50,10,35,37,9,33,44,43,41,36,13,50,14,3,22,29,31,13,47,24,39,38,39,24,16,41,18,25,18,46,17,12,12,22,24,8,26,50,49,30,2,25,37,22,43,22,1,23,50,34,2,17,23,24,49,43,18,48,37,22,12,31,26,32,5,18,35,47,44,36,3,47,12,3,11,9,45,6,10,32,37,49,46,50,17,42,8,7,32,48,13,10,30,20,19,11,43,37,50,23,8,2,28,14,3,8,15,49,15,2,42,13,16,8,26,36,13,15,22,47,3,36,38,39,36,1,37,3,15,44,15,36,30,11,18,11,15,12,29,31,34,41,13,19,4,8,7,12,2,39,28,20,43,18,43,20,9,43,9,34,25,11,7,3,30,2,8,28,4,25,8,37,44,8,48,47,7,41,28,14,49,47,37,44,45,37,45,48,48,47,26,28,35,29,23,9,49,37,14,40,23,23,31,47,37,14,18,5,7,11,37,34,47,20,9,16,16,41,45,35,34,29,8,25,42,4,29,10,24,11,33,48,19,15,6,22,6,47,33,46,23,2,1,9,6,2,47,8,33,11,3,48,24,24,29,22,40,33,39,44,6,23,25,2,7,12,5,20,42,3,23,4,26,18,37,48,14,27,42,38,34,31,16,4,34,5,25,17,26,3,43,37,34,2,1,4,22,32,4,27,39,24,28,31,28,7,43,13,7,46,37,42,6,14,36,6,8,37,11,49,44,46,41,22,31,12,22,1,6,3,5,10,24,24,47,46,42,50,32,50,21,46,1,3,18,11,23,43,40,3,5,11,25,24,3,48,34,49,34,26,29,5,3,19,46,14,22,10,47,44,21,35,18,42,29,7,26,9,23,30,27,34,22,5,6,41,7,14,22,15,27,22,1,20,35,28,34,31,48,48,6,26,50,25,23,44,38,32,23,45,45,27,5,8,13,30,40,38,48,14,1,14,30,28,9,42,25,43,44,23,21,2,12,15,30,48,13,49,9,50,9,33,34,47,23,11,48,20,34,50,30,44,15,20,33,42,25,50,21,27,46,32,44,18,25,7,34,40,48,35,18,23,1,49,34,40,30,1,32,34,19,45,39,44,24,35,7,31,48,34,23,46,34,29,26,25,19,39,23,48,20,17,33,23,46,20,31,25,8,15,19,8,18,37,13,36,48,40,48,8,39,28,20,39,19,46,28,34,43,20,45,25,10,20,31,32,32,37,50,1,9,43,23,17,42,23,14,38,18,19,28,27,21,43,16,24,25,43,35,42,36,45,10,45,23,37,20,2,18,27,18,37,24,4,32,13,21,50,23,13,13,34,23,20,6,37,28,7,46,42,29,20,31,27,34,29,12,31,7,43,23,21,7,43,15,27,27,31,38,10,30,17,38,9,15,9,41,42,9,41,8,43,46,33,37,43,21,1,44,14,25,41,38,32,30,14,29,39,17,34,32,39,39,39,36,5,39,31,19,3,2,30,5,50,10,32,43,32,8,24,25,39,38,21,17,1,41,4,31,8,46,3,29,3,31,41,8,14,16,26,12,7,35,34,22,3,22,7,29,11,45,48,15,4,2,23,31,41,6,36,15,9,24,2,25,21,12,23,7,49,34,17,33,29,29,24,45,34,10,46,39,1,32,4,13,15,30,2,36,3,44,20,47,18,44,13,35,40,25,17,1,21,43,16,19,33,2,41,6,4,16,40,2,30,7,12,38,30,8,18,11,2,4,24,2,23,39,13,32,14,11,45,23,32,38,4,46,27,33,35,44,50,48,15,25,17,23,39,14,18,6,3,48,25,2,13,46,25,35,39,17,26,29,29,22,23,26,33,2,31,50,45,40,41,36,5,27,36,18,34,16,34,34,32,26,44,6,10,50,20,6,18,31,20,37,32,4,7,41,17,41,17,26,11,49,14,44,19,12,22,23,34,44,12,11,9,21,34,33,39,26,11,1,8,14,2,43,1,45,42,46,25,35,10,43,3,47,26,34,32,25,5,24,30,9,41,25,20,13,50,13,5,28,3,15,26,7,42,23,8,17,47,35,42,33,25,9,32,6,22,6,5,49,22,25,17,9,15,23,3,43,19,29,18,39,8,6,39,6,40,9,8,31,1,33,50,26,11,47,6,21,24,20,37,41,30,47,33,50,25,49,41,33,20,1,23,16,30,34,17,32,47,31,45,9,6,50,40,21,29,42,17,19,43,12,31,14,6,47,45,17,4,12,1,43,48,40,20,18,11,3,8,10,17,28,40,41,31,37,23,32,29,4,25,39,22,39,31,20,33,29,9,14,4,2,1,14,32,43,45,7,48,29,33,26,19,33,40,18,15,3,27,39,14,38,13,25,46,6,35,7,6,45,31,17,3,45,37,40,48,23,43,20,5,16,19,17,5,8,21,17,30,36,23,46,11,43,50,47,10,28,19,20,3,38,17,43,41,21,24,15,10,23,50,17,35,27,33,1,2,10,24,17,31,31,42,47,37,50,34,38,1,21,34,1,19,40,48,22,8,3,6,27,29,35,2,21,17,25,2,8,38,36,14,23,42,23,8,30,44,5,49,26,20,50,9,39,47,3,17,17,46,45,11,13,38,21,32,13,33,32,30,46,22,44,50,32,42,12,34,20);
        List<Integer> actualResult = integerListPreparer.prepareIntegersList(input, " ");
        assertEquals(expectedResult, actualResult);
    }

}