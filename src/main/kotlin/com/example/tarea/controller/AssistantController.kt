package com.example.tarea.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*
import com.example.tarea.model.Assistant
import com.example.tarea.service.AssistantService


@RestController
@RequestMapping("/assistant")
class AssistantController {
    @Autowired
    lateinit var assistantService: AssistantService
    @GetMapping
    fun list ():List <Assistant>{
        return assistantService.list()
    }

    @GetMapping("/{id}")
    fun listOne (@PathVariable id: Long) : Optional<Assistant> {
        return assistantService.listOne(id)
    }

    //Peticiones post - Clase controller
    @PostMapping
    fun save (@RequestBody modelo: Assistant): ResponseEntity<Assistant> {
        return ResponseEntity(assistantService.save(modelo), HttpStatus.OK)
    }

    //clase controller - Petición Put
    @PutMapping
    fun update(@RequestBody modelo: Assistant): ResponseEntity<Assistant> {
        return ResponseEntity(assistantService.update(modelo), HttpStatus.OK)
    }

    //clase  controller-Petiicon Patch
    @PatchMapping
    fun updateName (@RequestBody modelo: Assistant): ResponseEntity<Assistant> {
        return ResponseEntity(assistantService.update(modelo), HttpStatus.OK)
    }

    //clase  controller - Petición Delete
    @DeleteMapping("/delete/{id}")
    fun delete (@PathVariable("id") id: Long):Boolean?{
        return assistantService.delete(id)
    }
}