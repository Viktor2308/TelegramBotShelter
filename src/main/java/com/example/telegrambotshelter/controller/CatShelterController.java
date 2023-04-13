package com.example.telegrambotshelter.controller;

import com.example.telegrambotshelter.entity.Cat;
import com.example.telegrambotshelter.service.repositoryServiceImpl.CatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cat")
public class CatShelterController {

    private final CatService catService;

    public CatShelterController(CatService catShelterApiService) {
        this.catService = catShelterApiService;
    }

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get a cat object by ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation success", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Cat.class))),
            @ApiResponse(responseCode = "400", description = "The GET request parameters are either missing or invalid.")})
    public Cat getById(@Parameter(description = "Cat ID") @PathVariable long id) {
        return catService.get(id);
    }

}


