package com.catalogs.core.controller.interfaces;

import com.shared.core.controller.*;

public interface ICountryController <DTO, ID> extends
        FindAllController<DTO>,
        FindByIdController<DTO, ID>,
        CreateController<DTO>,
        UpdateController<DTO, ID>,
        DeleteController<DTO, ID>,
        FindAllByListIdsController<DTO, ID> {
}