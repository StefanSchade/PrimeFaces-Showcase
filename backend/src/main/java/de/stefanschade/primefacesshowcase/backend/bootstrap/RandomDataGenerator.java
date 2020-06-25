package de.stefanschade.primefacesshowcase.backend.bootstrap;

import de.stefanschade.primefacesshowcase.backend.dto.FieldType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Component
public class RandomDataGenerator {

    private final Random RANDOM = new SecureRandom();

    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

    private final int ITERATIONS = 1000;

    private final int KEY_LENGTH = 256;

    FieldType[] fieldTypes = FieldType.values();

    public FieldType[] getRandomFieldTypeArray(int length) {
        return getRandomFieldTypeList(length).toArray(new FieldType[length]);
    }

    public List<FieldType> getRandomFieldTypeList(int length) {
        return Stream
                .generate(() -> getRandomFieldType())
                .limit(length)
                .collect(Collectors.toList());
    }

    private FieldType getRandomFieldType() {
        return fieldTypes[RANDOM.nextInt(fieldTypes.length)];
    }

    public String[] getRandomStringArray(int lengthOfArray, int lengthOfEachString) {
        return getRandomStringList(lengthOfArray, lengthOfEachString).toArray(new String[0]);
    }

    public List<String> getRandomStringList(int lengthOfList, int lengthOfEachString) {
        return Stream
                .generate(() -> getRandomString(lengthOfEachString))
                .limit(lengthOfList)
                .collect(Collectors.toList());
    }

    public String getRandomString(int length) {
        return generateRandomString(length);
    }

    private String generateRandomString(int length) {
        return Stream
                .generate(() -> RANDOM.nextInt(ALPHABET.length()))
                .map(i -> ALPHABET.charAt(i))
                .map(Object::toString)
                .limit(length)
                .collect(Collectors.joining(""));
    }

    public int getRandomIntInRange(int from, int to) {
        if (to < from) {
            throw new IllegalArgumentException("to: " + to + " from: " + from);
        }
        return RANDOM.nextInt(to - from + 1) + from - 1;
    }
}