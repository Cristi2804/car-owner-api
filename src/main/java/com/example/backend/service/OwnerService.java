package com.example.backend.service;
import com.example.backend.repository.CarRepository;
import com.example.backend.repository.OwnerRepository;
import com.example.backend.model.Owner;
import org.springframework.stereotype.Service;


@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;
    public OwnerService(OwnerRepository ownerRepository){
        this.ownerRepository=ownerRepository;
    }
    public Owner createOwner(Owner owner){
        return ownerRepository.save(owner);
    }

}
