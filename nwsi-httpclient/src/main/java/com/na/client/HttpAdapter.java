package com.na.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.codehaus.jackson.map.ObjectMapper;

import com.newtonapples.domain.Response;
import com.newtonapples.domain.Student;

public class HttpAdapter {
	
	public Response getResponse(String url, String json){
		Response response = new Response();
		try{
			HttpClient httpClient = new DefaultHttpClient();
			HttpGet get = new HttpGet(url);
			HttpResponse httpResponse = httpClient.execute(get);
			BufferedReader br = new BufferedReader(new InputStreamReader(httpResponse.getEntity().getContent()));
			
			String responseString = br.readLine();
			ObjectMapper mapper = new ObjectMapper();
			response = mapper.readValue(responseString, Response.class);
			
		} catch(Exception e){
			e.printStackTrace();
		}
		return response;
	}
	
	public static void main(String[] args) {
		try{
			HttpAdapter adapter = new HttpAdapter();
			Response request = new Response();
			ObjectMapper mapper = new ObjectMapper();
			String jsonRequest = mapper.writeValueAsString(request);
			Response response = adapter.getResponse("http://localhost:8080/getStudentInfo", jsonRequest); 
			List<Student> studentsList = response.getStudentsList();
			for(Student student : studentsList){
				System.out.println("Name: "+student.getName());
				System.out.println("Batch: "+student.getBatchNo());
			}
 		} catch(Exception e){
			e.printStackTrace();
		}
	}

}
