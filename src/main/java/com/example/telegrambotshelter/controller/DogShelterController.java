package com.example.telegrambotshelter.controller;

import com.example.telegrambotshelter.db.entity.Dog;
import com.example.telegrambotshelter.db.DAO.DogDAOImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dog")
@Tag(name = "API fo dog shelter")
public class DogShelterController {

    private final DogDAOImpl dogDAOImpl;

    public DogShelterController(DogDAOImpl dogShelterApiService) {
        this.dogDAOImpl = dogShelterApiService;
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a dog object by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation success", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Dog.class))),
            @ApiResponse(responseCode = "400", description = "The GET request parameters are either missing or invalid.")})
    public ResponseEntity<?> getById(@Parameter(description = "Dog ID") @PathVariable long id) {
        return null;
    }



}
