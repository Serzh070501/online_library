package org.library.rest.controller;


import org.library.convertor.CardConvertor;
import org.library.rest.dto.CardDTO;
import org.library.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cards")
public class CardController {

    @Autowired
    CardService cardService;

    @PostMapping()
    public ResponseEntity<CardDTO> addCard(@RequestBody CardDTO cardDTO){
        return ResponseEntity.ok(cardService.addCard(cardDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id){
        cardService.deleteById(id);
        return ResponseEntity.ok("Book was deleted successfully");
    }

    @GetMapping
    public ResponseEntity<CardDTO> getById(@RequestParam("id") Long id){
       return ResponseEntity.ok(cardService.getById(id));
    }
}
