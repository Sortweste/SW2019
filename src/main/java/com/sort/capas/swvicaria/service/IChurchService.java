package com.sort.capas.swvicaria.service;

import com.sort.capas.swvicaria.domain.Church;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

//Servicio de iglesia
public interface IChurchService {
    List<Church> findAll();
    Church findChurchById(Long id);
    Church save(Church church, MultipartFile foto);
    Church edit(Church church, MultipartFile foto, String current);
}
