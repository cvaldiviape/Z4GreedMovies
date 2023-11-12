package com.catalogs.core.controller;

//@RestController
//@RequestMapping("api/countries")
//public class CountryController extends HandlerCrudController<CountryDto, Integer> {
//
//    private final CountryService<CountryEntity, CountryDto,Integer> countryService;
//
//    public CountryController(@Qualifier("countryServiceImpl")CountryService<CountryEntity, CountryDto, Integer> countryService) {
//        this.countryService = countryService;
//    }
//
//    @Override
//    public CrudService<CountryDto, Integer> getCrudService() {
//        return this.countryService;
//    }
//
//    @PostMapping("/findAllByListIds")
//    public ResponseEntity<ResponseDto> findAllByListIds(@RequestBody Collection<Integer> listIds) {
//        Collection<CountryDto> result = this.countryService.findAllByListIds(listIds);
//        ResponseDto response = ResponseUtil.ok(ControllerMessageEnum.FIND_ALL, result);
//        return ResponseEntity.ok(response);
//    }
//
//}