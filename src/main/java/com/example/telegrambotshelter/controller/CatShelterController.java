package com.example.telegrambotshelter.controller;

import com.example.telegrambotshelter.dto.CatCreationDTO;
import com.example.telegrambotshelter.dto.CatDTO;
import com.example.telegrambotshelter.service.controllerService.CatShelterControllerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/cat")
@AllArgsConstructor
public class CatShelterController {

    private final CatShelterControllerService controllerService;

    @GetMapping(value = "/{id}")
    @Operation(summary = "Get a cat by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation success", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CatDTO.class))),
            @ApiResponse(responseCode = "404", description = "Not Found.", content = @Content)})
    public CatDTO getById(@Parameter(description = "Cat ID") @PathVariable long id) {
        log.info("Get cat request, received: {}", id);
        return controllerService.getById(id);
    }

    @PostMapping("/cat")
    @Operation(summary = "Create Cat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Successful Operation", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CatCreationDTO.class))),
            @ApiResponse(responseCode = "400", description = "Not Found", content = @Content)})
    public CatDTO createUser(@RequestBody @Valid CatCreationDTO catCreationDTO) {
        log.info("Create user request received: {}", catCreationDTO);
        return controllerService.create(catCreationDTO);
    }
}


