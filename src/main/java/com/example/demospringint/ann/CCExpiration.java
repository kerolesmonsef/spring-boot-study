package com.example.demospringint.ann;

import javax.validation.constraints.Pattern;

@Pattern(regexp = "^(0[1-9]|1[0-2])([\\/])([1-9][0-9])$", message = "Must be formatted MM/YY")
public @interface CCExpiration {
}
