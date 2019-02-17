package com.javatechie.rest.api.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.javatechie.rest.api.common.Response;

@RestController
public class ConsumeRestController {

	@Autowired
	private RestTemplate template;

	@GetMapping("/getAPI/{I}/{q}")
	public Response getRecipepuppy(@PathVariable String I, @PathVariable String q) throws IOException {
		ObjectMapper mapper = new ObjectMapper();

		Map<String, String> params = new HashMap<>();
		params.put("I", I);
		params.put("q", q);
		String url = "http://www.recipepuppy.com/api/?%s";

		String parametrizedArgs = params.keySet().stream().map(k -> String.format("%s={%s}", k, k))
				.collect(Collectors.joining("&"));
		String result = template.getForObject(String.format(url, parametrizedArgs), String.class, params);
		Response response = mapper.readValue(result, Response.class);
		return response;
	}

}
