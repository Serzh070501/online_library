package org.library.rest.controller;


import org.library.convertor.CardConvertor;
import org.library.rest.dto.CardDTO;
import org.library.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class CardController {

    @Autowired
    CardService cardService;



    @PostMapping("/")
    public ResponseEntity<CardDTO> addCard (@RequestBody CardDTO cardDTO){
        return ResponseEntity.ok(cardService.addCard(cardDTO));
    }

    @DeleteMapping(" ")
    public ResponseEntity<String> delete (@RequestBody CardDTO cardDTO){
        cardService.deleteCard(cardDTO);
        return ResponseEntity.ok("Book was deleted successfully");
    }
}
