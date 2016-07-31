package joachim.repository;

import org.springframework.data.repository.CrudRepository;
import joachim.model.Currency;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {
}