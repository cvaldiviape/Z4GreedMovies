package com.ubigeo.core.service.province;

import com.ubigeo.core.entity.DepartmentEntity;
import com.ubigeo.core.entity.ProvinceEntity;
import com.ubigeo.core.entity.mapper.DepartmentMapper;
import com.ubigeo.core.entity.mapper.ProvinceMapper;
import com.ubigeo.core.repository.DepartmentRepository;
import com.ubigeo.core.repository.ProvinceRepository;
import com.shared.core.service.CreateService;
import com.shared.dto.external.ubigeo.DepartmentDto;
import com.shared.dto.external.ubigeo.ProvinceDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("createProvinceImpl")
@Transactional
public class CreateProvinceImpl implements CreateService<ProvinceDto> {

    private final ProvinceRepository provinceRepository;
    private final DepartmentRepository departmentRepository;
    private final ProvinceMapper provinceMapper;
    private final DepartmentMapper departmentMapper;

    public CreateProvinceImpl(ProvinceRepository provinceRepository, DepartmentRepository departmentRepository, ProvinceMapper provinceMapper, DepartmentMapper departmentMapper) {
        this.provinceRepository = provinceRepository;
        this.departmentRepository = departmentRepository;
        this.provinceMapper = provinceMapper;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public ProvinceDto create(ProvinceDto provinceDto) {
        this.validateUniqueFields(provinceDto);
        this.setComplementaryData(provinceDto);
        ProvinceEntity provinceEntity = this.provinceMapper.toEntity(provinceDto);
        ProvinceEntity provinceCreated = this.provinceRepository.save(provinceEntity);
        return this.provinceMapper.toDtoCustom(provinceCreated);
    }

    // ------------------------------------------------------------------------- utils ------------------------------------------------------------------------- //
    private void validateUniqueFields(ProvinceDto provinceDto) {
        Boolean existsCode = this.provinceRepository.existsByCode(provinceDto.getCode());
        Boolean existsName = this.provinceRepository.existsByName(provinceDto.getName());
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, provinceDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, provinceDto.getName());
    }

    private void setComplementaryData(ProvinceDto provinceDto) {
        Integer idDepartment = provinceDto.getDepartment().getIdDepartment();
        DepartmentEntity departmentEntity = this.findDepartmentEntityById(idDepartment);
        DepartmentDto departmentDto = this.departmentMapper.toDtoIgnoredListProvinces(departmentEntity);
        provinceDto.setDepartment(departmentDto);
    }

    private DepartmentEntity findDepartmentEntityById(Integer idDeparment) {
        return this.departmentRepository.findById(idDeparment)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.DEPARTMENT.getValue(), idDeparment));
    }

}