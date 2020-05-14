package com.example.demo;


import com.example.demo.model.Cidade;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameTranslateMappingStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {



		SpringApplication.run(DemoApplication.class, args);

		/*Pattern pattern = Pattern.compile(",");
		String filename = "doc\BackEnd.csv";

		try (BufferedReader in = new BufferedReader(new FileReader(filename));) {
			List<Cidade> cidades = in .lines() .skip(1) .map(line -> {
				String[] x = pattern.split(line);
				return new Cidade (x[0], x[1], x[2], x[3], x[4], x[5], x[6], x[7], x[8], x[9] ); }) .collect(Collectors.toList());

			ObjectMapper mapper = new ObjectMapper();
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			mapper.writeValue(System.out, cidades);

		} catch (JsonGenerationException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}*/

	}

}
