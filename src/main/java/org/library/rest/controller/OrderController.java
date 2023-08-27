package org.library.rest.controller;

import org.library.rest.dto.OrderDTO;
import org.library.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping()
    public ResponseEntity<OrderDTO> create(@RequestBody OrderDTO dto){
        return  ResponseEntity.ok(orderService.create(dto));
    }

    @GetMapping()
    public ResponseEntity<List<OrderDTO>> getAllOrders(){
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("id/{id}")
    public ResponseEntity<OrderDTO> getById(@PathVariable("id") UUID id){
        return ResponseEntity.ok(orderService.getById(id));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OrderDTO>> getByUserId(@PathVariable("userId") UUID userId){
        return ResponseEntity.ok(orderService.getByUserId(userId));
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<OrderDTO>> getOrdersByAuthor(@PathVariable("author") String author){
        return ResponseEntity.ok(orderService.getByAuthor(author));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<OrderDTO>> getOrdersByTitle(@PathVariable("title") String title){
        return ResponseEntity.ok(orderService.getByTitle(title));
    }






}
