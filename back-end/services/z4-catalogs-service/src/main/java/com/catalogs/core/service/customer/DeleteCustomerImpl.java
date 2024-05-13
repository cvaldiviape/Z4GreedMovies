package com.catalogs.core.service.customer;

import com.catalogs.core.entity.CustomerEntity;
import com.catalogs.core.entity.mapper.CustomerMapper;
import com.catalogs.core.repository.CustomerRepository;
import com.shared.core.service.impl.GenericDeleteService;
import com.shared.dto.external.catalogs.CustomerDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("deleteCustomerImpl")
public class DeleteCustomerImpl extends GenericDeleteService<CustomerEntity, CustomerDto, Integer> {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public DeleteCustomerImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public JpaRepository<CustomerEntity, Integer> getJpaRepository() {
        return this.customerRepository;
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