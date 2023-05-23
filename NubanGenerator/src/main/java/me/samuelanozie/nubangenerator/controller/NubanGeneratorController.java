package me.samuelanozie.nubangenerator.controller;

import me.samuelanozie.nubangenerator.model.NubanModel;
import me.samuelanozie.nubangenerator.repository.NubanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static me.samuelanozie.nubangenerator.service.Nuban.generateNewNuban;
import static me.samuelanozie.nubangenerator.service.Nuban.padNumber;


@RestController
@RequestMapping("/api")
public class NubanGeneratorController {

    @Autowired
    private NubanRepository nubanRepository;

        // Get All Nuban Numbers
        @GetMapping("/nubans")
        @CrossOrigin(origins = "*")
        public List<NubanModel> getAllNubans() {
            return nubanRepository.findAll();
        }


        // Generate Nuban Number from Bank Code and Serial Number
        @PostMapping("/generate")
        @CrossOrigin(origins = "*")
        public NubanModel generateNuban(@RequestBody NubanModel nubanModel) {
            String bankCode = nubanModel.getBankCode();
            String serialNumber = nubanModel.getSerialNumber();

            // Check if bank code is 3 digits
            if(Integer.parseInt(bankCode) < 1 || Integer.parseInt(bankCode) > 999) {
                throw new IllegalArgumentException("Bank code must be greater than 0 and less than 4 digits");
            }

            // Check if serial number is greater than 0 and less than 1000000
            if (Integer.parseInt(serialNumber) < 1 || Integer.parseInt(serialNumber) > 999999999) {
                throw new IllegalArgumentException("Serial number must be greater than 0 and less than 10 digits");
            }

            bankCode = padNumber(bankCode, 3);  // Pad bank code to 3 digits

            serialNumber = padNumber(serialNumber, 9);  // Pad serial number to 9 digits
            String nubanNumber  = generateNewNuban(bankCode, serialNumber);
            return nubanRepository.save(new NubanModel(bankCode, serialNumber, nubanNumber));

        }
}
