package de.stefanschade.primefacesshowcase.backend.bootstrap;

import de.stefanschade.primefacesshowcase.backend.dto.FieldType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Slf4j
@Component
public class RandomDataGenerator {

    private final Random RANDOM = new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private final int ITERATIONS = 1000;
    private final int KEY_LENGTH = 256;
    FieldType[] fieldTypes = FieldType.values();

    public String getRandomString(int length) {
        return generateRandomString(length);
    }

    public FieldType[] getRandomFieldTypeArray(int length) {
        FieldType[] returnValue = new FieldType[length];
        for (int i = 0; i < length; i++) {
            returnValue[i] = getRandomFieldType();
        }
        return returnValue;
    }

    public String[] getRandomStringArray(int lengthOfArray, int lengthOfEachString) {
        String[] returnValue = new String[lengthOfArray];
        for (int i = 0; i < lengthOfArray; i++) {
            returnValue[i] = getRandomString(lengthOfEachString);
        }

        for (int i = 0;i<lengthOfArray;i++) {
            log.info("String Array: Field #" + i + ": " + returnValue[i]);
        }

        return returnValue;
    }

    private FieldType getRandomFieldType() {
        int pick = RANDOM.nextInt(fieldTypes.length);
        return fieldTypes[pick];
    }

    private String generateRandomString(int length) {
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }

    public int getRandomIntInRange(int from, int to) {
        if (to == from) {
            return to;
        } else if (to < from) {
            throw new IllegalArgumentException("to: " + to + " from: " + from);
        } else {
            int rangelength = to - from;
            return RANDOM.nextInt(rangelength) + from;
        }
    }
}