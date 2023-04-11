package com.github.artsiomshshshsk.shopping.model.cart;

import com.github.artsiomshshshsk.shopping.model.user.Name;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Builder
public record CartResponse(
        Long id,
        BigDecimal value,
        Name ownerName
) {
}
