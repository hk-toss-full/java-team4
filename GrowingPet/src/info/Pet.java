package info;

import java.util.Arrays;
import java.util.Random;

public class Pet {
    Random rand = new Random();

    private static Pet pet;
    private final String[] types = {"푸들", "포메라니안", "시츄"};
    private final String type;
    private final String name;
    private static final int MAX_NAME_LENGTH = 11;
    private static final String VALIDATE_NAME_LENGTH_ERROR_MESSAGE = "이름은 최대 10글자 입니다. 다시 실행하여주세요.";

    public static Pet getInstance(String name) {
        if (pet == null) {
            pet = new Pet(name);
        }
        return pet;
    }

    private Pet(String name) {
        validateLength(name);
        this.type = createType();
        this.name = name;
    }

    private void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(VALIDATE_NAME_LENGTH_ERROR_MESSAGE);
        }
    }

    private String createType() {
        int num = rand.nextInt(3);
        return types[num];
    }

    @Override
    public String toString() {
        return "Pet{" + "rand=" + rand + ", types=" + Arrays.toString(types) + ", type='" + type + '\'' + ", name='"
                + name + '\'' + '}';
    }

    public static Pet getPet() {
        return pet;
    }
}