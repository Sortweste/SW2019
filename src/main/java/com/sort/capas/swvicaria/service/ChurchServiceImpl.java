package com.sort.capas.swvicaria.service;

import com.sort.capas.swvicaria.domain.Church;
import com.sort.capas.swvicaria.repository.IChurchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
public class ChurchServiceImpl implements IChurchService {

    @Autowired
    IChurchRepository churchRepository;

    @Override
    public List<Church> findAll() {
        return churchRepository.findAll();
    }

    @Override
    public Church findChurchById(Long id) {
        return churchRepository.findChurchById(id);
    }


    @Override
    @Transactional
    public Church save(Church church, MultipartFile foto) {
        Church iglesia = new Church();
        if(!foto.isEmpty()){
            Path dirRec = Paths.get("C://Temp//uploads");
            String rootPath = dirRec.toFile().getAbsolutePath();
            try {
                byte[] bytes = foto.getBytes();
                Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
                Files.write(rutaCompleta, bytes);
                iglesia.setImg(foto.getOriginalFilename());
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        iglesia.setName(church.getName());
        iglesia.setHistory(church.getHistory());
        iglesia.setAddress(church.getAddress());
        return churchRepository.save(iglesia);
    }

    @Override
    public Church saveE(Church church, MultipartFile foto) {
        Church iglesia=churchRepository.findChurchById(church.getId());
        if(!foto.isEmpty()){
            Path dirRec = Paths.get("C://Temp//uploads");
            String rootPath = dirRec.toFile().getAbsolutePath();
            try {
                byte[] bytes = foto.getBytes();
                Path rutaCompleta = Paths.get(rootPath + "//" + foto.getOriginalFilename());
                Files.write(rutaCompleta, bytes);
                iglesia.setImg(foto.getOriginalFilename());
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        iglesia.setName(church.getName());
        iglesia.setHistory(church.getHistory());
        iglesia.setAddress(church.getAddress());
        return churchRepository.saveAndFlush(iglesia);
    }
}
