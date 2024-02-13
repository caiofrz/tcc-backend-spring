package tcc.caioferraz.backendapi.domain.expenses;

import org.mapstruct.Mapping;
import tcc.caioferraz.backendapi.dto.ExpenseDTO;
import tcc.caioferraz.backendapi.shared.mapper.Mapper;

@org.mapstruct.Mapper(componentModel = "spring")
public interface ExpensesMapper extends Mapper<ExpenseDTO, ExpenseModel> {


  @Override
  @Mapping(source = "title", target = "title")
  @Mapping(source = "amount", target = "amount")
  @Mapping(source = "date", target = "date")
  @Mapping(source = "description", target = "description")
  ExpenseDTO toDto(ExpenseModel entity);

  @Override
  @Mapping(source = "title", target = "title")
  @Mapping(source = "amount", target = "amount")
  @Mapping(source = "date", target = "date")
  @Mapping(source = "description", target = "description")
  ExpenseModel toEntity(ExpenseDTO dto);
}
