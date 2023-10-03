package com.icbc.springdasar.cyclic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CyclicSatu {
    private CyclicDua cyclicDua;
}
