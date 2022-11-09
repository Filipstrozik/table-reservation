package pl.strozik.tablereservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.strozik.tablereservation.model.Tablee;
import pl.strozik.tablereservation.service.TableService;

import java.util.List;

@RestController
@RequestMapping("/tables")
public class TableApi {

    private final TableService tableService;

    @Autowired
    public TableApi(TableService tableService) {
        this.tableService = tableService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Tablee>> getAllTables(){
        List<Tablee> tables = tableService.findAllTables();
        return new ResponseEntity<>(tables, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Tablee> getTableById(@PathVariable("id") Long id){
        Tablee table = tableService.findTableeById(id);
        return new ResponseEntity<>(table, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Tablee> addTable(@RequestBody Tablee tablee){
        Tablee newTable = tableService.addTable(tablee);
        return new ResponseEntity<>(newTable, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Tablee> updateTable(@RequestBody Tablee tablee){
        Tablee updateTable = tableService.addTable(tablee);
        return new ResponseEntity<>(updateTable, HttpStatus.OK);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteTable(@PathVariable("id") Long id){
        tableService.deleteTable(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
