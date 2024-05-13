package com.catalogs.core.service.customer;

import com.catalogs.core.entity.CustomerEntity;
import com.catalogs.core.entity.mapper.CustomerMapper;
import com.catalogs.core.repository.CustomerRepository;
import com.shared.core.service.impl.GenericFindByIdService;
import com.shared.dto.external.catalogs.CustomerDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;

@Service("findByIdCustomerImpl")
public class FindByIdCustomerImpl extends GenericFindByIdService<CustomerEntity, CustomerDto, Integer> {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public FindByIdCustomerImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerDto toDto(CustomerEntity customerEntity) {
        return this.customerMapper.toDto(customerEntity);
    }

    @Override
    public CustomerEntity findEntityById(Integer idCustomer) {
        return this.customerRepository.findById(idCustomer)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.CUSTOMER.getValue(), idCustomer));
    }

}