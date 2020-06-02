package fun4.nonogrambackend.repositories;

import fun4.nonogrambackend.domain.Nonogram;
import fun4.nonogrambackend.domain.NonogramSimple;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;


public interface SortAndPageNonogramRepository extends PagingAndSortingRepository<Nonogram, Integer> {

    @Query("select new fun4.nonogrambackend.domain.NonogramSimple(t.id, t.name, t.user.username) from Nonogram t")
    Page<NonogramSimple> findAllFiltered(Pageable pageable);
}
