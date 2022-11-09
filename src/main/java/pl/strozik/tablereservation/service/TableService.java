package pl.strozik.tablereservation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.strozik.tablereservation.exception.TableeNotFoundException;
import pl.strozik.tablereservation.model.Tablee;
import pl.strozik.tablereservation.repo.TableRepo;

import java.util.List;

@Service
public class TableService {
    private final TableRepo tableRepo;

    @Autowired
    public TableService(TableRepo tableRepo) {
        this.tableRepo = tableRepo;
    }

    public Tablee addTable(Tablee table){
        return this.tableRepo.save(table);
    }

    public List<Tablee> findAllTables(){
        return this.tableRepo.findAll();
    }

    public Tablee findTableeById(Long id){
        return this.tableRepo.findTableeById(id).orElseThrow(() -> new TableeNotFoundException("no table"));
    }

    public Tablee updateTable(Tablee tablee){
        return this.tableRepo.save(tablee);
    }

    public void deleteTable(Long id){
        this.tableRepo.deleteTableeById(id);
    }

}
