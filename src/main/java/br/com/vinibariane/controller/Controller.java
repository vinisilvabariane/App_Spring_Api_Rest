package br.com.vinibariane.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/primeiraController")
public class Controller {

    //Metodo GET sem Query Param
    @GetMapping("/primeiroMetodo/{id}")
    public String primeiroMetodo(@PathVariable String id) {
        return "O Parametro recebido foi: " + id;
    }

    //Metodo GET com Query Param
    @GetMapping("/metodoComQueryParam")
    public String metodoComQueryParam(@RequestParam String id) {
        return "O Parametro recebido foi: " + id;
    }

    //Metodo GET com Query Param e Map para receber todos os parametros
    @GetMapping("/metodoComQueryParam2")
    public String metodoComQueryParam2(@RequestParam Map<String, String> allParams) {
        return "O Parametro recebido foi: " + allParams.entrySet();
    }

    //Metodo POST com body params e objeto
    @PostMapping("/metodoComBodyParams")
    public String metodoComBodyParams(@RequestBody Usuario user) {
        return "Este metodo recebe o seguinte corpo: " + user.username();
    }

    //Metodo POST com Header Params
    @PostMapping("/metodoComHeaders2")
    public String metodoComBodyParams2(@RequestHeader Map<String, String> allHeaders) {
        return "Este metodo recebe o seguinte corpo: " + allHeaders.entrySet();
    }

    //Metodo POST com Header Params e Map para receber todos os parametros
    @PostMapping("/metodoComHeaders")
    public String metodoComBodyParams(@RequestHeader("name") String name) {
        return "Este metodo recebe o seguinte corpo: " + name;
    }

    //ResponseEntity com status e body
    @GetMapping("metodoResponsyEntity")
    public ResponseEntity<Object> metodoResponsyEntity() {
        return ResponseEntity.status(HttpStatus.CREATED).body("Mensagem de erro");
    }

    //ResponseEntity com objeto e status
    @GetMapping("/metodoResponsyEntityComObjeto/{id}")
    public ResponseEntity<Object> metodoResponseEntityComObjeto(@PathVariable long id) {
        Usuario usuario = new Usuario("vinibariane");
        if (id > 5) {
            return ResponseEntity.status(HttpStatus.OK).body(usuario.username);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Erro ao buscar o usuário");
    }

    // Classe interna para representar o usuário
    public record Usuario(String username) {

        // Construtor, getters e outros métodos podem ser adicionados aqui se necessário
    }
}
