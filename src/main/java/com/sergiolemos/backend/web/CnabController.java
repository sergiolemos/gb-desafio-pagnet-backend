package com.sergiolemos.backend.web;

import com.sergiolemos.backend.service.CnabService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("cnab")
public class CnabController {

    private final CnabService service;


    public CnabController(CnabService service) {
        this.service = service;
    }

    @PostMapping("upload")
    @CrossOrigin(origins = {"http://localhost:9090"})
    public String upload(@RequestParam("file") MultipartFile file) throws Exception {
        service.uploadCnabFile(file);
        return "Processamento iniciado";
    }

    @PostMapping("150/upload")
    public String upload150(@RequestParam("file") MultipartFile file) throws Exception {
        service.uploadCnab150File(file);
        return "Processamento iniciado";
    }
}
