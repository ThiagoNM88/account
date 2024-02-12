package br.com.nicoleti.aularafael.api;

import br.com.nicoleti.aularafael.dto.PersonDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
public class HelloWorldController {

    @GetMapping("/hello-world")
    public ResponseEntity<String> helloworld(){
        String ola = "Ola Mundo";

        return ResponseEntity.ok().body(ola);
    }
    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        String Home = "Bem vindo ao mundo digital";
        return ResponseEntity.ok().body(Home);
    }

    @GetMapping("/person")
    public ResponseEntity<PersonDto> person(){
        PersonDto person = new PersonDto();
        person.setNome("Roberto");
        person.setSobrenome("da Silva");
        person.setIdade(65);
        person.setSalario(20000);
        return ResponseEntity.ok().body(person);
    }

    @GetMapping("/persons")
    public ResponseEntity<List<PersonDto>> persons(){
        PersonDto person1 = new PersonDto();
        person1.setNome("Roberto");
        person1.setSobrenome("da Silva");
        person1.setIdade(65);
        person1.setSalario(20000);

        PersonDto person2 = new PersonDto();
        person2.setNome("Thiago");
        person2.setSobrenome("Nicoleti");
        person2.setIdade(35);
        person2.setSalario(15000);

        PersonDto person3 = new PersonDto();
        person3.setNome("Davi");
        person3.setSobrenome("Nicoleti");
        person3.setIdade(6);
        person3.setSalario(10000);

        List<PersonDto> listPessoas = new ArrayList<PersonDto>();

        listPessoas.add(person1);
        listPessoas.add(person2);
        listPessoas.add(person3);

        return ResponseEntity.ok().body(listPessoas);

    }


}
