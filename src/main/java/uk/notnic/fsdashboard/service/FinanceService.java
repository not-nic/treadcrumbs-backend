package uk.notnic.fsdashboard.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.notnic.fsdashboard.model.Farms.FinanceStats;
import uk.notnic.fsdashboard.repository.FarmRepository;
import uk.notnic.fsdashboard.repository.FinanceRepository;

import java.lang.reflect.Field;
import java.util.List;

@Service
public class FinanceService {

    private final FinanceRepository financeRepository;
    private final FarmRepository farmRepository;
    ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public FinanceService(FinanceRepository financeRepository, FarmRepository farmRepository) {
        this.financeRepository = financeRepository;
        this.farmRepository = farmRepository;
    }

    public List<FinanceStats> getAllFinances() {



        return financeRepository.findAll();
    }

    public void createFinanceStat(FinanceStats financeStat) throws IllegalAccessException {

        // get all declared fields from finance stats
        Field[] financeStatFields = financeStat.getClass().getDeclaredFields();

        double additionalMoney = 0;

        // loop over each declared field in Finance Stats.
        for (Field financeField : financeStatFields) {
            financeField.setAccessible(true);

            // check if the current type is equal to Double,
            if (financeField.getType().equals(Double.class)) {
                Double value = (Double) financeField.get(financeStat);

                // if the value is null, replace it with 0, instead of null.
                if (value == null) {
                    financeField.set(financeStat, 0.0);
                } else {
                    additionalMoney += value;
                }
            }
        }

        // Current Farm Money
        Double currentFarmMoney = this.farmRepository.findById(1).get().getMoney();

        // update total farm money.
        // only one farm is allowed per dashboard, so hardcoding this id value is fine.
        this.farmRepository.findById(1).get().setMoney(currentFarmMoney + additionalMoney);

        financeRepository.save(financeStat);
    }
}
