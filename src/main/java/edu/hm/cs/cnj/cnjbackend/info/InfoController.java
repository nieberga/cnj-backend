package edu.hm.cs.cnj.cnjbackend.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/v1/info")
@Api
public class InfoController {

	@Autowired
	InfoProperties properties;

	@GetMapping
	@ApiOperation(value = "Show server information", response = Info.class)
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Server reachable") })
	public Info getInfo() {
		Info result = new Info();
		result.setMessage(properties.getMessage());
		return result;
	}
}
