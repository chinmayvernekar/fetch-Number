package com.chinmay_vernekar.fetchnumbertask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.concurrent.TimeUnit;

@Service
@Transactional
public class NumberModelService {

    @Autowired
    NumberRepo numberModelRepo;

    Integer sumOfNumber(Integer categoryCode){
        String numarr = Integer.toString(categoryCode);
        char[] numarr2 = numarr.toCharArray();
        Integer sum = 0;
        for (int i=0;i<numarr2.length;i++){
            int a = Integer.parseInt(String.valueOf(numarr2[i]));

            sum = sum + a;
        }
        if(sum.toString().length() > 1){
            return sumOfNumber(sum);

        }
        return sum;
    }

    Integer nextSum(Integer num1, Boolean doInc){
        if(sumOfNumber(num1) == 1 && doInc == true){
            num1+=1;
        }
        while (sumOfNumber(num1) !=1){
            num1+=1;
            nextSum(num1,false);
        }
        return num1;
    }


    public ResponseEntity<?> findNumber(Integer categoryCode) throws InterruptedException {
        NumberModel numberModel = new NumberModel();
        NumberModel numberModel2 = new NumberModel();
        NumberModel oldValue = numberModelRepo.findByCategoryCode(categoryCode);
        // It runs when no number is found.
        if(numberModelRepo.findByCategoryCode(categoryCode) == null){
            numberModel.setCategoryCode(categoryCode);
            numberModel.setValue(0);
            numberModel.setNewValue(nextSum(0,true));

            numberModelRepo.save(numberModel);
        }else {
            numberModel2.setCategoryCode(categoryCode);
            numberModel2.setValue(oldValue.getValue());
            TimeUnit.SECONDS.sleep(5);
            numberModel2.setNewValue(nextSum(categoryCode,true));
            Integer newValue = nextSum(categoryCode,true);
            numberModelRepo.updateValueByCategoryCode(newValue,categoryCode);
            return ResponseEntity.ok(numberModel2);
        }

        return ResponseEntity.ok(numberModel);
    }
}
