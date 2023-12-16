package brokers.weather;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.internal.mapping.GsonMapper;

public class Person {
    String name;
    String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public static void main(String[] args) throws JsonProcessingException {
        String json = "{\"name\":\"artur\",\"age\":\"29\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue(json,Person.class);
        System.out.println("name: "+person.getName());


    }
}
