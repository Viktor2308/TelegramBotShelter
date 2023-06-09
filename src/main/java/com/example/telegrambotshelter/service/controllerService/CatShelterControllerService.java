package com.example.telegrambotshelter.service.controllerService;

import com.example.telegrambotshelter.db.DAO.CatDAOImpl;
import com.example.telegrambotshelter.dto.CatDTO;
import com.example.telegrambotshelter.dto.CatCreationDTO;
import com.example.telegrambotshelter.mappers.CatMapper;
import com.example.telegrambotshelter.service.ControllerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CatShelterControllerService implements ControllerService<CatDTO, CatCreationDTO> {

    private final CatDAOImpl catDAO;
    private final CatMapper mapper;


    @Override
    public CatDTO getById(long id) {
        return mapper.toDTO(catDAO.getById(id));
    }

    @Override
    public CatDTO create(CatCreationDTO catCreationDTO) {
        return mapper.toDTO(
                catDAO.add(mapper.fromDTO(catCreationDTO)));
    }

    @Override
    public CatDTO update(long id, CatCreationDTO catDTO) {
        return mapper.toDTO(
                catDAO.update(mapper.fromDTO(catDTO), id));
    }

    @Override
    public List<CatDTO> getAll() {
        return catDAO.getAll().stream().map(mapper::toDTO).toList();
    }

    @Override
    public CatDTO delete(long id) {
        CatDTO catDTO = mapper.toDTO(catDAO.getById(id));
        catDAO.delete(id);
        return catDTO;
    }
}
