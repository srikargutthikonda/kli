package bkp_code;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

public class ListToJson {
public static void main(String[] args) throws JsonProcessingException {
	
	List<Student> li=new ArrayList<Student>();
	Student s1=new Student("aaa","aaa");
	Student s2=new Student("bbb","bb");
	li.add(s1);
	li.add(s2);
	ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
	String json = ow.writeValueAsString(li);
    System.out.println(json);
}
}
