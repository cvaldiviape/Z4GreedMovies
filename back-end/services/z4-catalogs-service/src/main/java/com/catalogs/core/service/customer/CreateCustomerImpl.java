package com.catalogs.core.service.customer;

import com.catalogs.core.entity.CustomerEntity;
import com.catalogs.core.entity.mapper.CustomerMapper;
import com.catalogs.core.repository.CustomerRepository;
import com.shared.core.service.impl.GenericCreateService;
import com.shared.dto.external.catalogs.CustomerDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service("createCustomerImpl")
public class CreateCustomerImpl  extends GenericCreateService<CustomerEntity, CustomerDto, Integer> {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CreateCustomerImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
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
    public CustomerEntity toEntity(CustomerDto customerDto) {
        return this.customerMapper.toEntityIgnoredId(customerDto);
    }

    @Override
    public void verifyUnique(CustomerDto customerDto) {
        Boolean existsByDni = this.customerRepository.existsByDni(customerDto.getDni());
        Boolean existsByEmail = this.customerRepository.existsByEmail(customerDto.getEmail());
        ValidateUtil.validateUnique(existsByDni, ValueEnum.DNI, customerDto.getDni());
        ValidateUtil.validateUnique(existsByEmail, ValueEnum.EMAIL, customerDto.getEmail());
    }

}