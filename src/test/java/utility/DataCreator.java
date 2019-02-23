package utility;

import lombok.Data;
import org.apache.commons.lang3.RandomStringUtils;
import org.aspectj.lang.annotation.DeclareAnnotation;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Data
public class DataCreator {

    public static String createRandomString(){
        Random random =new Random();

        StringBuilder randomLetter = new StringBuilder();
        for (int i = 0; i <5 ; i++) {
            char c = (char)(random.nextInt(25) + 'a');
            randomLetter.append(c);
            randomLetter.append(random.nextInt(9));
        }
        return  randomLetter.toString();
    }
}
