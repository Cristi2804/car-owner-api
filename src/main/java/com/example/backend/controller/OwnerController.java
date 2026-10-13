package com.example.backend.controller;
import com.example.backend.service.OwnerService;
import com.example.backend.model.Owner;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @PostMapping
    public Owner createOwner(@RequestBody Owner owner) {
        return ownerService.createOwner(owner);
    }
}
