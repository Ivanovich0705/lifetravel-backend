package com.api.lifetravel.payments.service;

import com.api.lifetravel.payments.domain.model.entity.Payment;
import com.api.lifetravel.payments.domain.persistence.PaymentRepository;
import com.api.lifetravel.payments.domain.service.PaymentService;
import com.api.lifetravel.shared.exception.ResourceValidationException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private static final String ENTITY="Payment";

    private final PaymentRepository paymentRepository;

    private final Validator validator;


    @Override
    public List<Payment> getAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment create(Payment payment) {

        Set<ConstraintViolation<Payment>> violations = validator.validate(payment);

        if(!violations.isEmpty()){
            throw new ResourceValidationException(ENTITY, violations);

        }

        return paymentRepository.save(payment) ;
    }


    @Override
    public Payment delete(Long id) {
        Payment payment =paymentRepository.findById(id).orElseThrow(()-> new ResourceValidationException(ENTITY,"id", id));
        return payment;
    }
}
