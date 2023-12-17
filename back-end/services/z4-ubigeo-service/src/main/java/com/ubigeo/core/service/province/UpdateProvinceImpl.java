package com.ubigeo.core.service.province;

import com.ubigeo.core.entity.DepartmentEntity;
import com.ubigeo.core.entity.ProvinceEntity;
import com.ubigeo.core.entity.mapper.DepartmentMapper;
import com.ubigeo.core.entity.mapper.ProvinceMapper;
import com.ubigeo.core.repository.DepartmentRepository;
import com.ubigeo.core.repository.ProvinceRepository;
import com.shared.core.service.UpdateService;
import com.shared.dto.external.ubigeo.DepartmentDto;
import com.shared.dto.external.ubigeo.ProvinceDto;
import com.shared.enums.ValueEnum;
import com.shared.utils.ValidateUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("updateProvinceImpl")
@Transactional
public class UpdateProvinceImpl implements UpdateService<ProvinceDto, Integer> {

    private final ProvinceRepository provinceRepository;
    private final DepartmentRepository departmentRepository;
    private final ProvinceMapper provinceMapper;
    private final DepartmentMapper departmentMapper;

    public UpdateProvinceImpl(ProvinceRepository provinceRepository, DepartmentRepository departmentRepository, ProvinceMapper provinceMapper, DepartmentMapper departmentMapper) {
        this.provinceRepository = provinceRepository;
        this.departmentRepository = departmentRepository;
        this.provinceMapper = provinceMapper;
        this.departmentMapper = departmentMapper;
    }

    @Override
    public ProvinceDto update(Integer idProvince, ProvinceDto provinceDto) {
        ProvinceEntity provinceEntity = this.findProvinceEntityById(idProvince);
        this.validateUniqueFields(idProvince, provinceDto);
        this.setComplementaryData(provinceDto);
        provinceEntity.setDepartment(null);
        this.provinceMapper.updateEntityFromDtoIgnoredId(provinceDto, provinceEntity);

        ProvinceEntity provinceUpdated = this.provinceRepository.save(provinceEntity);
        return this.provinceMapper.toDto(provinceUpdated);
    }

    // ------------------------------------------------------------------------- utils ------------------------------------------------------------------------- //
    private ProvinceEntity findProvinceEntityById(Integer idProvince) {
        return this.provinceRepository.findById(idProvince)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.PROVINCE.getValue(), idProvince));
    }

    private void validateUniqueFields(Integer idProvince, ProvinceDto provinceDto) {
        Boolean existsCode = this.provinceRepository.existsByCodeAndIdProvinceNot(provinceDto.getCode(), idProvince);
        Boolean existsName = this.provinceRepository.existsByNameAndIdProvinceNot(provinceDto.getName(), idProvince);
        ValidateUtil.validateUnique(existsCode, ValueEnum.CODE, provinceDto.getCode());
        ValidateUtil.validateUnique(existsName, ValueEnum.NAME, provinceDto.getName());
    }

    private void setComplementaryData(ProvinceDto provinceDto) {
        Integer idDepartment = provinceDto.getDepartment().getIdDepartment();
        DepartmentEntity departmentEntity = this.findDepartmentEntityById(idDepartment);

        DepartmentDto departmentDto = this.departmentMapper.toDtoIgnoredListProvinces(departmentEntity);
        provinceDto.setDepartment(departmentDto);
    }

    private DepartmentEntity findDepartmentEntityById(Integer idDepartment) {
        return this.departmentRepository.findById(idDepartment)
                .orElseThrow(() -> ValidateUtil.throwNotFoundException(ValueEnum.DEPARTMENT.getValue(), idDepartment));
    }

}