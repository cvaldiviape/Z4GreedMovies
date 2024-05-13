package com.catalogs.core.service.customer;

import com.catalogs.core.entity.CustomerEntity;
import com.catalogs.core.entity.mapper.CustomerMapper;
import com.catalogs.core.repository.CustomerRepository;
import com.shared.core.service.impl.GenericFindAllService;
import com.shared.dto.external.catalogs.CustomerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import java.util.Collection;

@Service("findAllCustomerImpl")
public class FindAllCustomerImpl extends GenericFindAllService<CustomerEntity, CustomerDto, Integer> {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public FindAllCustomerImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public JpaRepository<CustomerEntity, Integer> getJpaRepository() {
        return this.customerRepository;
    }

    @Override
    public Collection<CustomerDto> toListDtos(Collection<CustomerEntity> listEntities) {
        return this.customerMapper.toListDtos(listEntities);
    }

}