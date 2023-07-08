package com.saber.hellorest.controllers;

import com.saber.hellorest.dto.ErrorResponse;
import com.saber.hellorest.dto.MessageResponseDto;
import com.saber.hellorest.services.HelloService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "${service.api.base-path}", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "${spring.application.name}", description = "${spring.application.name}")

public class MessageController {

    @Qualifier(value = "helloService")
    @Autowired
    private HelloService helloService;

    @Qualifier(value = "camelService")
    @Autowired
    private HelloService camelService;


    @GetMapping(value = "/sayHello")
    @Operation(tags = {"sayHello"}, summary = "sayHello", description = "sayHello api", method = "GET",
            parameters = {
                    @Parameter(name = "firstName", in = ParameterIn.QUERY, required = true, example = "saber", description = "firstName"),
                    @Parameter(name = "lastName", in = ParameterIn.QUERY, required = true, example = "Azizi", description = "lastName"),
            })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "406", description = "NOT_ACCEPTABLE",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "401", description = "NOT_ACCEPTABLE",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "NOT_ACCEPTABLE",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "504", description = "NOT_ACCEPTABLE",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),

    })
    public ResponseEntity<MessageResponseDto> sayHello(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        return ResponseEntity.ok(this.helloService.sayHello(firstName, lastName));
    }

    @GetMapping(value = "/sayBye")
    @Operation(tags = {"sayBye"}, summary = "sayBye", description = "sayBye api", method = "GET",
            parameters = {
                    @Parameter(name = "firstName", in = ParameterIn.QUERY, required = true, example = "saber", description = "firstName"),
                    @Parameter(name = "lastName", in = ParameterIn.QUERY, required = true, example = "Azizi", description = "lastName"),
            })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "406", description = "NOT_ACCEPTABLE",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "401", description = "NOT_ACCEPTABLE",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "NOT_ACCEPTABLE",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "504", description = "NOT_ACCEPTABLE",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),

    })
    public ResponseEntity<MessageResponseDto> sayBye(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        return ResponseEntity.ok(this.helloService.sayBye(firstName, lastName));
    }

    @GetMapping(value = "/sayHello/camel")
    @Operation(tags = {"sayHelloCamel"}, summary = "sayHelloCamel", description = "sayHelloCamel api", method = "GET",
            parameters = {
                    @Parameter(name = "firstName", in = ParameterIn.QUERY, required = true, example = "saber", description = "firstName"),
                    @Parameter(name = "lastName", in = ParameterIn.QUERY, required = true, example = "Azizi", description = "lastName"),
            })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "406", description = "NOT_ACCEPTABLE",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "401", description = "NOT_ACCEPTABLE",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "NOT_ACCEPTABLE",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "504", description = "NOT_ACCEPTABLE",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),

    })
    public ResponseEntity<MessageResponseDto> sayHelloCamel(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        return ResponseEntity.ok(this.camelService.sayHello(firstName, lastName));
    }


    @GetMapping(value = "/sayBye/camel")
    @Operation(tags = {"sayByeCamel"}, summary = "sayByeCamel", description = "sayByeCamel api", method = "GET",
            parameters = {
                    @Parameter(name = "firstName", in = ParameterIn.QUERY, required = true, example = "saber", description = "firstName"),
                    @Parameter(name = "lastName", in = ParameterIn.QUERY, required = true, example = "Azizi", description = "lastName"),
            })
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Success",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = MessageResponseDto.class))}),
            @ApiResponse(responseCode = "400", description = "BAD_REQUEST",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "406", description = "NOT_ACCEPTABLE",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "401", description = "NOT_ACCEPTABLE",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "NOT_ACCEPTABLE",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "504", description = "NOT_ACCEPTABLE",
                    content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),

    })
    public ResponseEntity<MessageResponseDto> sayByeCamel(@RequestParam(required = false) String firstName, @RequestParam(required = false) String lastName) {
        return ResponseEntity.ok(this.camelService.sayBye(firstName, lastName));
    }
}
