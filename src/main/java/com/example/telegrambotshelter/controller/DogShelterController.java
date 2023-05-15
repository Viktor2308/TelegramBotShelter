package com.example.telegrambotshelter.controller;

import com.example.telegrambotshelter.db.entity.Dog;
import com.example.telegrambotshelter.dto.DogCreationDTO;
import com.example.telegrambotshelter.dto.DogDTO;
import com.example.telegrambotshelter.service.controllerService.DogShelterControllerService;
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
@Tag(name = "API fo dog shelter")
public class DogShelterController {

    private final DogShelterControllerService controllerService;

    @GetMapping("/api/dog/{id}")
    @Operation(summary = "Get a dog by ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation success", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = DogDTO.class))),
            @ApiResponse(responseCode = "404", description = "Cat with id not found", content = @Content)})
    public DogDTO getById(@Parameter(description = "Dog ID") @PathVariable long id) {
        log.info("Get dog request, received: {}", id);
        return controllerService.getById(id);
    }

    @PostMapping("/api/dog/")
    @Operation(summary = "Create Dog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Dog.class))),
            @ApiResponse(responseCode = "400", description = "Not Found", content = @Content)})
    public DogDTO createDog(@RequestBody @Valid DogCreationDTO dogCreationDTO) {
        log.info("Create dog request received: {}", dogCreationDTO);
        return controllerService.create(dogCreationDTO);
    }

    @PutMapping("/api/dog/")
    @Operation(summary = "Update Dog")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Dog.class))),
            @ApiResponse(responseCode = "400", description = "Not Found", content = @Content)})
    public DogDTO updateDog(@RequestBody long id ,@RequestBody @Valid DogCreationDTO dogDTO) {
        log.info("Update Dog id:{} request received: {}",id, dogDTO);
        return controllerService.update(id,dogDTO);
    }

    @DeleteMapping("/api/dog/{id}")
    @Operation(summary = "Delete Dog by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful Operation", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = Dog.class))),
            @ApiResponse(responseCode = "400", description = "Not Found", content = @Content)})
    public DogDTO deleteDog(@Parameter(description = "Dog ID") @PathVariable long id) {
        log.info("Delete dog by id: {}", id);
        return controllerService.delete(id);
    }

    @GetMapping("/api/dog/")
    @Operation(summary = "Get all a dogt")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation success", content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = DogDTO.class))),
            @ApiResponse(responseCode = "404", description = "Dog with id not found", content = @Content)})
    public List<DogDTO> getById() {
        log.info("Get all dog request");
        return controllerService.getAll();
    }
}
