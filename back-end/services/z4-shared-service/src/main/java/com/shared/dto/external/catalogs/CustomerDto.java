package com.shared.dto.external.catalogs;

import com.shared.utils.filter.Searchable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CustomerDto implements Searchable<Integer> {

    private Integer idCustomer;
    private String name;
    private String lastName;
    private String dni;
    private String email;
    private String password;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDto that = (CustomerDto) o;
        return Objects.equals(idCustomer, that.idCustomer) && Objects.equals(name, that.name) && Objects.equals(lastName, that.lastName) && Objects.equals(dni, that.dni) && Objects.equals(email, that.email) && Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCustomer, name, lastName, dni, email, password);
    }

    @Override
    public Integer getSearcheableField() {
        return this.idCustomer;
    }

}
