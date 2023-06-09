package com.example.telegrambotshelter.controller;

import com.example.telegrambotshelter.db.entity.Cat;
import com.example.telegrambotshelter.dto.CatCreationDTO;
import com.example.telegrambotshelter.dto.CatDTO;
import com.example.telegrambotshelter.service.controllerService.CatShelterControllerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping
@AllArgsConstructor
@Tag(name = "API fo cat shelter")
public class CatShelterController {

    private final CatShelterControllerService controllerService;

    @GetMapping("/api/cat/{id}")
    @Operation(summary = "Get a cat by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation success", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CatDTO.class))),
            @ApiResponse(responseCode = "404", description = "Cat with id not found", content = @Content)})
    public CatDTO getById(@Parameter(description = "Cat ID") @PathVariable long id) {
        log.info("Get cat request, received: {}", id);
        return controllerService.getById(id);
    }

    @PostMapping("/api/cat/")
    @Operation(summary = "Create Cat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Cat.class))),
            @ApiResponse(responseCode = "400", description = "Not Found", content = @Content)})
    public CatDTO createCat(@RequestBody @Valid CatCreationDTO catCreationDTO) {
        log.info("Create cat request received: {}", catCreationDTO);
        return controllerService.create(catCreationDTO);
    }

    @PutMapping("/api/cat/")
    @Operation(summary = "Update Cat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Cat.class))),
            @ApiResponse(responseCode = "400", description = "Not Found", content = @Content)})
    public CatDTO updateCat(@RequestBody long id ,@RequestBody @Valid CatCreationDTO catDTO) {
        log.info("Update cat id:{} request received: {}",id, catDTO);
        return controllerService.update(id,catDTO);
    }

    @DeleteMapping("/api/cat/{id}")
    @Operation(summary = "Delete Cat by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Cat.class))),
            @ApiResponse(responseCode = "400", description = "Not Found", content = @Content)})
    public CatDTO deleteCat(@Parameter(description = "Cat ID") @PathVariable long id) {
        log.info("Delete cat by id: {}", id);
        return controllerService.delete(id);
    }

    @GetMapping("/api/cat/")
    @Operation(summary = "Get all a cat")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation success", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = CatDTO.class))),
            @ApiResponse(responseCode = "404", description = "Cat with id not found", content = @Content)})
    public List<CatDTO> getById() {
        log.info("Get all cat request");
        return controllerService.getAll();
    }
}


