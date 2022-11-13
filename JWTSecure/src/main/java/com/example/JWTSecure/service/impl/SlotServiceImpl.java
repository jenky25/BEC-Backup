package com.example.JWTSecure.service.impl;

import com.example.JWTSecure.domain.Slot;
import com.example.JWTSecure.repo.SlotRepo;
import com.example.JWTSecure.service.SlotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class SlotServiceImpl implements SlotService {

    private final SlotRepo slotRepo;

    @Override
    public List<Slot> getSlot() {
        try{
            return slotRepo.findAll();
        }catch (Exception e){
            return null;
        }
    }
}
