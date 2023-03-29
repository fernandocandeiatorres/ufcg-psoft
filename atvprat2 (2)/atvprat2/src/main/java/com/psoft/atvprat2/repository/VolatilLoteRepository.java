package com.psoft.atvprat2.repository;

import com.psoft.atvprat2.model.Lote;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Repository
public class VolatilLoteRepository implements LoteRepository<Lote, Long> {

    List<Lote> lotes = new ArrayList<>();

    @Override
    public Lote save(Lote lote) {
        lotes.add(lote);
        return lotes.get(lotes.size() - 1);
    }

    @Override
    public Lote find(Long id) {
        for(Lote lote : lotes){
            if(Objects.equals(lote.getId(), id)){
                return lote;
            }
        }
        throw new RuntimeException("Lote não existe no repositorio");
    }

    @Override
    public List<Lote> findAll() {
        return lotes;
    }
    @Override
    public Lote update(Lote lote) {
        lotes.clear();
        lotes.add(lote);
        return lotes.stream().findFirst().orElse(null);
    }

    @Override
    public void delete(Lote lote) {
        lotes.remove(lote);
    }

    @Override
    public void deleteAll() {
        lotes.clear();
    }

}



