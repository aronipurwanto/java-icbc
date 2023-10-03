package com.icbc.springdasar.cyclic;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CyclicDua {
    private CyclicTiga cyclicTiga;
}
