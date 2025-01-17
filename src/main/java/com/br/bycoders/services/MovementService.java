package com.br.bycoders.services;

import com.br.bycoders.dtos.MovementDto;
import com.br.bycoders.dtos.TotalizerMovementDto;
import com.br.bycoders.models.Movement;
import com.br.bycoders.repositorys.MovementRepository;
import com.br.bycoders.util.FileUploadUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovementService {
    @Autowired
    private MovementRepository repository;

    public TotalizerMovementDto findAll(String name) {
        List<Movement> movementList = getMovementList(name);
        List<MovementDto> movementListDto = movementList.stream().map(MovementDto::new).collect(Collectors.toList());
        return new TotalizerMovementDto(movementListDto);
    }

    private List<Movement> getMovementList(String name) {
        if (name == null || name.isEmpty())  return repository.findAll();
        else  return repository.findByStore(name.trim());
    }

    public MovementDto create(MultipartFile file) throws IOException {
        List<Movement> Movement = FileUploadUtil.create(file);
        repository.saveAll(Movement);

        MovementDto movementDto = new MovementDto();
        BeanUtils.copyProperties(Movement, movementDto);
        return movementDto;
    }
}

