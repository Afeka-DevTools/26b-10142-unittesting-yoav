package org.example;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void add_twoPositiveNumbers_returnsSum() {
        // Arrange
        int a = 5;
        int b = 7;

        // Act
        int result = App.add(a, b);

        // Assert
        assertEquals(12, result);
    }

    @Test
    void add_negativeAndPositive_returnsSum() {
        // Arrange
        int a = -3;
        int b = 10;

        // Act
        int result = App.add(a, b);

        // Assert
        assertEquals(7, result);
    }

    @Test
    void isPrime_negativeZeroOne_returnFalse() {
        // Arrange / Act & Assert
        assertFalse(App.isPrime(-5));
        assertFalse(App.isPrime(0));
        assertFalse(App.isPrime(1));
    }

    @Test
    void isPrime_smallPrimesAndNonPrimes() {
        // Arrange / Act & Assert
        assertTrue(App.isPrime(2));
        assertTrue(App.isPrime(3));
        assertFalse(App.isPrime(4));
        assertTrue(App.isPrime(29));
        assertFalse(App.isPrime(30));
    }

    @Test
    void reverse_null_throwsNullPointerException() {
        // Arrange
        String s = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> App.reverse(s));
    }

    @Test
    void reverse_emptyString_returnsEmpty() {
        // Arrange
        String s = "";

        // Act
        String r = App.reverse(s);

        // Assert
        assertEquals("", r);
    }

    @Test
    void reverse_regularString_returnsReversed() {
        // Arrange
        String s = "hello";

        // Act
        String r = App.reverse(s);

        // Assert
        assertEquals("olleh", r);
    }

    @Test
    void factorial_negative_throwsIllegalArgumentException() {
        // Arrange
        int n = -1;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> App.factorial(n));
    }

    @Test
    void factorial_baseCases_andFive() {
        // Arrange / Act & Assert
        assertEquals(1, App.factorial(0));
        assertEquals(1, App.factorial(1));
        assertEquals(120, App.factorial(5));
    }

    @Test
    void isPalindrome_null_throwsNullPointerException() {
        // Arrange
        String s = null;

        // Act & Assert
        assertThrows(NullPointerException.class, () -> App.isPalindrome(s));
    }

    @Test
    void isPalindrome_palindromicPhrases_true() {
        // Arrange
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "racecar";

        // Act & Assert
        assertTrue(App.isPalindrome(s1));
        assertTrue(App.isPalindrome(s2));
    }

    @Test
    void fibonacciUpTo_negative_throwsIllegalArgumentException() {
        // Arrange
        int n = -5;

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> App.fibonacciUpTo(n));
    }

    @Test
    void fibonacciUpTo_zeroOneAndTen_expectedSequences() {
        // Arrange / Act
        List<Integer> zero = App.fibonacciUpTo(0);
        List<Integer> one = App.fibonacciUpTo(1);
        List<Integer> ten = App.fibonacciUpTo(10);

        // Assert
        assertEquals(Arrays.asList(0), zero);
        assertEquals(Arrays.asList(0, 1, 1), one);
        assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5, 8), ten);
    }

    @Test
    void charFrequency_emptyString_returnsEmptyMap() {
        // Arrange
        String input = "";

        // Act
        Map<Character, Integer> result = App.charFrequency(input);

        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    void charFrequency_sampleString_countsCorrectly() {
        // Arrange
        String input = "aabbc!";

        // Act
        Map<Character, Integer> freq = App.charFrequency(input);

        // Assert
        assertEquals(2, freq.get('a'));
        assertEquals(2, freq.get('b'));
        assertEquals(1, freq.get('c'));
        assertEquals(1, freq.get('!'));
    }

    @Test
    void isAnagram_nulls_throwsNullPointerException() {
        // Arrange
        String s1 = null;
        String s2 = "abc";

        // Act & Assert
        assertThrows(NullPointerException.class, () -> App.isAnagram(s1, s2));
        assertThrows(NullPointerException.class, () -> App.isAnagram(s2, null));
    }

    @Test
    void isAnagram_anagramsAndNonAnagrams() {
        // Arrange / Act & Assert
        assertTrue(App.isAnagram("Listen", "Silent"));
        assertTrue(App.isAnagram("123 ab", "b a 321"));
        assertFalse(App.isAnagram("hello", "world"));
    }

    @Test
    void average_emptyArray_throwsIllegalArgumentException() {
        // Arrange
        int[] arr = new int[0];

        // Act & Assert
        assertThrows(IllegalArgumentException.class, () -> App.average(arr));
    }

    @Test
    void average_values_returnCorrectAverage() {
        // Arrange
        int[] arr = {2, 3, 5};

        // Act
        double avg = App.average(arr);

        // Assert
        assertEquals(10.0/3.0, avg, 1e-9);
    }

    @Test
    void filterEvens_emptyList_returnsEmptyList() {
        // Arrange
        List<Integer> input = Collections.emptyList();

        // Act
        List<Integer> evens = App.filterEvens(input);

        // Assert
        assertTrue(evens.isEmpty());
    }

    @Test
    void filterEvens_mixedList_returnsOnlyEvens() {
        // Arrange
        List<Integer> input = Arrays.asList(1, 2, 3, 4, -6, 0);

        // Act
        List<Integer> evens = App.filterEvens(input);

        // Assert
        assertEquals(Arrays.asList(2, 4, -6, 0), evens);
    }

    @Test
    void mostCommonWord_regularText_returnsMostFrequent() {
        // Arrange
        String text = "apple banana apple orange banana apple";

        // Act
        String most = App.mostCommonWord(text);

        // Assert
        assertEquals("apple", most);
    }

}