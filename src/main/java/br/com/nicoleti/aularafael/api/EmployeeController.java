package br.com.nicoleti.aularafael.api;


import br.com.nicoleti.aularafael.dto.EmployeeDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {


    private List<EmployeeDto> listEmployee;
    private int id;

    public EmployeeController(){
        id = 1;
        listEmployee = new ArrayList<>();

    }

    @GetMapping("/department")
    public ResponseEntity<String> funcionarios() {
        String Departamento = "Funcionários";

        return ResponseEntity.ok().body(Departamento);
    }


    @GetMapping("/employee/{parameter}")
    public ResponseEntity<EmployeeDto> employee(@PathVariable int parameter){

        Optional<EmployeeDto> employee = listEmployee.stream().filter(e -> e.getId() == parameter).findFirst();

        if (employee.isPresent()) {
            return ResponseEntity.ok().body(employee.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDto>> employees(){

        return ResponseEntity.ok().body(listEmployee);
    }


    @PostMapping("/employee")
    public ResponseEntity<EmployeeDto> addEmploye(@RequestBody EmployeeDto employeeDto) {

        System.out.println(employeeDto);

        employeeDto.setId(id++);

        listEmployee.add(employeeDto);

        return ResponseEntity.ok().body(employeeDto);

    }

    @DeleteMapping("/employee/{parameter}")
    public ResponseEntity<Boolean> delete(@PathVariable int parameter){

        Optional<EmployeeDto> employee = listEmployee.stream().filter(e -> e.getId() == parameter).findFirst();

        if (employee.isPresent()) {
            listEmployee.remove(employee.get());
            return ResponseEntity.ok().body(true);
        } else {
            return ResponseEntity.ok().body(false);
        }

    }
    @PutMapping("/employee/{parameter}")
    public ResponseEntity<EmployeeDto> updateEmploye(@PathVariable int parameter, @RequestBody EmployeeDto employeeDtoUpdate) {

        Optional<EmployeeDto> employee = listEmployee.stream().filter(e -> e.getId() == parameter).findFirst();

        if (employee.isPresent()) {
            employee.get().setNome(employeeDtoUpdate.getNome());
            employee.get().setCargo(employeeDtoUpdate.getCargo());
            employee.get().setSalario(employeeDtoUpdate.getSalario());
            employee.get().setBeneficios(employeeDtoUpdate.getBeneficios());
            return ResponseEntity.ok().body(employee.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


    }


}
