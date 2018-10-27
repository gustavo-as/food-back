package br.com.xfood.foodback.repository;

import br.com.xfood.foodback.model.County;
import br.com.xfood.foodback.model.People;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CountyRepository extends PagingAndSortingRepository<County, Integer> {
}
