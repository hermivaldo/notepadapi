package br.com.hermivaldo.notepadapi.controller

import br.com.hermivaldo.notepadapi.model.Nota
import br.com.hermivaldo.notepadapi.service.NotaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin
@RequestMapping(value = "/nota")
class NotaController {

    @Autowired
    lateinit var notaService: NotaService

    @GetMapping
    fun buscarTodos(): List<Nota>{
        return notaService.buscarTodas()
    }

    @GetMapping(value = "/titulo/{titulo}")
    fun buscar(@PathVariable(value = "titulo") titulo: String) : Nota{
        return this.notaService.buscar(titulo)
    }

    @PostMapping
    fun salvar(@RequestBody nota: Nota){
        this.notaService.salvar(nota)
    }

}