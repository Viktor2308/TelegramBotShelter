package com.example.telegrambotshelter.service.controllerService;

import com.example.telegrambotshelter.db.DAO.DogDAOImpl;
import com.example.telegrambotshelter.dto.DogCreationDTO;
import com.example.telegrambotshelter.dto.DogDTO;
import com.example.telegrambotshelter.mappers.DogMapper;
import com.example.telegrambotshelter.service.ControllerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class DogShelterControllerService implements ControllerService<DogDTO, DogCreationDTO> {

    private final DogDAOImpl dogDAO;
    private final DogMapper mapper;


    @Override
    public DogDTO getById(long id) {
        return mapper.toDTO(dogDAO.getById(id));
    }

    @Override
    public DogDTO create(DogCreationDTO dogCreationDTO) {
        return mapper.toDTO(
                dogDAO.add(mapper.fromDTO(dogCreationDTO)));
    }

    @Override
    public DogDTO update(long id, DogCreationDTO dogDTO) {
        return mapper.toDTO(
                dogDAO.update(mapper.fromDTO(dogDTO), id));
    }

    @Override
    public List<DogDTO> getAll() {
        return dogDAO.getAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public DogDTO delete(long id) {
        DogDTO dogDTO = mapper.toDTO(dogDAO.getById(id));
        dogDAO.delete(id);
        return dogDTO;
    }
}
