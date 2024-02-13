package tcc.caioferraz.backendapi.domain.expenses;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tcc.caioferraz.backendapi.dto.ExpenseDTO;
import tcc.caioferraz.backendapi.dto.PageResponseDTO;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ExpensesService {

  private final ExpensesRepository repository;

  public PageResponseDTO findAll(Pageable pageable) {
    Page<ExpenseModel> page = this.repository.findAll(pageable);
    return new PageResponseDTO(
            page.getNumber(),
            page.getSize(),
            page.getTotalElements(),
            page.getTotalPages(),
            page.getContent());
  }

  public ExpenseModel findOne(UUID uid) {
    return this.find(uid);
  }

  @Transactional
  public ExpenseModel save(ExpenseModel expense) {
    return this.repository.save(expense);
  }

  @Transactional
  public ExpenseModel update(UUID uid, ExpenseDTO expenseDTO) {
    ExpenseModel expense = this.find(uid);
    BeanUtils.copyProperties(expenseDTO, expense);
    return this.repository.save(expense);
  }

  @Transactional
  public void delete(UUID uid) {
    ExpenseModel expense = this.find(uid);
    this.repository.deleteById(uid);
  }

  private ExpenseModel find(UUID uid) {
    return this.repository.findById(uid)
            .orElseThrow(() -> new EntityNotFoundException("Despesa não encontrada!"));
  }
}
