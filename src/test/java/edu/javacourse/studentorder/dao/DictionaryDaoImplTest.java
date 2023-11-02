package edu.javacourse.studentorder.dao;


import org.junit.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class DictionaryDaoImplTest {

    @BeforeClass
    public static void startUp() throws Exception {
        URL url1 = DictionaryDaoImplTest.class.getClassLoader()
                .getResource("student_project.sql");
        URL url2 = DictionaryDaoImplTest.class.getClassLoader()
                .getResource("student_data.sql");
        List<String> str1 = Files.readAllLines(Paths.get(url1.toURI()));
        String sql1 = str1.stream().collect(Collectors.joining());
        List<String> str2 = Files.readAllLines(Paths.get(url2.toURI()));
        String sql2 = str2.stream().collect(Collectors.joining());


        try (Connection con = ConnectionBuilder.getConnection();
             Statement stmt = con.createStatement()){

            stmt.executeUpdate(sql1);
            stmt.executeUpdate(sql2);



        }



    }

    @Test
    public void testExample1(){
        System.out.println("TEST 1");
    }

    @Test
    //@Ignore
    public void testExample2(){
        System.out.println("TEST 2");
    }

    @Test
    public void testExample3(){
        System.out.println("TEST 3");
//        throw new RuntimeException("BAD RESULT");
    }

}