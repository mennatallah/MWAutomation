package com.vodafone.hu.demo;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.ResponseOptions;
import com.jayway.restassured.specification.RequestSpecification;
import com.jayway.restassured.internal.ValidatableResponseImpl.*;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import com.vodafone.hu.demo.dto.StatusDto;
import com.fasterxml.jackson.core.JsonFactory;
import javafx.beans.binding.When;
import org.junit.After;
import org.junit.Before;
import org.junit.internal.requests.FilterRequest.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import io.restassured.response.Response;
import io.restassured.http.Method;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.web.client.HttpStatusCodeException;
import org.testng.Assert;
import org.testng.annotations.ITestAnnotation;
import static com.jayway.restassured.RestAssured.*;
import static org.codehaus.groovy.tools.shell.util.Logger.io;
import static org.hamcrest.Matchers.*;
import io.restassured.internal.http.HttpRequestFactory;
import io.restassured.exception.PathException.*;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.http.Status;
import com.jayway.restassured.matcher.ResponseAwareMatcher;
import com.jayway.restassured.response.ExtractableResponse;

import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;
import org.testng.annotations.*;

import java.security.Principal;
import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
@Value("${server.port}")
//int port;
int Code;
    @Autowired
    RestTemplate restTemplate;

    public DemoApplicationTests() {
       // RestAssured.port =port;
        RestAssured.baseURI = "https://sso.vodafone.hu/oam/server";
    }

    @Before
    public void inti() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<StatusDto> entity = new HttpEntity<StatusDto>(headers);
        StatusDto test = restTemplate.exchange(
                "https://jsonplaceholder.typicode.com/todos/1", HttpMethod.GET, entity, StatusDto.class).getBody();
    }

@Test
public void Getlogout(){
given().log().all().when()
        .get(baseURI + "/logout").then().statusCode(200).assertThat().body("", hasItems("html"));

    System.out.println(get(baseURI + "/logout").then().statusCode(200).assertThat());
}
@Test
public void PostLoginWithMSISDN(){

    RequestSpecification request = RestAssured.given();
    ResponseOptions responseOptions = null;
    JSONObject requestParams = new JSONObject();
    requestParams.put("username", "702734542");
    requestParams.put("password", "Voda1234");
    requestParams.put("operation", "authentication");
    requestParams.put("successurl", "https://mobilapp.vodafone.hu/services/login/loginSuccess");
 //   request.body(requestParams.toJSONArray());

//    responseOptions =
            given().log().all().header("Content-Type","application/x-www-form-urlencoded")
            .when().post(baseURI+"/authentication").then().assertThat().statusCode(200);
    System.out.println(responseOptions.getBody().toString());
//    responseOptions.thenReturn()
//                responseOptions.ass;


    System.out.println("");
    }


}

